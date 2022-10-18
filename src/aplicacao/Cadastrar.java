package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import regras_negocio.Fachada;

public class Cadastrar {
	
	public Cadastrar() {
		try {
			System.out.println("cadastrando...");
			Fachada.inicializar();
			Fachada.criarTutor("Ana Beatriz1", "123456789", "Rua 1", "Jaguaribe", 
					"Joao Pessoa", "Paraiba", 1111111);
			Fachada.criarTutor("Ana Beatriz2", "223456789", "Rua 2", "Jaguaribe", 
					"Joao Pessoa", "Paraiba", 2111111);
			Fachada.criarTutor("Ana Beatriz3", "323456789", "Rua 3", "Jaguaribe", 
					"Joao Pessoa", "Paraiba", 3111111);
			Fachada.criarTutor("Ana Beatriz4", "423456789", "Rua 4", "Jaguaribe", 
					"Joao Pessoa", "Paraiba", 4111111);
			Fachada.criarTutor("Ana Beatriz5", "523456789", "Rua 5", "Jaguaribe", 
					"Joao Pessoa", "Paraiba", 5111111);

			Fachada.criarVeterinario("123", "Fausto1", "1234567", "Rua 6", "Jaguaribe", 
					"Joao Pessoa", "Paraiba", "POO1");
			Fachada.criarVeterinario("223", "Fausto2", "2234567", "Rua 7", "Jaguaribe", 
					"Joao Pessoa", "Paraiba", "POO2");
			Fachada.criarVeterinario("323", "Fausto3", "3234567", "Rua 8", "Jaguaribe", 
					"Joao Pessoa", "Paraiba", "POO3");
			Fachada.criarVeterinario("423", "Fausto4", "4234567", "Rua 9", "Jaguaribe", 
					"Joao Pessoa", "Paraiba", "POO4");
			Fachada.criarVeterinario("523", "Fausto5", "5234567", "Rua 10", 
					"Jaguaribe", "Joao Pessoa", "Paraiba", "POO5");
			
			Fachada.criarPet("Panqueca1", "cachorro", "pitbull", "123456789", 
					"femea", "11/11/2011", "basico", true);
			Fachada.criarPet("Pimentinha", "cachorro", "beagle", "223456789", 
					"femea", "12/11/2011", "intermediario", true);
			Fachada.criarPet("Panqueca3", "cachorro", "pitbull", "323456789", "femea", "13/11/2011", "completo", true);
			Fachada.criarPet("Panqueca4", "cachorro", "pitbull", "423456789", "femea", "14/11/2011", "basico", false);
			Fachada.criarPet("Panqueca5", "cachorro", "pitbull", "523456789", "femea", "15/11/2011", "intermediario", false);
			
			Fachada.criarProcedimento("21/05/2022", "descricao1", 10, 1, "123");
			Fachada.criarProcedimento("22/05/2022", "descricao2", 11, 2, "223");
			Fachada.criarProcedimento("23/05/2022", "descricao3", 12, 3, "323");
			Fachada.criarProcedimento("24/05/2022", "descricao4", 13, 4, "423");
			Fachada.criarProcedimento("25/05/2022", "descricao5", 14, 5, "523");
			
			System.out.println("Cadastro realizado com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}
	}

	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


