package com.springbootmultidatabaseconnection.app.dataBaseConfig.firstDataBaseConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.springbootmultidatabaseconnection.app.dataBase.firstDataBase.repositories",
        entityManagerFactoryRef = "firstDataBaseEntityManagerFactory",
        transactionManagerRef = "firstDataBaseTransactionManager"
)
public class FirstDataBaseEntityManagerFactiryConfig {
    @Bean(name = "firstDataBaseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("firstDataBaseDataSource")
            DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.springbootmultidatabaseconnection.app.dataBase.firstDataBase.entities")
                .properties(Collections.singletonMap("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"))
                .persistenceUnit("firstDataBasePU")
                .build();
    }
}
