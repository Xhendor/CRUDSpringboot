package com.uabc.edu.crud.service.security;

import java.util.List;

import com.uabc.edu.crud.entity.security.UserSecurity;
import com.uabc.edu.crud.repository.security.UserRepositorySecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepositorySecurity repo;



    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserSecurity userSecurity = repo.findByName(username);
        if (userSecurity == null) {
            return null;
        }
        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        if (username.equals("admin")) {
            auth = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }
        String password = userSecurity.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        return new org.springframework.security.core.userdetails.User(username, hashedPassword,
                auth);
    }


}
