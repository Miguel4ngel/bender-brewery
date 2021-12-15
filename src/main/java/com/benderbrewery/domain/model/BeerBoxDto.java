package com.benderbrewery.domain.model;

public class BeerBoxDto {

    private String name;
    private Double price;
    private String currency;

    public BeerBoxDto(String name, Double price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public static BeerBoxDto withCurrencyValue(String name, Double price, String currency){
        return new BeerBoxDto(name, price, currency);
    }

    public void setName(String name) {
        this.name = name;
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
}
