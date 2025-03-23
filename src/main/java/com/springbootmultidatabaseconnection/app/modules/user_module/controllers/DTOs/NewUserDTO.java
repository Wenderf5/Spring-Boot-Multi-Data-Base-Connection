package com.springbootmultidatabaseconnection.app.modules.user_module.controllers.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NewUserDTO {
    @Getter
    @NotNull
    @NotBlank
    private String name;
}
