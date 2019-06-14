package br.unisul.web.trabalhoFinal.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.web.trabalhoFinal.domain.Livro;
import br.unisul.web.trabalhoFinal.dtos.LivroDto;
import br.unisul.web.trabalhoFinal.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> find(@PathVariable Integer id) {
		Livro obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Livro obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LivroDto>> findAll() {
		List<Livro> list = service.findAll();
		List<LivroDto> listDto = new ArrayList<LivroDto>();
		for (Livro l : list) {
			listDto.add(new LivroDto(l));
		}
		return ResponseEntity.ok().body(listDto);
	}
	
}
