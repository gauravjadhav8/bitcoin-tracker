package com.crypto.btctracker.pojo;


import com.crypto.btctracker.entities.PriceTracker;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@JsonSerialize
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedPriceResponseObject {
    List<PriceTracker> content;
    Long count;
    String currentUrl, nextUrl;
}
