package com.asig.casco.security;

import com.asig.casco.insurance.person.Person;
import com.asig.casco.insurance.person.PersonService;
import com.asig.casco.role.Role;
import com.asig.casco.role.RoleRepository;
import com.asig.casco.security.dto.AuthenticationRequest;
import com.asig.casco.security.dto.SignUpRequest;
import com.asig.casco.user.User;
import com.asig.casco.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final RoleRepository roleRepository;
    private final PersonService personService;
    private final UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        if(userDetails != null){
            return ResponseEntity.ok(
                    "{\"token\" : \"" + jwtUtils.generateToken(userDetails)+"\"}"
            );
        }
        return ResponseEntity.status(400).body("Could not generate token");
    }

/*    @GetMapping(value = "validateToken")
    public ResponseEntity<Boolean> validateToken(){


    }*/

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<String> signUp(
            @RequestBody SignUpRequest request){

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        Person person = new Person();
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setIdnp(request.getIdnp());
        person.setPhone(request.getPhone());

        personService.savePerson(person);
        Collection<Role> userRoles = new ArrayList<>();
        userRoles.add(roleRepository.findByRoleName("ROLE_USER"));
        user.setPerson(person);
        user.setRoles(userRoles);

        userService.saveUser(user);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        if(userDetails != null){
            return ResponseEntity.ok("{\"token\" : \"" + jwtUtils.generateToken(userDetails)+"\"}");
        }
        return ResponseEntity.status(400).body("Could not generate token");
    }
}
