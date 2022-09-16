package com.crypto.btctracker.utils;

import com.crypto.btctracker.constants.Constants;

import java.time.LocalDate;


public class Utility {



    public static String getBaseURL() {
        return Constants.BASE_URL;
    }

    public static String getInternalURL(LocalDate date, String coin, int page, Long offset) {
        return String.format(Constants.REQUEST_URL, coin, date, page, offset);
    }


}
