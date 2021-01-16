package de.beer.exception;

public class BeerIsNotDefinedException extends RuntimeException {
    public BeerIsNotDefinedException(String message) {
        super(message);
    }
}
