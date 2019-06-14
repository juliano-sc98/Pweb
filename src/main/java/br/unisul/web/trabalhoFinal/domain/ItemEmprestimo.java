package br.unisul.web.trabalhoFinal.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemEmprestimo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemEmprestimoPK id = new ItemEmprestimoPK();
	
	public ItemEmprestimo() {
	}

	public ItemEmprestimo(Livro livro, Emprestimo emprestimo) {
		super();
		id.setLivro(livro);
		id.setEmprestimo(emprestimo);
	}
	
	@JsonIgnore
	public Emprestimo getEmprestimo() {
		return id.getEmprestimo();
	}
	
	public void setEmprestimo(Emprestimo emprestimo) {
		id.setEmprestimo(emprestimo);
	}
	
	public void setLivro(Livro livro) {
		id.setLivro(livro);
	}
	
	public Livro getLivro() {
		return id.getLivro();
	}
	
	public ItemEmprestimoPK getId() {
		return id;
	}
	
	public void setId(ItemEmprestimoPK id) {
		this.id = id;
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
		ItemEmprestimo other = (ItemEmprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
