package dev.calixtolucas.eisentodo.domain.exceptions;

public class InternalServerError extends RuntimeException{

    public InternalServerError(String message){
        super(message);
    }
}
