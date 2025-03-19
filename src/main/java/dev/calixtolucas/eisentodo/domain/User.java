package dev.calixtolucas.eisentodo.domain;

import lombok.Builder;

@Builder
public class User {
    private Long id;
    private String username;
    private String password;
    private Role role;

    public Long getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
