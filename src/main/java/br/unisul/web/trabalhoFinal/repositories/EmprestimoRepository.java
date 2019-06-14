package br.unisul.web.trabalhoFinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.web.trabalhoFinal.domain.Emprestimo;
import br.unisul.web.trabalhoFinal.domain.Usuario;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

	@Transactional(readOnly = true)
	List<Emprestimo> findByUsuario(Usuario usuario);
}
