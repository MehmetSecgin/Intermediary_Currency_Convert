package com.playtech.thyme.Currency.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profit {
    private double minProfit;
    private String minProfitCurrency;
    private double maxProfit;
    private String maxProfitCurrency;

}
