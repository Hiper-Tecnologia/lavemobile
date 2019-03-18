package com.hipertecnologia.lavemobile.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "db2_passadoriaItem")
public class PassadorItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private PassadorItemPK id = new PassadorItemPK();
	
	private Integer quantidade;
	
	public PassadorItem() {
		
	}

	public PassadorItem(Passador passador,Funcionario funcionario, Integer quantidade) {
		super();
		id.setPassador(passador);
		id.setFuncionario(funcionario);
		this.quantidade = quantidade;
	}

	@JsonIgnore
	public Passador getPassador() {
		return id.getPassador();
	}

	public void setPassador(Passador passador) {
		id.setPassador(passador);
	}

	public Funcionario getFuncionario() {
		return id.getFuncionario();
	}

	public void setFuncionario(Funcionario funcionario) {
		id.setFuncionario(funcionario);
	}
	
	public PassadorItemPK getId() {
		return id;
	}

	public void setId(PassadorItemPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		PassadorItem other = (PassadorItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
