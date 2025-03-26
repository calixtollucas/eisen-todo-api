package dev.calixtolucas.eisentodo.adapters.gateways.user;

import dev.calixtolucas.eisentodo.domain.User;

public interface CreateUserGateway {
    
    public Boolean createUser(User user);

}
