package de.beer.jpa.repository;

import de.beer.jpa.entity.BeerEB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<BeerEB, Long> {

    boolean existsByNameAndMl(String name, float ml);

    BeerEB findByNameAndMl(String name, float ml);
}
