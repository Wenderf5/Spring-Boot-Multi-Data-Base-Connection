package com.springbootmultidatabaseconnection.app.modules.user_module.controllers;

import com.springbootmultidatabaseconnection.app.modules.user_module.controllers.DTOs.NewUserDTO;
import com.springbootmultidatabaseconnection.app.modules.user_module.services.FirstDataBaseUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/first-data-base")
public class FirstDataBaseUserController {
    private final FirstDataBaseUserService firstDataBaseUserService;

    @Autowired
    public FirstDataBaseUserController(FirstDataBaseUserService firstDataBaseUserService) {
        this.firstDataBaseUserService = firstDataBaseUserService;
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return this.firstDataBaseUserService.getUsers();
    }

    @PostMapping
    public ResponseEntity<String> newUser(
            @RequestBody
            @Valid
            NewUserDTO body
    ) {
        return this.firstDataBaseUserService.newUser(body.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable("id")
            String id
    ) {
        return this.firstDataBaseUserService.deleteUser(id);
    }
}
