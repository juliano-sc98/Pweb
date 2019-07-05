package br.unisul.web.trabalhoFinal.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.unisul.web.trabalhoFinal.domain.Emprestimo;
import br.unisul.web.trabalhoFinal.domain.ItemEmprestimo;
import br.unisul.web.trabalhoFinal.domain.Usuario;

public class EmprestimoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date devolucao;
	private Usuario usuario;
	private Set<ItemEmprestimo> itens = new HashSet<>();
	
	public EmprestimoDto() {
	}
	
	public EmprestimoDto(Emprestimo obj) {
		id = obj.getId();
		instante = obj.getInstante();
		devolucao = obj.getDevolucao();
		usuario = obj.getUsuario();
		itens = obj.getItens();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Date getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<ItemEmprestimo> getItens() {
		return itens;
	}

	public void setItens(Set<ItemEmprestimo> itens) {
		this.itens = itens;
	}
	
}
