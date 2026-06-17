package com.example.ordem_servico_api.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ordem_servico_api.services.AuthenticationService;

@RestController
public class AuthenticationResource {
    
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public String authenticate(Authentication authentication){
        return authenticationService.authenticate(authentication);
    }
}
