package com.Avaliacao4.AvaliacaoSprint4.Form;

import javax.validation.constraints.NotNull;

public class EnderecoForm {
	@NotNull
	private String pais;
	@NotNull
	private String estado;
	@NotNull
	private String cidade;
	@NotNull
	private String cep;
	@NotNull
	private String rua;

	public EnderecoForm() {
		super();
	}

	public EnderecoForm(String pais, String estado, String cidade, String cep, String rua) {
		super();
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.rua = rua;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
