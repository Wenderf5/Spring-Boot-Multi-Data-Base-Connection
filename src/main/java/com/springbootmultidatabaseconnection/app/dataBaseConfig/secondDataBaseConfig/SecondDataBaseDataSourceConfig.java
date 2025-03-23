package com.springbootmultidatabaseconnection.app.dataBaseConfig.secondDataBaseConfig;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SecondDataBaseDataSourceConfig {
    @Bean(name = "secondDataBaseDataSource")
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:postgresql://HOST:PORT/DB-NAME")
                .username("USER")
                .password("PASSWORD")
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}
