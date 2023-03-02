package com.github.portifolio.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.portifolio.model.Pessoa;
import com.github.portifolio.repository.PessoaRepository;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa adicionar(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@PutMapping("/{id}")
	public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Pessoa pessoaExistente = pessoaRepository.findById(id).orElse(null);
		if (pessoaExistente != null) {
			BeanUtils.copyProperties(pessoa, pessoaExistente, "id");
			pessoaRepository.save(pessoaExistente);
			return pessoaExistente;
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		Pessoa pessoaExistente = pessoaRepository.findById(id).orElse(null);
		if (pessoaExistente != null) {
			pessoaRepository.delete(pessoaExistente);
		}
	}
}
