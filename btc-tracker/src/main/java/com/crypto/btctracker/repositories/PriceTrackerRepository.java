package com.crypto.btctracker.repositories;

import com.crypto.btctracker.entities.PriceTracker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;


public interface PriceTrackerRepository extends PagingAndSortingRepository<PriceTracker, Long> {
    Page<PriceTracker> findPriceTrackersByCoinNameAndDateOrderByTimestamp(String coin, LocalDate date, Pageable pageable);



}
