package de.beer.mapper;

import de.beer.api.Beer;
import de.beer.jpa.entity.BeerEB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface BeerMapper {

    @Mapping(target = "id", ignore = true)
    BeerEB mapBeerToBeerEB(Beer beer);

    Beer mapBeerEBToBeer(BeerEB beerEB);

    List<Beer> mapBeerEBListToBeerList(List<BeerEB> beerEBList);
}
