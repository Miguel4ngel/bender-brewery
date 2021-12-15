package com.benderbrewery.domain.util;

import org.springframework.stereotype.Component;

@Component
public class PriceCalculator {

    public Double getPriceForCurrency(Integer currencyValue, Double beerPrice, Integer quantity){
        return (beerPrice*quantity)/currencyValue;
    }

}
