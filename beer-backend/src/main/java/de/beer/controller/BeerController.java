package de.beer.controller;

import de.beer.api.Beer;
import de.beer.service.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beer")
@Slf4j
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }


    @GetMapping(value = "/_search")
    public Beer findByNameAndMl(@RequestParam String name, @RequestParam float ml) {
        log.info("Receive get request findByNameAndMl()");
        return beerService.findByNameAndMl(name, ml);
    }

    @GetMapping
    public List<Beer> findAll() {
        log.info("Receive get request findAll()");
        return beerService.findAll();
    }

    @PostMapping
    public Beer createBeer(@RequestBody Beer beer) {
        log.info("Receive post request createBeer()");
        return beerService.createBeerEB(beer);
    }

    @DeleteMapping
    public Long deleteBeer(@RequestParam String name, @RequestParam float ml) {
        log.info("Receive post request deleteBeer()");
        return beerService.deleteBeerEB(name, ml);
    }

    @PutMapping
    public Beer updateBeer(@RequestBody Beer beer) {
        log.info("Receive post request deleteBeer()");
        return beerService.updateBeerEB(beer);
    }
}
