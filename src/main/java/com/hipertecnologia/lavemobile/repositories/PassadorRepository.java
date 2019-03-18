package com.hipertecnologia.lavemobile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hipertecnologia.lavemobile.model.Passador;

@Repository
public interface PassadorRepository extends JpaRepository<Passador, Integer>{

		
}
