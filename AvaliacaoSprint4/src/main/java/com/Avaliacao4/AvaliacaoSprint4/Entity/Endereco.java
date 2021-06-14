package com.Avaliacao4.AvaliacaoSprint4.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import com.Avaliacao4.AvaliacaoSprint4.Form.EnderecoForm;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "pais")
	private String pais;

	@Column(name = "estado")
	private String estado;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "cep")
	private String cep;

	@Column(name = "rua")
	private String rua;
	
	@ManyToOne
	private Pessoa pessoa;
	
	
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco() {
		super();
	}

	public Endereco(Long id, String pais, String estado, String cidade, String cep, String rua) {
		super();
		this.id = id;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.rua = rua;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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

	public void convertEndereco(@Valid EnderecoForm enderecoForm) {
		this.cep = enderecoForm.getCep();
		this.cidade = enderecoForm.getCidade();
		this.estado = enderecoForm.getEstado();
		this.pais = enderecoForm.getPais();
		this.rua = enderecoForm.getRua();
	}

	

}
