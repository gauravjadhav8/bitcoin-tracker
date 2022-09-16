package com.crypto.btctracker.controllers;


import com.crypto.btctracker.pojo.PaginatedPriceResponseObject;
import com.crypto.btctracker.services.CoinPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
@RequestMapping("/api")
public class PriceTrackerController {

@Autowired CoinPriceService coinPriceService;

@RequestMapping("/prices/{coin}")
@ResponseBody
ResponseEntity<PaginatedPriceResponseObject> getPriceByDate(@PathVariable String coin,
                                                            @RequestParam(defaultValue = "") @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate date,
                                                            @RequestParam(defaultValue = "10") Integer limit,
                                                            @RequestParam(defaultValue = "0") Integer offset){
    return coinPriceService.getPricesByDate(coin, date, PageRequest.of(offset, limit));
}


}

