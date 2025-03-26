package dev.calixtolucas.eisentodo.adapters.gateways.user;

import dev.calixtolucas.eisentodo.domain.User;

public interface FindUserByUsernameGateway {
    
    public User findByUsername(String username);

}
