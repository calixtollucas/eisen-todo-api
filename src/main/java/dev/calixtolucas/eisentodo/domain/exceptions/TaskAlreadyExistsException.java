package dev.calixtolucas.eisentodo.domain.exceptions;

public class TaskAlreadyExistsException extends RuntimeException{

    public TaskAlreadyExistsException(){
        super("This Task already Exists");
    }
    
}
