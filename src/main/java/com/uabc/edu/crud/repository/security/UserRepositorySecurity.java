package com.uabc.edu.crud.repository.security;

import com.uabc.edu.crud.entity.security.UserSecurity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepositorySecurity extends CrudRepository<UserSecurity, Long> {
    UserSecurity findByName(String username);

}
