package model;

public class Pet {
	
	private int id;
	private String nome;
	private String especie;
	private String raca;
	private String sexo;
	private Tutor tutor;
	private Contrato contrato;

	public Pet(int id, String nome, String especie, String raca, String sexo, Tutor tutor) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.sexo = sexo;
		this.tutor = tutor;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", especie=" + especie + ", raca=" + raca + ", sexo=" + sexo
				+ ", tutor=" + tutor.getNome() + ", contrato=" + contrato.getModalidade() + "]";
	}
}
