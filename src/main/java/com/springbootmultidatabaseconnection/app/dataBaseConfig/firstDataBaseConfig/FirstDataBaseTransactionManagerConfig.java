package com.springbootmultidatabaseconnection.app.dataBaseConfig.firstDataBaseConfig;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
public class FirstDataBaseTransactionManagerConfig {
    @Bean("firstDataBaseTransactionManager")
    public JpaTransactionManager transactionManager(
            @Qualifier("firstDataBaseEntityManagerFactory")
            EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
