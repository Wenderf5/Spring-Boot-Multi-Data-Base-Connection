package com.dbconectionwithspringdatajpa.dbconctionapp.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionCheck implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String[] args) throws Exception {
        try {
            String sql = "SELECT 1";
            jdbcTemplate.queryForObject(sql, Integer.class);
            System.out.println("Conexão com o banco de dados realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Falha ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}


