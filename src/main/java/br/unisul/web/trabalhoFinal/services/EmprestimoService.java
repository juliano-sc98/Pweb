package br.unisul.web.trabalhoFinal.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.trabalhoFinal.domain.Emprestimo;
import br.unisul.web.trabalhoFinal.domain.ItemEmprestimo;
import br.unisul.web.trabalhoFinal.domain.Usuario;
import br.unisul.web.trabalhoFinal.repositories.EmprestimoRepository;
import br.unisul.web.trabalhoFinal.repositories.ItemEmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository rep;
	
	@Autowired
	private ItemEmprestimoRepository itemEmprestimoRepository;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Emprestimo buscar(Integer id) {
		Optional<Emprestimo> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Emprestimo insert(Emprestimo obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setUsuario(usuarioService.find(obj.getUsuario().getId()));
		Date a = obj.getDevolucao();
		obj = rep.save(obj);
		for(ItemEmprestimo ip : obj.getItens()) {
			while((livroService.find(ip.getLivro().getId())) != null && (ip.getLivro().getExemplares()) != 0) {
				ip.setLivro(livroService.find(ip.getLivro().getId()));
				ip.getLivro().setExemplares(ip.getLivro().getExemplares() - 1);
			}
			if (a.equals(obj.getDevolucao())) {
				ip.getLivro().setExemplares(ip.getLivro().getExemplares() + 1);
			}
			ip.setEmprestimo(obj);
		}
		itemEmprestimoRepository.saveAll(obj.getItens());
		return obj;
	}
	
	public List<Emprestimo> findByUsuario(Integer idUsuario) {
		Usuario usuario = usuarioService.find(idUsuario);
		return rep.findByUsuario(usuario);
	}
}
