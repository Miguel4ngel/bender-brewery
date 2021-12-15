package com.benderbrewery.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BeerDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("brewery")
    private String brewery;

    @JsonProperty("country")
    private String country;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("id")
    private Integer id;

    public BeerDto(String name, String brewery, String country, Double price, String currency, Integer id) {
        this.name = name;
        this.brewery = brewery;
        this.country = country;
        this.price = price;
        this.currency = currency;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
