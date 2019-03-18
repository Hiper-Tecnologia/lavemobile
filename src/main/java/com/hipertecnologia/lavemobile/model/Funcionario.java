package com.hipertecnologia.lavemobile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hipertecnologia.lavemobile.model.enums.Perfil;

@Entity
@Table(name = "funcionarios")
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String funcao;
	private Date data_admissao;
	private Date data_demissao;
	private Integer ativo;
	private Date data_aniversario;
	private String telefone;
	private String observacao;
	private String operador_terminal;
	private String gerente_etapa;
	private String gerente_etapa2;
	private String responsavel;
	private Integer auxiliar;
	
	@JsonIgnore
	private String func_senha;
	
	private String flogin;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	//@JsonManagedReference
	@ManyToMany(mappedBy="funcionarios")
	private List<Passadoria> passadorias = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="id.funcionario")
	private Set<PassadorItem> itens = new HashSet<>();
	
	
	public Funcionario() {
		addPerfil(Perfil.FUNCIONARIO);
	}

	public Funcionario(Integer id,String nome, String funcao, Date data_admissao, Date data_demissao, Integer ativo,
			Date data_aniversario, String telefone, String observacao, String operador_terminal, String gerente_etapa,
			String gerente_etapa2, String responsavel, Integer auxiliar, String func_senha, String flogin) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
		this.data_admissao = data_admissao;
		this.data_demissao = data_demissao;
		this.ativo = ativo;
		this.data_aniversario = data_aniversario;
		this.telefone = telefone;
		this.observacao = observacao;
		this.operador_terminal = operador_terminal;
		this.gerente_etapa = gerente_etapa;
		this.gerente_etapa2 = gerente_etapa2;
		this.responsavel = responsavel;
		this.auxiliar = auxiliar;
		this.func_senha = func_senha;
		this.flogin = flogin;
		addPerfil(Perfil.FUNCIONARIO);
	}

	@JsonIgnore
	public List<Passador> getPassadores() {
		List<Passador> lista = new ArrayList<>();
		for (PassadorItem x : itens) {
			lista.add(x.getPassador());
		}
		return lista;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Date getData_admissao() {
		return data_admissao;
	}

	public void setData_admissao(Date data_admissao) {
		this.data_admissao = data_admissao;
	}

	public Date getData_demissao() {
		return data_demissao;
	}

	public void setData_demissao(Date data_demissao) {
		this.data_demissao = data_demissao;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Date getData_aniversario() {
		return data_aniversario;
	}

	public void setData_aniversario(Date data_aniversario) {
		this.data_aniversario = data_aniversario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getOperador_terminal() {
		return operador_terminal;
	}

	public void setOperador_terminal(String operador_terminal) {
		this.operador_terminal = operador_terminal;
	}

	public String getGerente_etapa() {
		return gerente_etapa;
	}

	public void setGerente_etapa(String gerente_etapa) {
		this.gerente_etapa = gerente_etapa;
	}

	public String getGerente_etapa2() {
		return gerente_etapa2;
	}

	public void setGerente_etapa2(String gerente_etapa2) {
		this.gerente_etapa2 = gerente_etapa2;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Integer getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(Integer auxiliar) {
		this.auxiliar = auxiliar;
	}

	public String getFunc_senha() {
		return func_senha;
	}

	public void setFunc_senha(String func_senha) {
		this.func_senha = func_senha;
	}

	public String getFlogin() {
		return flogin;
	}

	public void setfLogin(String flogin) {
		this.flogin = flogin;
	}
	
	public List<Passadoria> getPassadorias() {
		return passadorias;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	
	public void setPassadorias(List<Passadoria> passadorias) {
		this.passadorias = passadorias;
	}
	

	public Set<PassadorItem> getItens() {
		return itens;
	}

	public void setItens(Set<PassadorItem> itens) {
		this.itens = itens;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
