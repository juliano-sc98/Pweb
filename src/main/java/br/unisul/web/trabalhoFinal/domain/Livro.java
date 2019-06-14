package br.unisul.web.trabalhoFinal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	@Column(name = "area_conhecimento")
	private String areaConhecimento;
	private Integer exemplares;
	private String localizacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.livro")
	private Set<ItemEmprestimo> itens = new HashSet<>();
	
	public Livro() {
	}

	public Livro(Integer id, String titulo, String areaConhecimento, Integer exemplares, String localizacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.areaConhecimento = areaConhecimento;
		this.exemplares = exemplares;
		this.localizacao = localizacao;
	}
	
	@JsonIgnore
	public List<Emprestimo> getLivros() {
		List<Emprestimo> lista = new ArrayList<>(3);
		for (ItemEmprestimo x : itens) {
			lista.add(x.getEmprestimo());
		}
		return lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public Integer getExemplares() {
		return exemplares;
	}

	public void setExemplares(Integer exemplares) {
		this.exemplares = exemplares;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public Set<ItemEmprestimo> getItens() {
		return itens;
	}
	
	public void setItens(Set<ItemEmprestimo> itens) {
		this.itens = itens;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
