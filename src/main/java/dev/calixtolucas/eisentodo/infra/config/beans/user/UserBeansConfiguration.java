package dev.calixtolucas.eisentodo.infra.config.beans.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.calixtolucas.eisentodo.adapters.gateways.user.CreateUserGateway;
import dev.calixtolucas.eisentodo.adapters.gateways.user.FindUserByUsernameGateway;
import dev.calixtolucas.eisentodo.adapters.useCaseImplementations.user.CreateUserUseCaseImpl;
import dev.calixtolucas.eisentodo.adapters.useCaseImplementations.user.FindUserByUsernameGatewayImpl;
import dev.calixtolucas.eisentodo.application.useCases.interfaces.user.CreateUserUseCase;
import dev.calixtolucas.eisentodo.infra.gatewaysImplementations.CreateUserGatewayImpl;
import dev.calixtolucas.eisentodo.infra.repository.RoleEntityRepository;
import dev.calixtolucas.eisentodo.infra.repository.UserEntityRepository;

@Configuration
public class UserBeansConfiguration {

//CreateUser UseCase config

    @Bean
    public FindUserByUsernameGateway findUserByUsernameGateway(UserEntityRepository userEntityRepository){
        return new FindUserByUsernameGatewayImpl(userEntityRepository);
    }

    @Bean
    public CreateUserGateway createUserGateway(
        UserEntityRepository userEntityRepository,
        RoleEntityRepository roleEntityRepository
    ){
        return new CreateUserGatewayImpl(userEntityRepository, roleEntityRepository);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(
        CreateUserGateway createUserGateway,
        FindUserByUsernameGateway findUserByUsernameGateway
    ){
        return new CreateUserUseCaseImpl(createUserGateway, findUserByUsernameGateway);
    }
    
}
