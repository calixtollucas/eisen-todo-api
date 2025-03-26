package dev.calixtolucas.eisentodo.application.useCases.interfaces.user;

import dev.calixtolucas.eisentodo.application.outputs.LoginOutput;

public interface LoginUserUseCase {
    
    public LoginOutput login(String username, String password);

}
