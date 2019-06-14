package br.unisul.web.trabalhoFinal.dtos;

import java.io.Serializable;

import br.unisul.web.trabalhoFinal.domain.Livro;

public class LivroDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String areaConhecimento;
	private Integer exemplares;
	private String localizacao;
	
	public LivroDto() {
	}
	
	public LivroDto(Livro obj) {
		id = obj.getId();
		titulo = obj.getTitulo();
		areaConhecimento = obj.getAreaConhecimento();
		exemplares = obj.getExemplares();
		localizacao = obj.getLocalizacao();
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

	
	
}
