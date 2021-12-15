package com.benderbrewery.domain.service;

import com.benderbrewery.data.connector.currency.connector.CurrencyApiConnector;
import com.benderbrewery.data.entity.Beer;
import com.benderbrewery.data.repository.BeerRepository;
import com.benderbrewery.domain.mapper.BeerMapper;
import com.benderbrewery.domain.model.BeerBoxDto;
import com.benderbrewery.domain.model.BeerDto;
import com.benderbrewery.domain.model.exception.BeerAlreadyExistsException;
import com.benderbrewery.domain.model.exception.BeerNotFoundException;
import com.benderbrewery.domain.util.PriceCalculator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BeerService {

    private final BeerRepository beerRepository;
    private final CurrencyApiConnector currencyApiConnector;
    private final BeerMapper beerMapper;
    private final PriceCalculator priceCalculator;

    public BeerService(BeerRepository beerRepository, CurrencyApiConnector currencyApiConnector, BeerMapper beerMapper, PriceCalculator priceCalculator) {
        this.beerRepository = beerRepository;
        this.currencyApiConnector = currencyApiConnector;
        this.beerMapper = beerMapper;
        this.priceCalculator = priceCalculator;
    }

    public BeerDto findById(Integer beerId){
        Beer beer = beerRepository.findById(beerId).orElseThrow(BeerNotFoundException::thrown);
        return beerMapper.fromBeerEntity(beer);
    }

    public List<BeerDto> findAll(){
        List<BeerDto> beerDtoList = new ArrayList<>();
        beerRepository.findAll().stream().forEach(beer -> {
            beerDtoList.add(beerMapper.fromBeerEntity(beer));
        });
        return beerDtoList;
    }

    public void save(BeerDto beerDto){
        beerRepository.findById(beerDto.getId()).ifPresent(beer -> BeerAlreadyExistsException.thrown());
        beerRepository.save(beerMapper.fromBeerDto(beerDto));
    }

    public BeerBoxDto getBoxPrice(Integer beerId, String currency, Integer quantity){
        Beer beer = beerRepository.findById(beerId).orElseThrow(BeerNotFoundException::thrown);
        Integer currencyValue = currencyApiConnector.getCurrencyValue(currency);
        return BeerBoxDto.withCurrencyValue(beer.getName(), priceCalculator.getPriceForCurrency(currencyValue, beer.getPrice(), quantity), currency);
    }
}
