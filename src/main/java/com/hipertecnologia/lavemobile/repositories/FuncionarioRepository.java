package com.hipertecnologia.lavemobile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hipertecnologia.lavemobile.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

	@Transactional(readOnly=true)
	Funcionario findByFlogin(String login);
	
}
