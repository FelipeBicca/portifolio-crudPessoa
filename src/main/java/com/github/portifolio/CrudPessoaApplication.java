package com.github.portifolio;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.portifolio.model.Endereco;
import com.github.portifolio.model.Pessoa;
import com.github.portifolio.model.Telefone;
import com.github.portifolio.repository.EnderecoRepository;
import com.github.portifolio.repository.PessoaRepository;
import com.github.portifolio.repository.TelefoneRepository;


@SpringBootApplication
public class CrudPessoaApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudPessoaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pessoa pessoa1;
		Endereco end1;
		Endereco end2;
		Telefone tel1;
		Telefone tel2;

		end1 = new Endereco(null, "Marci Soares Farias", "220", "", "Jardim do Sol", "Rio Grande", "Rio Grande do Sul",
				"96216-708");
		end2 = new Endereco(null, "Andradas", "79", "Ótica Confidere", "Centro", "Rio Grande", "Rio Grande do Sul",
				"96200-030");

		tel1 = new Telefone(null, "53", "3233-5025");
		tel2 = new Telefone(null, "53", "99125-4000");

		pessoa1 = new Pessoa(null, "Felipe Damasceno Bicca", Arrays.asList(tel1, tel2), Arrays.asList(end1, end2),
				new Date(), "felipedbicca@hotmail.com", "017.246.580-00", "123456");

		pessoaRepository.save(pessoa1);
		telefoneRepository.saveAll( Arrays.asList(tel1, tel2));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
	}

}
