package com.crypto.btctracker.services;

import com.crypto.btctracker.constants.Constants;
import com.crypto.btctracker.entities.PriceTracker;
import com.crypto.btctracker.pojo.PaginatedPriceResponseObject;
import com.crypto.btctracker.repositories.PriceTrackerRepository;
import com.crypto.btctracker.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CoinPriceService {

    @Autowired
    PriceTrackerRepository repository;

    public ResponseEntity<PaginatedPriceResponseObject> getPricesByDate(String coin, LocalDate date, Pageable page){
        Page<PriceTracker> resultSet = repository.findPriceTrackersByCoinNameAndDateOrderByTimestamp(coin, date, page);
        String getCurrentUrl = Utility.getInternalURL(date, coin, page.getPageNumber(), page.getOffset());
        String getNextUrl = "";

        if(resultSet.hasNext()){
      getNextUrl =
          Utility.getInternalURL(
              date,
              coin,
              page.getPageNumber() + 1,
              Constants.PAGE_SIZE);
        }

        PaginatedPriceResponseObject output = new PaginatedPriceResponseObject(resultSet.getContent(), resultSet.getTotalElements(), getCurrentUrl, getNextUrl);

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
