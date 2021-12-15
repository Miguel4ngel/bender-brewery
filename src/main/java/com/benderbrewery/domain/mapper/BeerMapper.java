package com.benderbrewery.domain.mapper;
import com.benderbrewery.data.entity.Beer;
import com.benderbrewery.domain.model.BeerDto;
import com.benderbrewery.domain.model.exception.EmptyFieldException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BeerMapper {

    @Mappings({
            @Mapping(target = "name", source = "beer.name"),
            @Mapping(target = "brewery", source = "beer.brewery"),
            @Mapping(target = "country", source = "beer.country"),
            @Mapping(target = "currency", source = "beer.currency"),
            @Mapping(target = "price", source = "beer.price"),
            @Mapping(target = "id", source = "beer.id")
    })
    BeerDto fromBeerEntity(Beer beer);

    @Mappings({
            @Mapping(target = "name", source = "beerDto.name", qualifiedByName = "validateString"),
            @Mapping(target = "brewery", source = "beerDto.brewery", qualifiedByName = "validateString"),
            @Mapping(target = "country", source = "beerDto.country", qualifiedByName = "validateString"),
            @Mapping(target = "currency", source = "beerDto.currency", qualifiedByName = "validateString"),
            @Mapping(target = "price", source = "beerDto.price", qualifiedByName = "validateDouble"),
            @Mapping(target = "id", source = "beerDto.id", qualifiedByName = "validateId")
    })
    Beer fromBeerDto(BeerDto beerDto);

    @Named("validateString")
    public static String validateString(String value){
        if(value.trim().isEmpty()) {
            EmptyFieldException.thrown();
        }
        return value;
    }

    @Named("validateDouble")
    public static Double validateNumber(Double value){
        if(String.valueOf(value).trim().isEmpty()) {
            EmptyFieldException.thrown();
        }
        return value;
    }

    @Named("validateId")
    public static Integer validateId(Integer value){
        if(String.valueOf(value).trim().isEmpty()) {
            EmptyFieldException.thrown();
        }
        return value;
    }




}

