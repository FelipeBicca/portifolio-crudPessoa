package com.github.portifolio.service;

import java.util.List;

import com.github.portifolio.model.Pessoa;

public interface PessoaService {
	List<Pessoa> listar();

	Pessoa adicionar(Pessoa pessoa);

	Pessoa atualizar(Long id, Pessoa pessoa);

	void remover(Long id);
}