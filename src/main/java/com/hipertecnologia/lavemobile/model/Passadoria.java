package com.hipertecnologia.lavemobile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tab_passadoria")
public class Passadoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer id_funcionarios;
	private Integer id_piloto_mestre;
	private String	nome_funcionario;
	private Integer producao;
	private Date	dthr_finalizacao;
	
	//@JsonBackReference
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="passadoria_funcionario",
		joinColumns = @JoinColumn(name="passadoria_id"),
		inverseJoinColumns = @JoinColumn(name = "funcionario_id")
	)
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public Passadoria() {
		
	}

	public Passadoria(Integer id, Integer id_funcionarios, Integer id_piloto_mestre, String nome_funcionario,
			Integer producao, Date dthr_finalizacao) {
		super();
		this.id = id;
		this.id_funcionarios = id_funcionarios;
		this.id_piloto_mestre = id_piloto_mestre;
		this.nome_funcionario = nome_funcionario;
		this.producao = producao;
		this.dthr_finalizacao = dthr_finalizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_funcionarios() {
		return id_funcionarios;
	}

	public void setId_funcionarios(Integer id_funcionarios) {
		this.id_funcionarios = id_funcionarios;
	}

	public Integer getId_piloto_mestre() {
		return id_piloto_mestre;
	}

	public void setId_piloto_mestre(Integer id_piloto_mestre) {
		this.id_piloto_mestre = id_piloto_mestre;
	}

	public String getNome_funcionario() {
		return nome_funcionario;
	}

	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}

	public Integer getProducao() {
		return producao;
	}

	public void setProducao(Integer producao) {
		this.producao = producao;
	}

	public Date getDthr_finalizacao() {
		return dthr_finalizacao;
	}

	public void setDthr_finalizacao(Date dthr_finalizacao) {
		this.dthr_finalizacao = dthr_finalizacao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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
		Passadoria other = (Passadoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

	
}
