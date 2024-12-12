package com.dbconectionwithspringdatajpa.dbconctionapp.db_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://HOST:PORT/DB_NAME");
        dataSource.setUsername("USER");
        dataSource.setPassword("PASSWORD");
        return dataSource;
    }
}
