package com.springbootmultidatabaseconnection.app.dataBaseConfig.secondDataBaseConfig;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
public class SecondDataBaseTransactionManagerConfig {
    @Bean("secondDataBaseTransactionManager")
    public JpaTransactionManager transactionManager(
            @Qualifier("secondDataBaseEntityManagerFactory")
            EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
