package aplicacaoConsole;
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
	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

