package com.springbootmultidatabaseconnection.app.dataBaseConfig.secondDataBaseConfig;

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
        basePackages = "com.springbootmultidatabaseconnection.app.dataBase.secondDataBase.repositories",
        entityManagerFactoryRef = "secondDataBaseEntityManagerFactory",
        transactionManagerRef = "secondDataBaseTransactionManager"
)
public class SecondDataBaseEntityManagerFactiryConfig {
    @Bean(name = "secondDataBaseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("secondDataBaseDataSource")
            DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.springbootmultidatabaseconnection.app.dataBase.secondDataBase.entities")
                .properties(Collections.singletonMap("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"))
                .persistenceUnit("secondDataBasePU")
                .build();
    }
}
