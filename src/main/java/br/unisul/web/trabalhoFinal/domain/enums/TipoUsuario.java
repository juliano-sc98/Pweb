package br.unisul.web.trabalhoFinal.domain.enums;

public enum TipoUsuario {

	USUARIOPROFESSOR(1, "Usuário Professor"),
	USUARIOALUNO(2, "Usuário Aluno");
	
	private int cod;
	private String descricao;
	
	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoUsuario toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoUsuario x : TipoUsuario.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
		
}
