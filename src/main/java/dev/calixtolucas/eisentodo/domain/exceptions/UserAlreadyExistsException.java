package dev.calixtolucas.eisentodo.domain.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(){
        super("Este usuário já existe");
    }
    
}
