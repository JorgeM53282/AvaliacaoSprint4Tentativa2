package com.Avaliacao4.AvaliacaoSprint4.DTO;

import com.Avaliacao4.AvaliacaoSprint4.Entity.Endereco;

public class EnderecoDto {

	
	private String estado;
	private String pais;
	private String cidade;
	private String rua;
	private String cep;

	
	
	
	public EnderecoDto(Endereco endereco) {
		this.cep = endereco.getCep();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.pais = endereco.getPais();
		this.rua = endereco.getRua();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	
}
