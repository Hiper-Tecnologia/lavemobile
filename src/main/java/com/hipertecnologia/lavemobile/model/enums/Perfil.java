package com.hipertecnologia.lavemobile.model.enums;

public enum Perfil {

	ADMIN(1,"ROLE_ADMIN"),
	FUNCIONARIO(2,"ROLE_CLIENTE");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.setCod(cod);
		this.setDescricao(descricao);
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod); 
	}
}
