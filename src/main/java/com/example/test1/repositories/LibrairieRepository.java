package com.example.test1.repositories;

import com.example.test1.entities.Librairie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrairieRepository extends JpaRepository<Librairie,String> {
}
