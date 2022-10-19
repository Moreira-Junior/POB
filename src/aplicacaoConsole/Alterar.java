package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import com.db4o.ObjectContainer;

import regras_negocio.Fachada;

public class Alterar {
	protected ObjectContainer manager;

	public Alterar(){
		Fachada.inicializar();
		try {
			Fachada.alterarEspecialidadeVeterinario("123", "geral");
			Fachada.adicionarPet("Canjica", "cachorro", "poodle", "523456789", "macho", "16/11/2011", "completo", false);
			Fachada.alterarContratoDoPet(1, "intermediario", false);
			Fachada.alterarValorDeProcedimento(1, 20);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");

	}

	//=================================================
	public static void main(String[] args) {
		new Alterar();
	}
}

