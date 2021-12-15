package com.benderbrewery.data.connector.currency.connector;

import com.benderbrewery.data.connector.currency.exception.CurrencyNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CurrencyApiConnector {

    private static final String CONVERTER_URL = "http://localhost:8083/currency/${code}";

    private RestTemplate restTemplate = new RestTemplate();

    public Integer getCurrencyValue(String code){
        ResponseEntity<Map> response
                = restTemplate.getForEntity("http://localhost:8083/currency/USD", Map.class);
        Map<String, Integer> currencyValue = response.getBody();
        if(response.getStatusCodeValue() == 404){
            CurrencyNotFoundException.thrown();
        }
        return currencyValue.get("value");
    }
}
