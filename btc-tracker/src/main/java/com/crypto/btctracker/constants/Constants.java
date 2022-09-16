package com.crypto.btctracker.constants;

public class Constants {

    public static String BASE_URL="https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd";
    public static String REQUEST_URL="http://localhost:8080/api/prices/%s?date=%s&page=%d&offset=%d";
    public static long PAGE_SIZE = 10;
    public static String PRICE_CHANGE_ALERT_SUBJECT="Alert! Bitcoin Price %s";
    public static String PRICE_CHANGE_ALERT_BODY="Bitcoin Price %.2f";
}
