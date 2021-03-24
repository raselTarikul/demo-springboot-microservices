package com.codecafe.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExcjangeProxy currencyExcjangeProxy;

    @GetMapping("currency-conversion/{from}/to/{to}/{quantity}")
    private CurrencyConversion getConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity){

        CurrencyConversion cv = currencyExcjangeProxy.getExchange(from, to);

        return new CurrencyConversion(cv.getId(), from, to, quantity, cv.getConversionMultiple(), cv.getConversionMultiple().multiply(quantity), cv.getEnvironment());

    }
}
