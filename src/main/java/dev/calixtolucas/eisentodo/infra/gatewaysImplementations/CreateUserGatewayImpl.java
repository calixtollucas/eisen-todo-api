package dev.calixtolucas.eisentodo.infra.gatewaysImplementations;

import org.springframework.stereotype.Service;

import dev.calixtolucas.eisentodo.adapters.gateways.user.CreateUserGateway;
import dev.calixtolucas.eisentodo.domain.User;
import dev.calixtolucas.eisentodo.infra.repository.UserEntityRepository;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway{

    private UserEntityRepository userEntityRepository;

    @Override
    public Boolean createUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }
    
}
