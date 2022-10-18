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

import model.Pet;
import model.Veterinario;

public class Listar {
	protected ObjectContainer manager;

	public Listar(){
		manager = Util.conectarDb4oAgendaLocal();
		listar();
		manager.close();
		
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplica��o");
	}

	public void listar(){
		System.out.println("\n---listagem de veterinario:");
		
		Query q = manager.query();
		q.constrain(Veterinario.class);  				
		List<Veterinario> resultados = q.execute();
		for(Veterinario p: resultados)
			System.out.println(p);
		
		System.out.println("\n---listagem de pets:");
		Query q2 = manager.query();
		q2.constrain(Pet.class);
		List<Pet> pets = q2.execute();
		for(Pet pet : pets) {
			System.out.println(pet);
		}
	}
	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

