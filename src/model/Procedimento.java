package model;

public class Procedimento {

	private int codigo;
	private String descricao;
	private double valor;
	private Pet pet;
	private Veterinario veterinario;
	private String data;
	
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

	@Override
	public String toString() {
		return "Procedimento [codigo=" + codigo + ", descricao=" + descricao + ", valor=" + valor + ", pet=" + pet
				+ ", veterinario=" + veterinario + ", data=" + data + "]";
	}
	
}
