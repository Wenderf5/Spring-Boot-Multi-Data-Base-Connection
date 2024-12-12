package com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.controllers;

import com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.controllers.DTOs.NewUserDTO;
import com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.controllers.DTOs.UpdateNameUserDTO;
import com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.services.DeleteUserService;
import com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.services.GetUsersService;
import com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.services.NewUserService;
import com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.services.UpdateNameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private NewUserService newUserService;
    private DeleteUserService deleteUserService;
    private GetUsersService getUsersService;
    private UpdateNameUserService updateNameUserService;

    @Autowired
    public UserController(
            NewUserService newUserService,
            DeleteUserService deleteUserService,
            GetUsersService getUsersService,
            UpdateNameUserService updateNameUserService
    ) {
        this.newUserService = newUserService;
        this.deleteUserService = deleteUserService;
        this.getUsersService = getUsersService;
        this.updateNameUserService = updateNameUserService;
    }

    @PostMapping
    public ResponseEntity<String> newUser(@RequestBody NewUserDTO user) {
        return this.newUserService.newUserService(user.getName());
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return this.getUsersService.getUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        return this.deleteUserService.deleteUserService(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateNameUser(
            @PathVariable("id") String id,
            @RequestBody UpdateNameUserDTO updateNameUserDTO
    ) {
        return this.updateNameUserService.updateNameUserService(id, updateNameUserDTO.getName());
    }
}
