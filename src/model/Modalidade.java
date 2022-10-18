package model;

public class Modalidade {

	
	private String nome;
	private boolean coparticipacao;
	
	public Modalidade(String nome, boolean coparticipacao) {
		this.nome = nome;
		this.coparticipacao = coparticipacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isCoparticipacao() {
		return coparticipacao;
	}

	public void setCoparticipacao(boolean coparticipacao) {
		this.coparticipacao = coparticipacao;
	}

	@Override
	public String toString() {
		return "Modalidade [nome=" + nome + ", coparticipacao=" + coparticipacao + "]";
	}
}
