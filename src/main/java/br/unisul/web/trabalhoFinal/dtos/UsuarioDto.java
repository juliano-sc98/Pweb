package br.unisul.web.trabalhoFinal.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.unisul.web.trabalhoFinal.domain.Usuario;
import br.unisul.web.trabalhoFinal.domain.enums.TipoUsuario;

public class UsuarioDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	private Integer idade;
	private String sexo;
	private Integer tipo;
	
	public UsuarioDto() {
	}
	
	public UsuarioDto(Usuario obj, TipoUsuario tipo) {
		id = obj.getId();
		nome = obj.getNome();
		idade = obj.getIdade();
		sexo = obj.getSexo();
		this.tipo = (tipo == null)?null:tipo.getCod();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
}
