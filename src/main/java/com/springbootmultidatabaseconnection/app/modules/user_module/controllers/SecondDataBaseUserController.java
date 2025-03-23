package com.springbootmultidatabaseconnection.app.modules.user_module.controllers;

import com.springbootmultidatabaseconnection.app.modules.user_module.controllers.DTOs.NewUserDTO;
import com.springbootmultidatabaseconnection.app.modules.user_module.services.SecondDataBaseUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/second-data-base")
public class SecondDataBaseUserController {
    private final SecondDataBaseUserService secondDataBaseUserService;

    @Autowired
    public SecondDataBaseUserController(SecondDataBaseUserService secondDataBaseUserService) {
        this.secondDataBaseUserService = secondDataBaseUserService;
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return this.secondDataBaseUserService.getUsers();
    }

    @PostMapping
    public ResponseEntity<String> newUser(
            @RequestBody
            @Valid
            NewUserDTO body
    ) {
        return this.secondDataBaseUserService.newUser(body.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable("id")
            String id
    ) {
        return this.secondDataBaseUserService.deleteUser(id);
    }
}
