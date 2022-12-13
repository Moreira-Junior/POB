package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

@Entity
public class Procedimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String descricao;
	private double valor;
	@ManyToOne
	private Pet pet;
	@ManyToOne
	private Veterinario veterinario;
	private String data;
	@Version
	private Long versao;
	
	public Procedimento() {
	}

	public Procedimento(int codigo, String descricao, double valor, Pet pet, Veterinario veterinario, String data) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.pet = pet;
		this.veterinario = veterinario;
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public Long getVersao() {
		return versao;
	}

	@Override
	public String toString() {
		return "Procedimento [codigo=" + codigo + ", descricao=" + descricao + ", valor=" + valor + ", pet=" + pet
				+ ", veterinario=" + veterinario + ", data=" + data + "]";
	}

}
