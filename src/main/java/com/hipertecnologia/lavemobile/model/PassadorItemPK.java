package com.hipertecnologia.lavemobile.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PassadorItemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="passador_id")
	private Passador passador;

	@ManyToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;
	
	public Passador getPassador() {
		return passador;
	}
	public void setPassador(Passador passador) {
		this.passador = passador;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((passador == null) ? 0 : passador.hashCode());
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
		PassadorItemPK other = (PassadorItemPK) obj;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (passador == null) {
			if (other.passador != null)
				return false;
		} else if (!passador.equals(other.passador))
			return false;
		return true;
	}

	
}
