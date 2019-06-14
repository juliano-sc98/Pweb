package br.unisul.web.trabalhoFinal.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.trabalhoFinal.domain.Emprestimo;
import br.unisul.web.trabalhoFinal.domain.ItemEmprestimo;
import br.unisul.web.trabalhoFinal.domain.Livro;
import br.unisul.web.trabalhoFinal.domain.Usuario;
import br.unisul.web.trabalhoFinal.domain.enums.TipoUsuario;
import br.unisul.web.trabalhoFinal.repositories.EmprestimoRepository;
import br.unisul.web.trabalhoFinal.repositories.ItemEmprestimoRepository;
import br.unisul.web.trabalhoFinal.repositories.LivroRepository;
import br.unisul.web.trabalhoFinal.repositories.UsuarioRepository;

@Service
public class DbService {
	
	@Autowired
	private EmprestimoRepository emp;
	
	@Autowired
	private ItemEmprestimoRepository ite;

	@Autowired
	private LivroRepository liv;
	
	@Autowired
	private UsuarioRepository usu;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Usuario usu1 = new Usuario(null, "Juliano Santos Carlos", 20, "Masculino", TipoUsuario.USUARIOALUNO);
		Usuario usu2 = new Usuario(null, "Maria Luiza", 19, "Feminino", TipoUsuario.USUARIOPROFESSOR);
		
		usu.saveAll(Arrays.asList(usu1, usu2));
		
		Livro l1 = new Livro(null, "Percy Jackson", "Aventura", 5, "F53J47");
		Livro l2 = new Livro(null, "Jogos Vorazes", "Aventura", 4, "F53J46");
		Livro l3 = new Livro(null, "As Crônicas do Gelo e do Fogo", "Aventura", 7, "F53J42");
		Livro l4 = new Livro(null, "Star Wars", "Aventura", 3, "F53J43");
		Livro l5 = new Livro(null, "Sherlock Holmes", "Aventura", 2, "F53J45");
		Livro l6 = new Livro(null, "It - a Coisa", "Aventura", 4, "F53J41");
		
		liv.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Emprestimo emp1 = new Emprestimo(null, sdf.parse("21/10/2018 15:48"), usu1, null);
		Emprestimo emp2 = new Emprestimo(null, sdf.parse("29/08/2017 14:32"), usu2, null);
		
		emp.saveAll(Arrays.asList(emp1, emp2));
		
		usu1.getEmprestimos().addAll(Arrays.asList(emp1));
		usu2.getEmprestimos().addAll(Arrays.asList(emp2));
		
		ItemEmprestimo ie1 = new ItemEmprestimo(l1, emp1);
		ItemEmprestimo ie2 = new ItemEmprestimo(l2, emp1);
		ItemEmprestimo ie3 = new ItemEmprestimo(l3, emp1);
		ItemEmprestimo ie4 = new ItemEmprestimo(l4, emp2);
		ItemEmprestimo ie5 = new ItemEmprestimo(l5, emp2);
		ItemEmprestimo ie6 = new ItemEmprestimo(l6, emp2);
		
		emp1.getItens().addAll(Arrays.asList(ie1, ie2, ie3));
		emp2.getItens().addAll(Arrays.asList(ie4, ie5, ie6));
		
		l1.getItens().addAll(Arrays.asList(ie1));
		l2.getItens().addAll(Arrays.asList(ie2));
		l3.getItens().addAll(Arrays.asList(ie3));
		l4.getItens().addAll(Arrays.asList(ie4));
		l5.getItens().addAll(Arrays.asList(ie5));
		l6.getItens().addAll(Arrays.asList(ie6));
		
		ite.saveAll(Arrays.asList(ie1, ie2, ie3, ie4, ie5, ie6));
	}
	
}
