package com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.services;

import com.dbconectionwithspringdatajpa.dbconctionapp.entities.user_entity.User;
import com.dbconectionwithspringdatajpa.dbconctionapp.entities.user_entity.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService {
    private UserRepository userRepository;

    @Autowired
    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public ResponseEntity<String> deleteUserService(String id) {
        try {
            Optional<User> user_db = this.userRepository.findById(id);
            if (user_db.isEmpty()) {
                return new ResponseEntity<String>("Esse usuário não existe!", HttpStatus.CONFLICT);
            }
            this.userRepository.deleteById(id);
            return new ResponseEntity<String>("Usuário apagado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ResponseEntity<String>("Erro ao apagar usuário!", HttpStatus.BAD_REQUEST);
        }
    }
}
