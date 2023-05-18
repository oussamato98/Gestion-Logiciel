package com.example.test1.repositories;

import com.example.test1.entities.LogKey;
import com.example.test1.entities.Logiciel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogicielRepository extends JpaRepository<Logiciel, LogKey> {
}
