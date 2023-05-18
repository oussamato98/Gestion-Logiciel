package com.example.test1.repositories;

import com.example.test1.entities.CompKey;
import com.example.test1.entities.Composant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposantRepository extends JpaRepository<Composant, CompKey> {
}
