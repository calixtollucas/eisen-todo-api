package dev.calixtolucas.eisentodo.domain;

import dev.calixtolucas.eisentodo.enums.RoleUser;

public class Role {
    private Long id;
    private RoleUser roleName;

    public Long getId() {
        return id;
    }

    public RoleUser getRoleName() {
        return roleName;
    }
    
}
