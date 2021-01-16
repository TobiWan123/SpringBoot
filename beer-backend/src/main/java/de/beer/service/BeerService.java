package de.beer.service;

import de.beer.api.Beer;
import de.beer.exception.BeerIsAlreadyDefinedException;
import de.beer.exception.BeerIsNotDefinedException;
import de.beer.jpa.entity.BeerEB;
import de.beer.jpa.repository.BeerRepository;
import de.beer.mapper.BeerMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Autowired
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
        this.beerMapper = Mappers.getMapper(BeerMapper.class);
    }

    public Beer createBeerEB(Beer beer) {

        checkIfBeerIsAlreadyDefined(beer.getName(), beer.getMl());

        BeerEB beerEB = beerMapper.mapBeerToBeerEB(beer);

        beerEB = beerRepository.save(beerEB);

        return beerMapper.mapBeerEBToBeer(beerEB);
    }

    public Long deleteBeerEB(String name, float ml) {
        checkIfBeerIsNotDefined(name, ml);
        BeerEB beerEB = beerRepository.findByNameAndMl(name, ml);

        beerRepository.deleteById(beerEB.getId());

        return beerEB.getId();

    }

    public Beer updateBeerEB(Beer beer) {
        checkIfBeerIsNotDefined(beer.getName(), beer.getMl());

        BeerEB databaseBeerEB = this.beerRepository.findByNameAndMl(beer.getName(), beer.getMl());
        BeerEB updatedBeerEB = beerMapper.mapBeerToBeerEB(beer);
        updatedBeerEB.setId(databaseBeerEB.getId());

        updatedBeerEB = beerRepository.save(updatedBeerEB);


        return beerMapper.mapBeerEBToBeer(updatedBeerEB);
    }

    private void checkIfBeerIsAlreadyDefined(String name, float ml) {

        if (beerRepository.existsByNameAndMl(name, ml)) {
            throw new BeerIsAlreadyDefinedException("Beer with name" + name + "is already defined!");
        }

    }

    private void checkIfBeerIsNotDefined(String name, float ml) {
        if (!beerRepository.existsByNameAndMl(name, ml)) {
            throw new BeerIsNotDefinedException("Beer with name" + name + "is not in Data!");
        }
    }

    public Beer findByNameAndMl(String name, float ml) {
        checkIfBeerIsNotDefined(name, ml);
        return beerMapper.mapBeerEBToBeer(beerRepository.findByNameAndMl(name, ml));
    }

    public List<Beer> findAll() {
        return beerMapper.mapBeerEBListToBeerList(beerRepository.findAll());
    }
}
