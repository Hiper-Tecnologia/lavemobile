package com.hipertecnologia.lavemobile.services;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hipertecnologia.lavemobile.model.Funcionario;
import com.hipertecnologia.lavemobile.model.Passador;
import com.hipertecnologia.lavemobile.model.PassadorItem;
import com.hipertecnologia.lavemobile.repositories.PassadorItemRepository;
import com.hipertecnologia.lavemobile.repositories.PassadorRepository;
import com.hipertecnologia.lavemobile.security.UserSS;
import com.hipertecnologia.lavemobile.services.exception.AuthorizationException;
import com.hipertecnologia.lavemobile.services.exception.ObjectNotFoundException;

@Service
public class PassadorService {

	@Autowired
	private PassadorRepository repo;
	
	@Autowired
	private PassadorItemRepository passadorItemRepository;

	@Autowired
	private FuncionarioService funcionarioService;
	
	public Passador find(Integer id) {
		Optional<Passador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id:"+ id + " tipo: "+ Passador.class.getName()));
				
	}
	
	@Transactional
	public Passador insert(Passador obj) {
		obj.setId(null);
		obj.setInicio(new Date());
		obj = repo.save(obj);
		
		for (PassadorItem ip : obj.getItens()) {
			ip.setPassador(obj);
		}
		
		passadorItemRepository.saveAll(obj.getItens());
		return obj;
	}
	
	/*
	public Page<Passador> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Funcionario funcionario =  funcionarioService.find(user.getId());
		return repo.findByFuncionario(funcionario, pageRequest);
}*/
}
