package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import regras_negocio.Fachada;


public class Deletar {

	public Deletar(){
		Fachada.inicializar();
		try {
			Fachada.deletarTutor("123456789");
			Fachada.deletarVeterinario("123");
			Fachada.deletarPet(2);			
			Fachada.deletarProcedimento(1);
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}
	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

