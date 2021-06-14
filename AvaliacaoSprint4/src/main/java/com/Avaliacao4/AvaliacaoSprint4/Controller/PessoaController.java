package com.Avaliacao4.AvaliacaoSprint4.Controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Avaliacao4.AvaliacaoSprint4.DTO.EnderecoDto;
import com.Avaliacao4.AvaliacaoSprint4.DTO.PessoaDto;
import com.Avaliacao4.AvaliacaoSprint4.Entity.Endereco;
import com.Avaliacao4.AvaliacaoSprint4.Entity.Pessoa;
import com.Avaliacao4.AvaliacaoSprint4.Form.EnderecoForm;
import com.Avaliacao4.AvaliacaoSprint4.Form.PessoaForm;
import com.Avaliacao4.AvaliacaoSprint4.Repository.EnderecoRepository;
import com.Avaliacao4.AvaliacaoSprint4.Repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping("/{id}")
	public ResponseEntity<?> busca(@PathVariable Long id) {
		Pessoa pessoa = pessoaRepository.getById(id);
		if (pessoa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoa);
	}

	@RequestMapping(value = "/criarEndereco", method = RequestMethod.POST)
	public ResponseEntity<EnderecoDto> save(@RequestBody @Valid EnderecoForm enderecoForm, UriComponentsBuilder builder) {

		Endereco endereco = new Endereco();
		endereco.convertEndereco(enderecoForm);
		enderecoRepository.save(endereco);
		URI uri = builder.path("/{id}").buildAndExpand(endereco.getId()).toUri();

		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
	}

	@RequestMapping(value = "/criarPessoa", method = RequestMethod.POST)
	public ResponseEntity<PessoaDto> save(@RequestBody @Valid PessoaForm pessoaForm, UriComponentsBuilder builder) {

		Pessoa pessoa = new Pessoa();
		pessoa.convert(pessoaForm);
		pessoaRepository.save(pessoa);

		URI uri = builder.path("/{id}").buildAndExpand(pessoa.getId()).toUri();

		return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
	}

}
