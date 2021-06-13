package com.playtech.thyme.Currency.Util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;

public class ConvertUtil {

    @SneakyThrows
    public static double convert(String convTo, String convFrom, double quantity) {
        HttpResponse<String> response = Unirest.get(String.format("https://currency-exchange.p.rapidapi.com/exchange?to=%1s&from=%2s&q=%,.4f", convTo, convFrom, quantity))
                .header("x-rapidapi-key", "3eab38d246msh1fff8e25485d5dfp12ec01jsn1d6a61c195e2")
                .header("x-rapidapi-host", "currency-exchange.p.rapidapi.com")
                .asString();
        String body = response.getBody();
        return (Double.parseDouble(body) * quantity);
    }

    public static double intermediary(String convTo, String convFrom, String inter, double quantity) {

        double a = convert(inter, convFrom, quantity);
        return convert(convTo, inter, a);
    }
}
