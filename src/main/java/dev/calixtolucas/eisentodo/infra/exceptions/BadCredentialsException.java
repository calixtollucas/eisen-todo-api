package dev.calixtolucas.eisentodo.infra.exceptions;

import dev.calixtolucas.eisentodo.domain.exceptions.DomainException;

public class BadCredentialsException extends DomainException{

    public BadCredentialsException(String message, int statusCode) {
        super(message, statusCode);
    }
    
}
