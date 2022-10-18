package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import model.Contrato;
import model.Pet;
import model.Procedimento;
import model.Veterinario;


public class Consultar {
	protected ObjectContainer manager;

	public Consultar(){
		manager = Util.conectarDb4oAgendaLocal();
		consultar();
		manager.close();
		
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplica��o");
	}

	public void consultar(){
		System.out.println("\n---listar  veterinario com nome Fa");
		
		Query q = manager.query();
		q.constrain(Veterinario.class);  
		q.descend("nome").constrain("Fa").startsWith(true);
		List<Veterinario> resultados = q.execute();
		
		for(Veterinario c: resultados)
			System.out.println(c);
		
		System.out.println("\n---listar  veterinario com especialidade poo1");

		
		Query q2 = manager.query();
		q2.constrain(Veterinario.class);  
		q2.descend("especialidade").constrain("POO1");
		List<Veterinario> resultados2 = q2.execute();
		
		for(Veterinario c: resultados2)
			System.out.println(c);
		
		
		System.out.println("\n---listar pets cujo dono mora no endereco rua 6");
		Query q3 = manager.query();
		q3.constrain(Pet.class);
		q3.descend("tutor").descend("endereco").descend("rua").constrain("Rua 6");
		List<Pet> resultados3 = q3.execute();
		
		for(Pet pet: resultados3)
			System.out.println(pet);
		
		
		System.out.println("\n---Procedimentos cujos pets tem o tutor de nome Ana Beatriz1");
		Query q4 = manager.query();
		q4.constrain(Procedimento.class);
		q4.descend("pet").descend("tutor").descend("nome").constrain("Ana Beatriz1");
		List<Procedimento> resultados4 = q4.execute();
		
		for(Procedimento procedimento: resultados4) {
			System.out.println(procedimento);
		}
		
		System.out.println("\n---contratos da modalidade completo"
				+ " cujo pet tem um tutor que more na paraiba");
		Query q5 = manager.query();
		q5.constrain(Contrato.class);
		q5.descend("pet").descend("tutor").descend("endereco").descend("estado").constrain("Paraiba");
		q5.descend("modalidade").descend("nome").constrain("completo");
		
		List<Contrato> resultados5 = q5.execute();
		for(Contrato contrato: resultados5) {
			System.out.println(contrato);
		}
	}

	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

