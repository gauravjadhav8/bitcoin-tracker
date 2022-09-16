package com.crypto.btctracker.repositories;

import com.crypto.btctracker.entities.PriceTracker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PriceTrackerRepository extends PagingAndSortingRepository<PriceTracker, Long> {
//public interface PriceTrackerRepository extends JpaRepository<PriceTracker, Long> {

//    List<PriceTracker> findPriceTrackersByCoinNameAndTimestampAfterOrderByTimestamp(String coin, LocalDate date);
//    Page<PriceTracker> findPriceTrackersByCoinNameAndTimestampAfterOrderByTimestamp(String coin, LocalDate date, Pageable pageable);

    Page<PriceTracker> findPriceTrackersByCoinNameAndDateOrderByTimestamp(String coin, LocalDate date, Pageable pageable);
//    List<PriceTracker> findPriceTrackersByCoinNameAndTimestampContaining(String coin, Date date);
//    Page<PriceTracker> findPriceTrackersByCoinNameOrderByTimestamp(String coin, Pageable page);



}
