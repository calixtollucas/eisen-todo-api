package dev.calixtolucas.eisentodo.infra.config.beans.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.calixtolucas.eisentodo.adapters.gateways.user.CreateUserGateway;
import dev.calixtolucas.eisentodo.adapters.gateways.user.FindUserByUsernameGateway;
import dev.calixtolucas.eisentodo.adapters.useCaseImplementations.user.CreateUserUseCaseImpl;
import dev.calixtolucas.eisentodo.application.useCases.interfaces.user.CreateUserUseCase;

@Configuration
public class UserBeansConfiguration {

    @Bean
    public CreateUserUseCase createUserUseCase(
        CreateUserGateway createUserGateway,
        FindUserByUsernameGateway findUserByUsernameGateway
    ){
        return new CreateUserUseCaseImpl(createUserGateway, findUserByUsernameGateway);
    }
    
}
