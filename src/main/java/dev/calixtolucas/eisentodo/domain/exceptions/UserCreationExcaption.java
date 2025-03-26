package dev.calixtolucas.eisentodo.domain.exceptions;

public class UserCreationExcaption extends RuntimeException{
    

    public UserCreationExcaption(){
        super("Ocorreu algum erro ao criar o usuário, tente novamente mais tarde ou contate o suporte");
    }
}
