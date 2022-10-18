package model;

public class Veterinario extends Pessoa{
	
	private String crv;
	private String especialidade;
	
	public Veterinario(String crv, String nome, String cpf, Endereco endereco, String especialidade) {
		super(nome, cpf, endereco);
		this.crv = crv;
		this.especialidade = especialidade;
	}
	
	public String getCrv() {
		return crv;
	}

	public void setCrv(String crv) {
		this.crv = crv;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return "Veterinario [crv=" + crv + ", especialidade=" + especialidade + "]";
	}
	
}
