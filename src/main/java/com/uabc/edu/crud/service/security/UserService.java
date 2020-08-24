package com.uabc.edu.crud.service.security;


import com.uabc.edu.crud.entity.security.UserSecurity;

public interface UserService {
    void save(UserSecurity userSecurity);

    UserSecurity findByUsername(String username);
}
