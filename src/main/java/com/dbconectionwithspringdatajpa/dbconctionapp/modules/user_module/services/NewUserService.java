package com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.services;

import com.dbconectionwithspringdatajpa.dbconctionapp.entities.user_entity.User;
import com.dbconectionwithspringdatajpa.dbconctionapp.entities.user_entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NewUserService {
    private UserRepository userRepository;

    @Autowired
    public NewUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> newUserService(String name) {
        try {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            User newUser = new User(uuidAsString, name);
            this.userRepository.save(newUser);
            return new ResponseEntity<String>("Usuário cadastrado com sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ResponseEntity<String>("Erro ao cadastrar usuário!", HttpStatus.BAD_REQUEST);
        }
    }
}
