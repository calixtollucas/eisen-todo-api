package dev.calixtolucas.eisentodo.domain.exceptions;

public class DomainException extends RuntimeException{

    private int statusCode;
    
    public DomainException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}
