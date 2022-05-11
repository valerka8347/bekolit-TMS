package com.example.bekolittms.model;

import com.example.bekolittms.entity.RoleEntity;
import java.util.Set;
import javax.validation.constraints.NotEmpty;

public class UserEdit {


    private long id;

    @NotEmpty(message = "Username can't be empty")
    private String username;

    @NotEmpty(message = "Roles can't be empty")
    private Set<RoleEntity> roles;

    public long getId() {
        return id;
    }

    public UserEdit setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEdit setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public UserEdit setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}
