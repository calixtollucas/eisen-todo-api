package dev.calixtolucas.eisentodo.adapters.useCaseImplementations.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import dev.calixtolucas.eisentodo.adapters.gateways.AuthenticationGateway;
import dev.calixtolucas.eisentodo.adapters.gateways.user.FindUserByUsernameGateway;
import dev.calixtolucas.eisentodo.application.outputs.LoginOutput;
import dev.calixtolucas.eisentodo.application.useCases.interfaces.user.LoginUserUseCase;
import dev.calixtolucas.eisentodo.domain.User;
import dev.calixtolucas.eisentodo.infra.exceptions.BadCredentialsException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginUserUseCaseImpl implements LoginUserUseCase{

    private FindUserByUsernameGateway findUserByUsernameGateway;
    private AuthenticationGateway authGateway;

    public LoginUserUseCaseImpl(FindUserByUsernameGateway findUserByUsernameGateway,
            AuthenticationGateway authGateway) {
        this.findUserByUsernameGateway = findUserByUsernameGateway;
        this.authGateway = authGateway;
    }

    @Override
    public LoginOutput login(String username, String password) {
        //consultar o usuário pelo username
        User user = findUserByUsernameGateway.findByUsername(username);

        if(user == null || !authGateway.checkPassword(password, user.getPassword())){

            throw new BadCredentialsException("username ou senha inválidos", 401);

        } else {

            return new LoginOutput(authGateway.generateToken(user));
        }
    }
    
}
