package model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@Entity
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String data;
	@Embedded
	private Modalidade modalidade;
	@OneToOne()
	private Pet pet;
	@Version
	private Long versao;
	
	public Contrato() {
		
	}
	
	public Contrato(int id, String data, Modalidade modalidade, Pet pet) {
		this.id = id;
		this.data = data;
		this.modalidade = modalidade;
		this.pet = pet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public Long getVersao() {
		return versao;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", data=" + data + ", modalidade=" + modalidade + ", pet=" + pet + "]";
	}
}
