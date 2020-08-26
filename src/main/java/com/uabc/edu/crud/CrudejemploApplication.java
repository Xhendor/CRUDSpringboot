package com.uabc.edu.crud;

import com.uabc.edu.crud.entity.security.UserSecurity;
import com.uabc.edu.crud.repository.security.UserRepositorySecurity;
import com.uabc.edu.crud.service.security.UserServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class CrudejemploApplication {


    @Autowired
    UserRepositorySecurity userRepositorySecurity;
    public static void main(String[] args) {
        SpringApplication.run(CrudejemploApplication.class, args);
    }


    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            userRepositorySecurity.save(new UserSecurity("coco","12345"));
            userRepositorySecurity.save(new UserSecurity("rambo","12345"));
            userRepositorySecurity.save(new UserSecurity("reprobar","12345"));

            System.err.println("PASE POR AQUI!!!");
        };
    }
    @Configuration
    protected static class AuthenticationSecurity extends
            GlobalAuthenticationConfigurerAdapter {

        @Autowired
        private UserServiceImpl users;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(users);
        }
    }

}


