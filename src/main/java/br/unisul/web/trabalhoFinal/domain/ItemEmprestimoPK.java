package br.unisul.web.trabalhoFinal.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemEmprestimoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="emprestimo_id")
	private Emprestimo emprestimo;
	
	@ManyToOne
	@JoinColumn(name="livro_id")
	private Livro livro;

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emprestimo == null) ? 0 : emprestimo.hashCode());
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
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
		ItemEmprestimoPK other = (ItemEmprestimoPK) obj;
		if (emprestimo == null) {
			if (other.emprestimo != null)
				return false;
		} else if (!emprestimo.equals(other.emprestimo))
			return false;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		return true;
	}
	
}
