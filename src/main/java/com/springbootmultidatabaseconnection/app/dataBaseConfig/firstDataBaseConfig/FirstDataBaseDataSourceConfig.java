package com.springbootmultidatabaseconnection.app.dataBaseConfig.firstDataBaseConfig;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FirstDataBaseDataSourceConfig {
    @Bean(name = "firstDataBaseDataSource")
    public DataSource dataSource(){
        return DataSourceBuilder
                .create()
                .url("jdbc:mysql://HOST:PORT/DB-NAME")
                .username("USER")
                .password("PASSWORD")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();

//        .url("jdbc:mysql://HOST:PORT/DB-NAME")
//                .username("USER")
//                .password("PASSWORD")
    }
}
