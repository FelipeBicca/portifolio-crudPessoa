package com.github.portifolio.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.portifolio.model.Pessoa;
import com.github.portifolio.repository.PessoaRepository;

public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa adicionar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaExistente = pessoaRepository.findById(id).orElse(null);
		if (pessoaExistente != null) {
			BeanUtils.copyProperties(pessoa, pessoaExistente, "id");
			pessoaRepository.save(pessoaExistente);
			return pessoaExistente;
		}
		return null;
	}

	@Override
	public void remover(Long id) {
		Pessoa pessoaExistente = pessoaRepository.findById(id).orElse(null);
		if (pessoaExistente != null) {
			pessoaRepository.delete(pessoaExistente);
		}
	}

}
