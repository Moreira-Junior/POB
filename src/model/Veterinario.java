package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Veterinario extends Pessoa{
	
	private String crv;
	private String especialidade;
	@OneToMany(mappedBy = "veterinario", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
	private List<Procedimento> procedimentos;
	
	public Veterinario() {
		
	}
	
	public Veterinario(String crv, String nome, String cpf, Endereco endereco, String especialidade) {
		super(nome, cpf, endereco);
		this.crv = crv;
		this.especialidade = especialidade;
		this.procedimentos = new ArrayList<Procedimento>();
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
	
	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	@Override
	public String toString() {
		return "Veterinario [crv=" + crv + ", especialidade=" + especialidade + "]";
	}
	
}
