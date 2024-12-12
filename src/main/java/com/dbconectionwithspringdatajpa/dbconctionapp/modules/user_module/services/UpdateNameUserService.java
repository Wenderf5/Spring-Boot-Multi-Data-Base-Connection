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
public class UpdateNameUserService {
    private UserRepository userRepository;

    @Autowired
    public UpdateNameUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public ResponseEntity<String> updateNameUserService(String id, String name) {
        try {
            Optional<User> user_db = this.userRepository.findById(id);
            if (user_db.isEmpty()) {
                return new ResponseEntity<String>("Esse usuário não existe!", HttpStatus.NOT_FOUND);
            }
            User user = user_db.get();
            user.setName(name);
            this.userRepository.save(user);
            return new ResponseEntity<String>("Nome do usuário alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ResponseEntity<String>("Erro ao alterar o nome do usuario!", HttpStatus.BAD_REQUEST);
        }
    }
}
