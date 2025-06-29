package com.repoUnsij.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repoUnsij.auth.entites.Carreras;

@Repository
public interface CarreasRepository extends JpaRepository<Carreras, Long>{
    
}
