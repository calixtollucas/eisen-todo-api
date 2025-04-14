package dev.calixtolucas.eisentodo.infra.config.beans.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;

import dev.calixtolucas.eisentodo.adapters.gateways.AuthenticationGateway;
import dev.calixtolucas.eisentodo.adapters.gateways.user.CreateUserGateway;
import dev.calixtolucas.eisentodo.adapters.gateways.user.FindUserByUsernameGateway;
import dev.calixtolucas.eisentodo.adapters.useCaseImplementations.task.LoginUserUseCaseImpl;
import dev.calixtolucas.eisentodo.adapters.useCaseImplementations.user.CreateUserUseCaseImpl;
import dev.calixtolucas.eisentodo.adapters.useCaseImplementations.user.FindUserByUsernameGatewayImpl;
import dev.calixtolucas.eisentodo.application.useCases.interfaces.user.CreateUserUseCase;
import dev.calixtolucas.eisentodo.application.useCases.interfaces.user.LoginUserUseCase;
import dev.calixtolucas.eisentodo.infra.gatewaysImplementations.AuthenticationGatewayImpl;
import dev.calixtolucas.eisentodo.infra.gatewaysImplementations.CreateUserGatewayImpl;
import dev.calixtolucas.eisentodo.infra.repository.RoleEntityRepository;
import dev.calixtolucas.eisentodo.infra.repository.UserEntityRepository;

@Configuration
public class BeanConfig {

//CreateUser UseCase config

    @Bean
    public FindUserByUsernameGateway findUserByUsernameGateway(UserEntityRepository userEntityRepository){
        return new FindUserByUsernameGatewayImpl(userEntityRepository);
    }

    @Bean
    public CreateUserGateway createUserGateway(
        UserEntityRepository userEntityRepository,
        RoleEntityRepository roleEntityRepository,
        PasswordEncoder passwordEncoder
    ){
        return new CreateUserGatewayImpl(userEntityRepository, roleEntityRepository, passwordEncoder);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(
        CreateUserGateway createUserGateway,
        FindUserByUsernameGateway findUserByUsernameGateway
    ){
        return new CreateUserUseCaseImpl(createUserGateway, findUserByUsernameGateway);
    }

//LoginUser
    @Bean
    public AuthenticationGateway authGateway(
        PasswordEncoder passwordEncoder,
        JwtEncoder jwtEncoder
    ){
        return new AuthenticationGatewayImpl(passwordEncoder, jwtEncoder);
    }

    @Bean
    public LoginUserUseCase loginUserUseCase(
        FindUserByUsernameGateway findUserByUsernameGateway,
        AuthenticationGateway authGateway
    ){
        return new LoginUserUseCaseImpl(findUserByUsernameGateway, authGateway);
    }
}