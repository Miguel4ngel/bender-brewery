package com.benderbrewery.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "beer")
public class Beer implements Serializable {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "brewery")
    private String brewery;

    @Column(name = "country")
    private String country;

    @Column(name = "price")
    private Double price;

    @Column(name = "currency")
    private String currency;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
