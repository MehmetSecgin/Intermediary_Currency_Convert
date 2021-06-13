package com.playtech.thyme.Currency.Util;

import com.playtech.thyme.Currency.Service.CurrencyService;
import com.playtech.thyme.Currency.dto.Currency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class convertUtilTest {

    @Test
    @DisplayName("check if it works")
    void currencyWorks() {
        assertEquals(1.21085, ConvertUtil.convert("USD", "EUR", 1));
    }

    @Test
    @DisplayName("Check if intermediary works")
    public void intermediaryWorksNormally() {
        assertEquals(0.8258353906999999, ConvertUtil.intermediary("EUR", "USD", "SGD", 1));

    }

    @Test
    @DisplayName("Check if Service returns list")
    public void returnListTest(){
        List<Currency> a = CurrencyService.exchange("EUR","USD", List.of("TRY"),1);
        assertNotNull(a);
    }

    @Test
    @DisplayName("Checking the Service methods")
    public void serviceMethodCheck(){
        System.out.println(CurrencyService.addCurrencies("EUR","USD","TRY",1.0).getAmount());
    }

}
