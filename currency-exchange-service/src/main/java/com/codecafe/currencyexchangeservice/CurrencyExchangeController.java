package com.codecafe.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyExchangeEntity getExchangeValue(@PathVariable String from, @PathVariable String to){

        return new CurrencyExchangeEntity(1000l, from, to, new BigDecimal(Math.random()), environment.getProperty("local.server.port"));
    }
}
