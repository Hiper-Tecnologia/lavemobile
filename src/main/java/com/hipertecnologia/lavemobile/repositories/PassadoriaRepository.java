package com.hipertecnologia.lavemobile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hipertecnologia.lavemobile.model.Passadoria;

@Repository
public interface PassadoriaRepository extends JpaRepository<Passadoria, Integer>{

	
	
}
