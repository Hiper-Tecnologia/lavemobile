package com.hipertecnologia.lavemobile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hipertecnologia.lavemobile.model.Funcionario;
import com.hipertecnologia.lavemobile.repositories.FuncionarioRepository;
import com.hipertecnologia.lavemobile.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private FuncionarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Funcionario fun = repo.findByFlogin(login);
		
		if (fun == null) {
			throw new UsernameNotFoundException(login);
		}
		
		return new UserSS(fun.getId(),fun.getFlogin(),fun.getFunc_senha(),fun.getPerfis());
	}

}
