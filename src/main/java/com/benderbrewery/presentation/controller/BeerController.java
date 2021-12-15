package com.benderbrewery.presentation.controller;

import com.benderbrewery.data.entity.Beer;
import com.benderbrewery.domain.model.BeerBoxDto;
import com.benderbrewery.domain.model.BeerDto;
import com.benderbrewery.domain.service.BeerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/beers/{beerId}")
    public ResponseEntity<BeerDto> searchBeerById(@PathVariable("beerId") Integer beerId){
        return ResponseEntity.ok(beerService.findById(beerId));
    }

    @GetMapping("/beers")
    public ResponseEntity<List<BeerDto>> searchBeers(){
        return ResponseEntity.ok(beerService.findAll());
    }

    @PostMapping("/beers")
    public ResponseEntity<String> addBeers(@RequestBody BeerDto beerDto){
        beerService.save(beerDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/beers/{beerId}/boxprice")
    public ResponseEntity<BeerBoxDto> boxBeerPriceById(@RequestParam(name = "quantity", required = true)Integer quantity,
                                               @RequestParam(name = "currency", required = true)String currency,
                                               @PathVariable("beerId") Integer beerId){
        return ResponseEntity.ok(beerService.getBoxPrice(beerId, currency, quantity));


    }

}
