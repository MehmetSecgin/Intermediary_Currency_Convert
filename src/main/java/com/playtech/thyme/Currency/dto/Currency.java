package com.playtech.thyme.Currency.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@Getter
@Setter
public class Currency {
    private String convTo;
    private String convFrom;
    private String intermediary;
    private double amount;
    private double profit;

    public Currency(String convTo, String convFrom, String intermediary) {
        this.convTo = convTo;
        this.convFrom = convFrom;
        this.intermediary = intermediary;
    }

    public void setAmount(double amount) {
        NumberFormat formatter = new DecimalFormat("#0.0000");
        formatter.setRoundingMode(RoundingMode.DOWN);
        this.amount = Double.parseDouble(formatter.format(amount));
    }

    public void setProfit(double profit) {
        NumberFormat formatter = new DecimalFormat("#0.0000");
        formatter.setRoundingMode(RoundingMode.DOWN);
        this.profit = Double.parseDouble(formatter.format(profit % 0.010));
    }

}
