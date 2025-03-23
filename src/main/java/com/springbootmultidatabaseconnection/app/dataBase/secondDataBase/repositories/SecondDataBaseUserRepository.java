package com.springbootmultidatabaseconnection.app.dataBase.secondDataBase.repositories;

import com.springbootmultidatabaseconnection.app.dataBase.secondDataBase.entities.SecondDataBaseUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondDataBaseUserRepository extends JpaRepository<SecondDataBaseUserEntity, String> {
}
