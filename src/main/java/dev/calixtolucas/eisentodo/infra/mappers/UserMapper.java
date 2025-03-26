package dev.calixtolucas.eisentodo.infra.mappers;

import dev.calixtolucas.eisentodo.domain.User;
import dev.calixtolucas.eisentodo.infra.dtos.user.CreateUserInputDto;

public class UserMapper {

    public static User toUser(CreateUserInputDto userInputDto){
        return User.builder()
            .username(userInputDto.username())
            .password(userInputDto.password())
            .role(userInputDto.role())
            .build();
    }
    
}
