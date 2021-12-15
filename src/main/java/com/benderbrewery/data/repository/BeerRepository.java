package com.benderbrewery.data.repository;

import com.benderbrewery.data.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BeerRepository extends JpaRepository <Beer, Integer> {

    Optional<Beer> findById(Integer beerId);
    List<Beer> findAll();
    Beer save(Beer beer);


}
