package com.example.test1.repositories;

import com.example.test1.entities.LicKey;
import com.example.test1.entities.Licence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenceRepository extends JpaRepository<Licence, LicKey> {
}
