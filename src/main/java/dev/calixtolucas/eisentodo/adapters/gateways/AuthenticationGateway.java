package dev.calixtolucas.eisentodo.adapters.gateways;

import dev.calixtolucas.eisentodo.domain.User;

public interface AuthenticationGateway {
    
    public boolean checkPassword(String rawPassword, String encodedPassword);

    public String generateToken(User user);
}
