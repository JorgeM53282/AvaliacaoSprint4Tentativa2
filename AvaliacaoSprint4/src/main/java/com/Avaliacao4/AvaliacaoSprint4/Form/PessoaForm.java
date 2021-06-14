package com.Avaliacao4.AvaliacaoSprint4.Form;

import javax.validation.constraints.NotNull;

public class PessoaForm {
	
	@NotNull
	private String nome;
	@NotNull
	private String cpf;
	@NotNull
	private double salario;
	@NotNull
	private char sexo;
	
	public PessoaForm() {
		super();
	}
	
	public PessoaForm(String nome, String cpf, double salario, char sexo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.sexo = sexo;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public double getSalario() {
		return salario;
	}
	public char getSexo() {
		return sexo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	
	
}