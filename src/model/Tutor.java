package model;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Pessoa {

	private int telefone;
	private List<Pet> pets;
	
	public Tutor(String nome, String cpf, Endereco endereco, int telefone) {
		super(nome, cpf, endereco);
		this.telefone = telefone;
		pets = new ArrayList<Pet>();
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
		return "Tutor [telefone=" + telefone + ", pets=" + pets + "]";
	}
	
}
