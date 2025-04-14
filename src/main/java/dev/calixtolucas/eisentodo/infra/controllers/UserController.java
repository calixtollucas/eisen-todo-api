package dev.calixtolucas.eisentodo.infra.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.calixtolucas.eisentodo.application.useCases.interfaces.user.CreateUserUseCase;
import dev.calixtolucas.eisentodo.domain.User;
import dev.calixtolucas.eisentodo.infra.dtos.user.CreateUserInputDto;
import dev.calixtolucas.eisentodo.infra.mappers.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private CreateUserUseCase createUserUseCase;
    //private LoginUserUseCase loginUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        //this.loginUserUseCase = loginUserUseCase;
    }
    
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserInputDto userInputDto){

        //mapeia dto para usuário
        User userToCreate = UserMapper.toUser(userInputDto);

        createUserUseCase.createUser(userToCreate);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body("Usuário criado com sucesso");
    }

}
