package com.crypto.btctracker.services;

import com.crypto.btctracker.entities.PriceTracker;
import com.crypto.btctracker.interfaces.DataAPIService;
import com.crypto.btctracker.pojo.CoinGeckoResponse;
import com.crypto.btctracker.repositories.PriceTrackerRepository;
import com.crypto.btctracker.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CoinGeckoService implements DataAPIService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoinGeckoService.class);
    CoinGeckoService(){
        LOGGER.info("Starting from a constructor.");
        client = WebClient.builder().baseUrl(Utility.getBaseURL()).build();
    }

    WebClient client;
    @Autowired
    PriceTrackerRepository priceTrackerRepository;


    @Override
    @Scheduled(fixedRate = 30000L) // fixedDelay -> if we want to run it after execution of earlier one.
    public void getAndUpdateRemoteData() {
        LOGGER.info("Retrieving data from CoinGecko.");
        CoinGeckoResponse coinGeckoResponse = client.get().retrieve().bodyToMono(CoinGeckoResponse.class).block();
        LOGGER.info("Updating data to database");
        LOGGER.info("BTC Value Received: " + coinGeckoResponse.getBitcoin().getUsd());
        PriceTracker priceObject = new PriceTracker("btc", coinGeckoResponse.getBitcoin().getUsd());
        priceTrackerRepository.save(priceObject);
        LOGGER.info(String.valueOf(priceTrackerRepository.findAll()));
        LOGGER.info("Data retrieved and update in DB.");

    }
}
