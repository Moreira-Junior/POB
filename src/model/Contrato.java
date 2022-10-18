package model;

public class Contrato {

	private String id;
	private String data;
	private Modalidade modalidade;
	private Pet pet;
	
	public Contrato(String id, String data, Modalidade modalidade, Pet pet) {
		this.id = id;
		this.data = data;
		this.modalidade = modalidade;
		this.pet = pet;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", data=" + data + ", modalidade=" + modalidade + ", pet=" + pet + "]";
	}
	
}
