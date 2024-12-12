package com.dbconectionwithspringdatajpa.dbconctionapp.modules.user_module.controllers.DTOs;

public class NewUserDTO {
    private String name;

    public NewUserDTO(){

    }

    public NewUserDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
