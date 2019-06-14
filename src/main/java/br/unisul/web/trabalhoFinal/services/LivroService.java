package br.unisul.web.trabalhoFinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.trabalhoFinal.domain.Livro;
import br.unisul.web.trabalhoFinal.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository rep;
	
	public Livro find (Integer id) {
		Optional<Livro> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Livro insert(Livro obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	public List<Livro> findAll() {
		return rep.findAll();
	}
	
}
