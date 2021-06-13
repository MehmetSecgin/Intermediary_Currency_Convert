package com.playtech.thyme.Currency.Controller;
import com.playtech.thyme.Currency.Service.CurrencyService;
import com.playtech.thyme.Currency.dto.Currency;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class CurrencyController {
    @Resource
    private final CurrencyService currencyService;

    @RequestMapping(value = "/deneme")
    public String showForm() {
      return "index";
    }

    @GetMapping("/exchange")
    public static String exchange(
            @RequestParam Optional<String> convFrom,
            @RequestParam Optional<String> convTo,
            @RequestParam Optional<List<String>> inter,
            @RequestParam Optional<Double> amount, Model model) {
        List<Currency> curList = CurrencyService.exchange(
                convTo.orElse("EUR"),
                convFrom.orElse("USD"),
                inter.orElse(List.of("SGD", "MYR", "RUB", "SEK", "AUD", "JPY", "TRY", "HKD", "CAD", "INR")),
                amount.orElse(100.0));

        model.addAttribute("curList",curList );
        model.addAttribute("profit",CurrencyService.returnProfit(curList));
        return "exchange";
    }
}
