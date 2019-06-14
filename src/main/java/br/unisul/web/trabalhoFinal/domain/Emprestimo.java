package br.unisul.web.trabalhoFinal.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.unisul.web.trabalhoFinal.domain.enums.TipoUsuario;

@Entity
public class Emprestimo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date devolucao;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy="id.emprestimo")
	private Set<ItemEmprestimo> itens = new HashSet<>();
	
	public Emprestimo() {
	}

	public Emprestimo(Integer id, Date instante, Usuario usuario, Date devolucao) {
		super();
		this.id = id;
		this.instante = instante;
		this.usuario = usuario;
		this.devolucao = devolucao;
	}
	
	public Set<ItemEmprestimo> getItens() {
		try {
			if (itens.size() < 4) {
				return itens;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setItens(Set<ItemEmprestimo> itens) {
		this.itens = itens;
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
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Date getDevolucao() {
		Calendar cal = Calendar.getInstance();
		if (getUsuario().getTipo() == TipoUsuario.USUARIOALUNO) {
			cal.setTime(instante);
			cal.add(Calendar.DATE, 7);
		} else {
			cal.setTime(instante);
			cal.add(Calendar.DATE, 10);
		}
		devolucao = cal.getTime();
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
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
		Emprestimo other = (Emprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Emprestimo número: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getInstante()));
		builder.append(", Usuario: ");
		builder.append(getUsuario().getNome());
		builder.append("\nDetalhes:\n");
		for (ItemEmprestimo ip : getItens()) {
			builder.append(ip.toString());
			ip.getLivro().setExemplares(ip.getLivro().getExemplares() - 1 );
		}
		builder.append(" Data de Entrega Limite: ");
		builder.append(sdf.format(getDevolucao()));
		return builder.toString();
	}
	
}
