package br.unisul.web.trabalhoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.web.trabalhoFinal.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
