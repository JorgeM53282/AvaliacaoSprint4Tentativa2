package com.Avaliacao4.AvaliacaoSprint4.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.Avaliacao4.AvaliacaoSprint4.Form.PessoaForm;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "salario")
	private double salario;
	
	@Column(name = "sexo")
	private char sexo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<Endereco> endereco = new ArrayList<Endereco>();
	
	
	

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String cpf, double salario, char sexo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.sexo = sexo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void convert(@Valid PessoaForm pessoaForm) {
		this.nome = pessoaForm.getNome();
		this.cpf = pessoaForm.getCpf();
		this.salario = pessoaForm.getSalario();
		this.sexo = pessoaForm.getSexo();
		
	}

	

	
	
	
	
}
