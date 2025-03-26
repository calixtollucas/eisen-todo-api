package dev.calixtolucas.eisentodo.domain;

import dev.calixtolucas.eisentodo.enums.RoleUser;
import lombok.Builder;

@Builder
public class User {
    private Long id;
    private String username;
    private String password;
    private RoleUser role;

    public Long getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public RoleUser getRole() {
        return role;
    }

}
