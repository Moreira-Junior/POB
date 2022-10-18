package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import model.Pet;
import model.Procedimento;
import model.Tutor;
import model.Veterinario;
import regras_negocio.Fachada;

public class Listar {
	
	public Listar() {
		try {
			Fachada.inicializar();
			
			System.out.println("Listagem de tutores");
			for(Tutor tutor : Fachada.listarTutores()) {
				System.out.println(tutor);
			}
			
			System.out.println("Listagem de pets");
			for(Pet pet : Fachada.listarPets()) {
				System.out.println(pet);
			}
			
			System.out.println("Listagem de veterinários");
			for(Veterinario veterinario: Fachada.listarVeterinarios()) {
				System.out.println(veterinario);
			}
			
			System.out.println("Listagem de procedimentos");
			for(Procedimento procedimento: Fachada.listarProcedimentos()) {
				System.out.println(procedimento);
			}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		
	}
	
//	protected ObjectContainer manager;
//
//	public Listar(){
//		manager = Util.conectarDb4oAgendaLocal();
//		listar();
//		manager.close();
//		
//		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicaï¿½ï¿½o");
//	}
//
//	public void listar(){
//		System.out.println("\n---listagem de veterinario:");
//		
//		Query q = manager.query();
//		q.constrain(Veterinario.class);  				
//		List<Veterinario> resultados = q.execute();
//		for(Veterinario p: resultados)
//			System.out.println(p);
//		
//		System.out.println("\n---listagem de pets:");
//		Query q2 = manager.query();
//		q2.constrain(Pet.class);
//		List<Pet> pets = q2.execute();
//		for(Pet pet : pets) {
//			System.out.println(pet);
//		}
//	}
	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

