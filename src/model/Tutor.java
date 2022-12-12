package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
@Entity
public class Tutor extends Pessoa {

	private int telefone;
	@OneToMany(mappedBy = "tutor", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Pet> pets;
	
	public Tutor() {
		
	}
	
	public Tutor(String nome, String cpf, Endereco endereco, int telefone) {
		super(nome, cpf, endereco);
		this.telefone = telefone;
		this.pets = new ArrayList<Pet>();
	}
	
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "Tutor [telefone=" + getTelefone() + ", pets=" + getPets() + "]";
	}
	
}
