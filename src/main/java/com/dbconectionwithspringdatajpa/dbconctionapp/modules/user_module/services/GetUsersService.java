package com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.services;

import com.dbconectionwithspringdatajpa.dbconctionapp.entities.user_entity.User;
import com.dbconectionwithspringdatajpa.dbconctionapp.entities.user_entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersService {
    private UserRepository userRepository;

    @Autowired
    public GetUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity getUsers() {
        try {
            List<User> usersList = this.userRepository.findAll();
            return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ResponseEntity<String>("Erro ao buscar usuários!", HttpStatus.BAD_REQUEST);
        }
    }
}
