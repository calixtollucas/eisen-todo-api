package dev.calixtolucas.eisentodo.infra.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.calixtolucas.eisentodo.application.outputs.LoginOutput;
import dev.calixtolucas.eisentodo.application.useCases.interfaces.user.LoginUserUseCase;
import dev.calixtolucas.eisentodo.infra.dtos.task.LoginUserInputDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private LoginUserUseCase loginUserUseCase;

    public AuthController(LoginUserUseCase loginUserUseCase) {
        this.loginUserUseCase = loginUserUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginOutput> postMethodName(@RequestBody LoginUserInputDto loginDto) {
        
        LoginOutput login = loginUserUseCase.login(loginDto.username(), loginDto.password());

        return ResponseEntity.ok(login);
        
    }
    
    
}
