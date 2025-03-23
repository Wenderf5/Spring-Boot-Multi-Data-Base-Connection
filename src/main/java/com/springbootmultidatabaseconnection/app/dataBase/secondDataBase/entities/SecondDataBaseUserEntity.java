package com.springbootmultidatabaseconnection.app.dataBase.secondDataBase.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class SecondDataBaseUserEntity {
    @Id
    @Getter
    private String id;
    @Getter
    @Setter
    private String name;
}
