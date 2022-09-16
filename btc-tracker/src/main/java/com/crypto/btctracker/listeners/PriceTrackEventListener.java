package com.crypto.btctracker.listeners;

import com.crypto.btctracker.constants.Constants;
import com.crypto.btctracker.entities.PriceTracker;
import com.crypto.btctracker.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.PostPersist;

public class PriceTrackEventListener {

    Logger LOGGER = LoggerFactory.getLogger(PriceTrackEventListener.class);

    @Autowired
    EmailService emailService;

    @Value("${spring.mail.username}") String username;
    @Value("${trigger.price.min}") Double minTriggerPrice;
    @Value("${trigger.price.max}") Double maxTriggerPrice;



    @PostPersist
    private void updateUser(PriceTracker priceTracker){
        if(priceTracker.getCoinPrice()<minTriggerPrice){
            emailService.sendEmail(username, String.format(Constants.PRICE_CHANGE_ALERT_BODY, priceTracker.getCoinPrice()), String.format(Constants.PRICE_CHANGE_ALERT_SUBJECT, "dropped!"));
        }

        if(priceTracker.getCoinPrice()>maxTriggerPrice){
            emailService.sendEmail(username, String.format(Constants.PRICE_CHANGE_ALERT_BODY, priceTracker.getCoinPrice()), String.format(Constants.PRICE_CHANGE_ALERT_SUBJECT, "skyrocketed!"));
        }

        LOGGER.info("Reached in the EventListener");
    }

}
