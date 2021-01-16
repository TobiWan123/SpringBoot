package de.beer.mapper;

import de.beer.api.Beer;
import de.beer.jpa.entity.BeerEB;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-16T02:11:59+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 13.0.1 (Oracle Corporation)"
)
public class BeerMapperImpl implements BeerMapper {

    @Override
    public BeerEB mapBeerToBeerEB(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerEB beerEB = new BeerEB();

        beerEB.setName( beer.getName() );
        beerEB.setPrml( beer.getPrml() );
        beerEB.setMl( beer.getMl() );

        return beerEB;
    }

    @Override
    public Beer mapBeerEBToBeer(BeerEB beerEB) {
        if ( beerEB == null ) {
            return null;
        }

        Beer beer = new Beer();

        beer.setName( beerEB.getName() );
        beer.setPrml( beerEB.getPrml() );
        beer.setMl( beerEB.getMl() );

        return beer;
    }

    @Override
    public List<Beer> mapBeerEBListToBeerList(List<BeerEB> beerEBList) {
        if ( beerEBList == null ) {
            return null;
        }

        List<Beer> list = new ArrayList<Beer>( beerEBList.size() );
        for ( BeerEB beerEB : beerEBList ) {
            list.add( mapBeerEBToBeer( beerEB ) );
        }

        return list;
    }
}
