package com.hipertecnologia.lavemobile.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "db2_passadoria")
public class Passador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date inicio;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date finalizacao;
	private Integer id_piloto_mestre;
	private Integer finalizado;
	private String operador;
	
	@OneToMany(mappedBy="id.passador")
	private Set<PassadorItem> itens = new HashSet<>();
	
	public Passador() {
		
	}

	public Passador(Integer id, Date inicio, Date finalizacao, Integer id_piloto_mestre, Integer finalizado,
			String operador) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.finalizacao = finalizacao;
		this.id_piloto_mestre = id_piloto_mestre;
		this.finalizado = finalizado;
		this.operador = operador;
	}
	
	
	public Set<PassadorItem> getItens() {
		return itens;
	}

	public void setItens(Set<PassadorItem> itens) {
		this.itens = itens;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFinalizacao() {
		return finalizacao;
	}

	public void setFinalizacao(Date finalizacao) {
		this.finalizacao = finalizacao;
	}

	public Integer getId_piloto_mestre() {
		return id_piloto_mestre;
	}

	public void setId_piloto_mestre(Integer id_piloto_mestre) {
		this.id_piloto_mestre = id_piloto_mestre;
	}

	public Integer getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Integer finalizado) {
		this.finalizado = finalizado;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
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
		Passador other = (Passador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
}
