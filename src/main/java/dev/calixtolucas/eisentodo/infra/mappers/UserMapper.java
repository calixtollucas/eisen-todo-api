package dev.calixtolucas.eisentodo.infra.mappers;

import dev.calixtolucas.eisentodo.domain.User;
import dev.calixtolucas.eisentodo.infra.dtos.user.CreateUserInputDto;
import dev.calixtolucas.eisentodo.infra.entity.RoleEntity;
import dev.calixtolucas.eisentodo.infra.entity.UserEntity;

public class UserMapper {

    public static User toUser(CreateUserInputDto userInputDto){
        return User.builder()
            .username(userInputDto.username())
            .password(userInputDto.password())
            .role(userInputDto.role())
            .build();
    }

    public static UserEntity toEntity(User user, RoleEntity roleEntity) {
        
        return new UserEntity(
            user.getId(),
            user.getUsername(),
            user.getPassword(),
            roleEntity
        );
    }

    public static User toUser(UserEntity userEntity) {
        return User.builder()
            .id(userEntity.getId())
            .username(userEntity.getUsername())
            .password(userEntity.getPassword())
            .role(userEntity.getRole().getRoleName())
            .build();
    }
    
}
