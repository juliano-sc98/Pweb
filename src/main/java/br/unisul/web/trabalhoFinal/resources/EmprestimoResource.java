package br.unisul.web.trabalhoFinal.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.web.trabalhoFinal.domain.Emprestimo;
import br.unisul.web.trabalhoFinal.services.EmprestimoService;

@RestController
@RequestMapping(value="/emprestimos")
public class EmprestimoResource {

	@Autowired
	private EmprestimoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Emprestimo obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Emprestimo obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{usuarioId}/usuario", method = RequestMethod.GET)
	ResponseEntity<List<Emprestimo>> findByUsuario(@PathVariable Integer usuarioId) {
		List<Emprestimo> list = service.findByUsuario(usuarioId);
		return ResponseEntity.ok().body(list);
	}
	
}
