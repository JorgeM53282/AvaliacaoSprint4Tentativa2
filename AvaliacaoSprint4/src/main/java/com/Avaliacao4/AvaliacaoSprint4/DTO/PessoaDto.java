package com.Avaliacao4.AvaliacaoSprint4.DTO;



import com.Avaliacao4.AvaliacaoSprint4.Entity.Pessoa;

public class PessoaDto {

	private String nome;

	private String cpf;
	
	


	public PessoaDto(Pessoa pessoa) {
		super();
		this.cpf = pessoa.getCpf();
		this.nome = pessoa.getNome();
	}


	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

}
