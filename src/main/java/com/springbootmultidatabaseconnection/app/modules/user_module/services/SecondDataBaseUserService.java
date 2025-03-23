package com.springbootmultidatabaseconnection.app.modules.user_module.services;

import com.springbootmultidatabaseconnection.app.dataBase.secondDataBase.entities.SecondDataBaseUserEntity;
import com.springbootmultidatabaseconnection.app.dataBase.secondDataBase.repositories.SecondDataBaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SecondDataBaseUserService {
    private final SecondDataBaseUserRepository secondDataBaseUserRepository;

    @Autowired
    public SecondDataBaseUserService(SecondDataBaseUserRepository secondDataBaseUserRepository) {
        this.secondDataBaseUserRepository = secondDataBaseUserRepository;
    }

    public ResponseEntity<?> getUsers() {
        try {
            List<SecondDataBaseUserEntity> usersList = this.secondDataBaseUserRepository.findAll();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(usersList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "text/plain")
                    .body("Erro ao buscar usuários!");
        }
    }

    public ResponseEntity<String> newUser(String name) {
        try {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            SecondDataBaseUserEntity newUser = new SecondDataBaseUserEntity(uuidAsString, name);
            this.secondDataBaseUserRepository.save(newUser);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Content-Type", "text/plain")
                    .body("Usuário criado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "text/plain")
                    .body("Erro ao cadastrar usuário!");
        }
    }

    public ResponseEntity<String> deleteUser(String id) {
        try {
            Optional<SecondDataBaseUserEntity> user_db = this.secondDataBaseUserRepository.findById(id);
            if (user_db.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .header("Content-Type", "text/plain")
                        .body("Esse usuário não existe!");
            }
            this.secondDataBaseUserRepository.deleteById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "text/plain")
                    .body("Usuário apagado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "text/plain")
                    .body("Erro ao apagar usuário!");
        }
    }
}
