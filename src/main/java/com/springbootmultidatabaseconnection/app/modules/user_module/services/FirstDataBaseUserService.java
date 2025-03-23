package com.springbootmultidatabaseconnection.app.modules.user_module.services;

import com.springbootmultidatabaseconnection.app.dataBase.firstDataBase.entities.FirstDataBaseUserEntity;
import com.springbootmultidatabaseconnection.app.dataBase.firstDataBase.repositories.FirstDataBaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FirstDataBaseUserService {
    private final FirstDataBaseUserRepository firstDataBaseUserRepository;

    @Autowired
    public FirstDataBaseUserService(FirstDataBaseUserRepository firstDataBaseUserRepository) {
        this.firstDataBaseUserRepository = firstDataBaseUserRepository;
    }

    public ResponseEntity<?> getUsers() {
        try {
            List<FirstDataBaseUserEntity> usersList = this.firstDataBaseUserRepository.findAll();
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
            FirstDataBaseUserEntity newUser = new FirstDataBaseUserEntity(uuidAsString, name);
            this.firstDataBaseUserRepository.save(newUser);
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
            Optional<FirstDataBaseUserEntity> user_db = this.firstDataBaseUserRepository.findById(id);
            if (user_db.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .header("Content-Type", "text/plain")
                        .body("Esse usuário não existe!");
            }
            this.firstDataBaseUserRepository.deleteById(id);
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
