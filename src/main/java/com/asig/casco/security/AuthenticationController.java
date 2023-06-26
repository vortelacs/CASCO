package com.asig.casco.security;

import com.asig.casco.security.dto.AuthenticationRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

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
            @RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        if(userDetails != null){
            return ResponseEntity.ok(jwtUtils.generateToken(userDetails));
        }
        return ResponseEntity.status(400).body("Could not generate token");
    }
}
