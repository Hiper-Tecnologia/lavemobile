package com.hipertecnologia.lavemobile.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hipertecnologia.lavemobile.dto.FuncionarioDTO;
import com.hipertecnologia.lavemobile.model.Funcionario;
import com.hipertecnologia.lavemobile.model.enums.Perfil;
import com.hipertecnologia.lavemobile.repositories.FuncionarioRepository;
import com.hipertecnologia.lavemobile.security.UserSS;
import com.hipertecnologia.lavemobile.services.exception.AuthorizationException;
import com.hipertecnologia.lavemobile.services.exception.DataIntegrityException;
import com.hipertecnologia.lavemobile.services.exception.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Funcionario find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso Negado");
		}
		
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id:"+ id + " tipo: "+ Funcionario.class.getName()));
	}
	
	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Funcionario update(Funcionario obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
	} 
		catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir um Funcionário relacionados à atividades já existentes.");
		}
	}
	
	public List<Funcionario> findAll() {
		return repo.findAll();
	}
	
	public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Funcionario fromDTO(FuncionarioDTO objDto) {
		return new Funcionario(objDto.getId(), objDto.getNome(), objDto.getFuncao(), objDto.getData_admissao(), objDto.getData_demissao(),
					objDto.getAtivo(), objDto.getData_aniversario(), objDto.getTelefone(), objDto.getObservacao(), objDto.getOperador_terminal(),
					objDto.getGerente_etapa(), objDto.getGerente_etapa2(), objDto.getResponsavel(), objDto.getAuxiliar(),
					pe.encode(objDto.getFunc_senha()), objDto.getfLogin());
	}
	
	
}
