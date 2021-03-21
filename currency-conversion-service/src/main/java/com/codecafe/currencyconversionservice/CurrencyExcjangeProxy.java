package com.codecafe.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExcjangeProxy {

    @GetMapping("currency-exchange/{from}/to/{to}/")
    public CurrencyConversion getExchange(@PathVariable String from, @PathVariable String to);
}
