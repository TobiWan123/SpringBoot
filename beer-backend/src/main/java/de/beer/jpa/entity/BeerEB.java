package de.beer.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BeerEB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private int prml;

    private float ml;

}
