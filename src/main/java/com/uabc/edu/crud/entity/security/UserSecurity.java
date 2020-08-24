package com.uabc.edu.crud.entity.security;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_security")
public class UserSecurity {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String password;

    public UserSecurity() {
    }

    public UserSecurity(String name, String password) {
        this.name=name;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
