package de.beer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerIsAlreadyDefinedException extends RuntimeException {
    public BeerIsAlreadyDefinedException(String message) {
        super(message);
    }
}
