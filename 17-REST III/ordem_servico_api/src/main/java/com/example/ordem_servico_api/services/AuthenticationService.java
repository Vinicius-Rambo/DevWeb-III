package com.example.ordem_servico_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.ordem_servico_api.security.JwtService;

@Service
public class AuthenticationService {

    @Autowired
    JwtService jwtService;

    public String authenticate(Authentication authentication){
        return jwtService.generateToken(authentication);
    }
    
}
