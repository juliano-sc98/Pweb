package br.unisul.web.trabalhoFinal.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.trabalhoFinal.domain.Usuario;
import br.unisul.web.trabalhoFinal.domain.enums.TipoUsuario;
import br.unisul.web.trabalhoFinal.dtos.UsuarioDto;
import br.unisul.web.trabalhoFinal.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository rep;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public List<Usuario> findAll() {
		return rep.findAll();
	}
	
	public Usuario fromDto(UsuarioDto objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getIdade(), objDto.getSexo(), TipoUsuario.toEnum(objDto.getTipo()));
	}

	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = rep.save(obj);
		return obj;
	}
	
}
