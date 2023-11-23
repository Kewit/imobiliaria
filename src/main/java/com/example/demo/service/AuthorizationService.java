package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceBadRequestException;
import com.example.demo.repository.UserRepository;


@Service
public class AuthorizationService implements UserDetailsService{

    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) {     
        if(repository.findByLogin(username) == null ){
            
            throw new ResourceBadRequestException("Usuario não encontrado!");
        }
        return repository.findByLogin(username);
    }
    
}