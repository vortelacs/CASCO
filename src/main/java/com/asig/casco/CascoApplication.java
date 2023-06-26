package com.asig.casco;

import com.asig.casco.role.Role;
import com.asig.casco.user.User;
import com.asig.casco.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
public class CascoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CascoApplication.class, args);
    }

/*    @Bean
    CommandLineRunner run(UserService userService){

            userService.saveUser(new User("1234","johndoy1@mail.ru", null,  new ArrayList<>()));
            userService.saveUser(new User("12345","johndoy2@mail.ru", null,  new ArrayList<>()));
            userService.saveUser(new User("123456","johndoy3@mail.ru", null,  new ArrayList<>()));

            userService.addRoleToUser("johndoy1@mail.ru", "ROLE_USER");
            userService.addRoleToUser("johndoy2@mail.ru", "ROLE_ADMIN");
            userService.addRoleToUser("johndoy3@mail.ru", "ROLE_USER");

        };

    }*/
}
