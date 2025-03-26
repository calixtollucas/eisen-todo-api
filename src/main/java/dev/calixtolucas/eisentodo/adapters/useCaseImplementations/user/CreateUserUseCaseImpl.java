package dev.calixtolucas.eisentodo.adapters.useCaseImplementations.user;

import dev.calixtolucas.eisentodo.adapters.gateways.user.CreateUserGateway;
import dev.calixtolucas.eisentodo.adapters.gateways.user.FindUserByUsernameGateway;
import dev.calixtolucas.eisentodo.application.useCases.interfaces.user.CreateUserUseCase;
import dev.calixtolucas.eisentodo.domain.User;
import dev.calixtolucas.eisentodo.domain.exceptions.UserAlreadyExistsException;
import dev.calixtolucas.eisentodo.domain.exceptions.UserCreationExcaption;

public class CreateUserUseCaseImpl implements CreateUserUseCase{

    private CreateUserGateway createUserGateway;
    private FindUserByUsernameGateway findUserByUsernameGateway;

    public CreateUserUseCaseImpl(CreateUserGateway createUserGateway,
            FindUserByUsernameGateway findUserByUsernameGateway) {
        this.createUserGateway = createUserGateway;
        this.findUserByUsernameGateway = findUserByUsernameGateway;
    }

    @Override
    public Boolean createUser(User user) {
        //verifica se o usuário já existe
        User userByUsername = findUserByUsernameGateway.findByUsername(user.getUsername());

        if(userByUsername != null){
            throw new UserAlreadyExistsException();
        }

        //se não existir, cria
        try {
            createUserGateway.createUser(user);
        } catch(Exception e){
            throw new UserCreationExcaption();
        }

        return true;
    }
    
}
