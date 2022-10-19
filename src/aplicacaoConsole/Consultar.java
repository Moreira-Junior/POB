package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import com.db4o.ObjectContainer;

import regras_negocio.Fachada;


public class Consultar {
	protected ObjectContainer manager;

	public Consultar(){
		Fachada.inicializar();
		try {
			System.out.println("\n---listar  veterinario com nome Fa");
			System.out.println(Fachada.veterinarioTrechoDeNome("Fa"));
			System.out.println("\n---listar  veterinario com especialidade poo1");
			System.out.println(Fachada.listarVeterinarioPorEspecialidade("POO2"));
			System.out.println("\n---listar pets cujo dono mora no endereco rua 6");
			System.out.println(Fachada.petsPorRua("Rua 5"));
			System.out.println("\n---Procedimentos cujos pets tem o tutor de nome Ana Beatriz1");
			System.out.println(Fachada.procedimentosPorPetPorDono("Ana Beatriz2"));
			System.out.println("\n---contratos da modalidade completo"
					+ " cujo pet tem um tutor que more na paraiba");
			System.out.println(Fachada.contratosPorModalidadePorEstado("completo", "Paraiba"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}
		
	}

	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

