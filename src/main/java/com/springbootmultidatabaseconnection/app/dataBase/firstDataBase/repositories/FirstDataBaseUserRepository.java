package com.springbootmultidatabaseconnection.app.dataBase.firstDataBase.repositories;

import com.springbootmultidatabaseconnection.app.dataBase.firstDataBase.entities.FirstDataBaseUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstDataBaseUserRepository extends JpaRepository<FirstDataBaseUserEntity, String> {
}
