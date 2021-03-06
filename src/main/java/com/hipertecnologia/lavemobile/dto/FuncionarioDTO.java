package com.hipertecnologia.lavemobile.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.hipertecnologia.lavemobile.model.Funcionario;

public class FuncionarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5,max=100)
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
	private String func_senha;
	private String flogin;

	public FuncionarioDTO() {
	}
	
	public FuncionarioDTO(Funcionario obj) {
		id = obj.getId();
		nome = obj.getNome();
		funcao = obj.getFuncao();
		data_admissao = obj.getData_admissao();
		data_demissao = obj.getData_demissao();
		ativo = obj.getAtivo();
		data_aniversario = obj.getData_aniversario();
		telefone = obj.getTelefone();
		observacao = obj.getObservacao();
		operador_terminal = obj.getOperador_terminal();
		gerente_etapa = obj.getGerente_etapa();
		gerente_etapa2 = obj.getGerente_etapa2();
		responsavel = obj.getResponsavel();
		auxiliar = obj.getAuxiliar();
		func_senha = obj.getFunc_senha();
		flogin = obj.getFlogin();
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

	public String getfLogin() {
		return flogin;
	}

	public void setFlogin(String flogin) {
		this.flogin = flogin;
	}
	
	
	
}
