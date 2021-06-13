package com.playtech.thyme.Currency.Service;

import com.playtech.thyme.Currency.Util.ConvertUtil;
import com.playtech.thyme.Currency.dto.Currency;
import com.playtech.thyme.Currency.dto.Profit;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CurrencyService {

    public static List<Currency> exchange(String convTo, String convFrom, List<String> inter, double quantity) {
        List<Currency> currencyList = new ArrayList<>();
        for (String x : inter) {
            Currency currency = addCurrencies(convTo, convFrom, x, quantity);
            currencyList.add(currency);
        }
        return currencyList;
    }

    public static Currency addCurrencies(String convTo, String convFrom, String inter, double quantity) {
        Currency currency = new Currency(convTo, convFrom, inter);
        currency.setAmount(ConvertUtil.intermediary(convTo, convFrom, inter, quantity));
        currency.setProfit(currency.getAmount());
        return currency;
    }

    public static Profit returnProfit(List<Currency> profitList) {
        Profit profit = new Profit();
        profit.setMaxProfit(profitList
                .stream()
                .max(Comparator.comparing(Currency::getProfit))
                .get().getProfit());
        profit.setMaxProfitCurrency(profitList
                .stream()
                .max(Comparator.comparing(Currency::getProfit))
                .get().getIntermediary());
        profit.setMinProfit(profitList
                .stream()
                .min(Comparator.comparing(Currency::getProfit))
                .get().getProfit());
        profit.setMinProfitCurrency(profitList
                .stream()
                .min(Comparator.comparing(Currency::getProfit))
                .get().getIntermediary());
        return profit;
    }
}
