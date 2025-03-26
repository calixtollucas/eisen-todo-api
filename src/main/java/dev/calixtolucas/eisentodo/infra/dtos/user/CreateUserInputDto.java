package dev.calixtolucas.eisentodo.infra.dtos.user;

import dev.calixtolucas.eisentodo.enums.RoleUser;

public record CreateUserInputDto(String username, String password, RoleUser role) {
    
}
