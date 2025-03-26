package dev.calixtolucas.eisentodo.application.useCases.interfaces.user;

import dev.calixtolucas.eisentodo.domain.User;

public interface CreateUserUseCase {
    
    public Boolean createUser(User user);
}
