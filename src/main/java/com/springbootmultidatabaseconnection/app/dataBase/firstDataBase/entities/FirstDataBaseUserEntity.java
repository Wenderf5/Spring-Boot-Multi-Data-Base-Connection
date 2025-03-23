package com.springbootmultidatabaseconnection.app.dataBase.firstDataBase.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class FirstDataBaseUserEntity {
    @Id
    @Getter
    private String id;
    @Getter
    @Setter
    private String name;
}
