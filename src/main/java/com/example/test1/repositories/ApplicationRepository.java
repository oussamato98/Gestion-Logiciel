package com.example.test1.repositories;

import com.example.test1.entities.Application;
import com.example.test1.entities.LogKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,LogKey> {
}
