package com.hipertecnologia.lavemobile.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hipertecnologia.lavemobile.model.Funcionario;
import com.hipertecnologia.lavemobile.model.Passador;
import com.hipertecnologia.lavemobile.model.PassadorItem;
import com.hipertecnologia.lavemobile.model.Passadoria;
import com.hipertecnologia.lavemobile.model.enums.Perfil;
import com.hipertecnologia.lavemobile.repositories.FuncionarioRepository;
import com.hipertecnologia.lavemobile.repositories.PassadorItemRepository;
import com.hipertecnologia.lavemobile.repositories.PassadorRepository;
import com.hipertecnologia.lavemobile.repositories.PassadoriaRepository;

@Service
public class DBService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private PassadoriaRepository passadoriaRepository;

	@Autowired
	private PassadorRepository passadorRepository;
	
	@Autowired
	private PassadorItemRepository passadorItemRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTestDatabase() {
		Funcionario func1 = new Funcionario(null,"Carlos Eduardo", null, null, null, null, null, null, null, null, null, null, null, null,pe.encode("12345"), "eduardo");
		func1.addPerfil(Perfil.ADMIN);
		
		Funcionario func2 = new Funcionario(null,"José Mário", null, null, null, null, null, null, null, null, null, null, null, null, pe.encode("123456"), "mario");
		Funcionario func3 = new Funcionario(null,"Luciano", null, null, null, null, null, null, null, null, null, null, null, null, pe.encode("1234567"), "luciano");
		Funcionario func4 = new Funcionario(null,"Angelina Jolie", null, null, null, null, null, null, null, null, null, null, null, null, pe.encode("12345678"), "jolie");
		Funcionario func5 = new Funcionario(null,"Suzana", null, null, null, null, null, null, null, null, null, null, null, null, pe.encode("123456789"), "suzana");
		Funcionario func6 = new Funcionario(null,"Cristiane", null, null, null, null, null, null, null, null, null, null, null, null, pe.encode("1234567890"), "cristiane");
		Funcionario func7 = new Funcionario(null,"Malu", null, null, null, null, null, null, null, null, null, null, null, null, pe.encode("1234"), "malu");
		Funcionario func8 = new Funcionario(null,"Priscila", null, null, null, null, null, null, null, null, null, null, null, null, pe.encode("123"), "priscila");
		Funcionario func9 = new Funcionario(null,"Fernanda", null, null, null, null, null, null, null, null, null, null, null, null, pe.encode("12"), "fernanda");
		
		Passadoria pas1 = new Passadoria(null,null,null,"teste 1", null, null);
		Passadoria pas2 = new Passadoria(null,null,null,"teste 2", null, null);
		
		func1.getPassadorias().addAll(Arrays.asList(pas1,pas2));
		func2.getPassadorias().addAll(Arrays.asList(pas2));

		pas1.getFuncionarios().addAll(Arrays.asList(func1,func2));
		pas2.getFuncionarios().addAll(Arrays.asList(func2));
		
		Passador pd1 = new Passador(null,null,null,99999,0,"Eduardo");
		Passador pd2 = new Passador(null,null,null,00001,0,"Carlos");		
		
		PassadorItem pdi1 = new PassadorItem(pd1,func1,50);
		PassadorItem pdi2 = new PassadorItem(pd1,func2,120);
		
		PassadorItem pdi3 = new PassadorItem(pd2,func1,10);
		PassadorItem pdi4 = new PassadorItem(pd2,func2,20);
		
		pd1.getItens().addAll(Arrays.asList(pdi1,pdi2));
		pd2.getItens().addAll(Arrays.asList(pdi3,pdi4));
		
		func1.getItens().addAll(Arrays.asList(pdi1));
		func2.getItens().addAll(Arrays.asList(pdi2));
		
		funcionarioRepository.saveAll(Arrays.asList(func1,func2,func3,func4,func5,func6,func7,func8,func9));
		//passadoriaRepository.saveAll(Arrays.asList(pas1,pas2));
		passadorRepository.saveAll(Arrays.asList(pd1,pd2));
		passadorItemRepository.saveAll(Arrays.asList(pdi1,pdi2,pdi3,pdi4));
	}

}
