package com.codecafe.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to){

        return new CurrencyExchangeValue(1000l, from, to, BigDecimal.TEN, environment.getProperty("local.server.port"));
    }
}
