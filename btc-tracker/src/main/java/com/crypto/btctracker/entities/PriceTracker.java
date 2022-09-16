package com.crypto.btctracker.entities;

import com.crypto.btctracker.listeners.PriceTrackEventListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="price_tracker")
@ToString
@NoArgsConstructor
@Getter
@EntityListeners(PriceTrackEventListener.class)
public class PriceTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
            @JsonIgnore
    long id;

    @CreationTimestamp
    @JsonSerialize
    Date timestamp;

    @CreationTimestamp
    @JsonIgnore
    LocalDate date;

    @Column(name = "coin_name")
    @NotNull
            @JsonSerialize
    String coinName;

    @Column(name = "coin_price")
    @NotNull
    @JsonSerialize
    Double coinPrice;

    public PriceTracker(String name, Double price){
        this.coinName = name;
        this.coinPrice = price;
    }

}
