package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import com.db4o.ObjectContainer;

import model.Contrato;
import model.Endereco;
import model.Modalidade;
import model.Pet;
import model.Procedimento;
import model.Tutor;
import model.Veterinario;

public class Cadastrar {
	protected ObjectContainer manager;

	public Cadastrar(){
		manager = Util.conectarDb4oAgendaLocal();
		cadastrar();
		manager.close();

		System.out.println("fim da aplicacao");
	}


	public void cadastrar(){
		//criar objetos e relacionamentos
		Endereco endereco1;
		Endereco endereco2;
		Endereco endereco3;
		Endereco endereco4;
		Endereco endereco5;
		Endereco endereco6;
		Endereco endereco7;
		Endereco endereco8;
		Endereco endereco9;
		Endereco endereco10;

		endereco1 = new Endereco("Rua 1", "Jaguaribe", "Joao Pessoa", "Paraiba");
		endereco2 = new Endereco("Rua 2", "Jaguaribe", "Joao Pessoa", "Paraiba");
		endereco3 = new Endereco("Rua 3", "Jaguaribe", "Joao Pessoa", "Paraiba");
		endereco4 = new Endereco("Rua 4", "Jaguaribe", "Joao Pessoa", "Paraiba");
		endereco5 = new Endereco("Rua 5", "Jaguaribe", "Joao Pessoa", "Paraiba");
		endereco6 = new Endereco("Rua 6", "Jaguaribe", "Joao Pessoa", "Paraiba");
		endereco7 = new Endereco("Rua 7", "Jaguaribe", "Joao Pessoa", "Paraiba");
		endereco8 = new Endereco("Rua 8", "Jaguaribe", "Joao Pessoa", "Paraiba");
		endereco9 = new Endereco("Rua 9", "Jaguaribe", "Joao Pessoa", "Paraiba");
		endereco10 = new Endereco("Rua 10", "Jaguaribe", "Joao Pessoa", "Paraiba");

		manager.store(endereco1);
		manager.store(endereco2);
		manager.store(endereco3);
		manager.store(endereco4);
		manager.store(endereco5);
		manager.store(endereco6);
		manager.store(endereco7);
		manager.store(endereco8);
		manager.store(endereco9);
		manager.store(endereco10);

		Veterinario veterinario1;
		Veterinario veterinario2;
		Veterinario veterinario3;
		Veterinario veterinario4;
		Veterinario veterinario5;

		veterinario1 = new Veterinario("123", "Fausto1", "1234567", endereco1, "POO1");
		veterinario2 = new Veterinario("223", "Fausto2", "2234567", endereco2, "POO2");
		veterinario3 = new Veterinario("323", "Fausto3", "3234567", endereco3, "POO3");
		veterinario4 = new Veterinario("423", "Fausto4", "4234567", endereco4, "POO4");
		veterinario5 = new Veterinario("523", "Fausto5", "5234567", endereco5, "POO5");

		manager.store(veterinario1);
		manager.store(veterinario2);
		manager.store(veterinario3);
		manager.store(veterinario4);
		manager.store(veterinario5);

		Tutor tutor1 = new Tutor("Ana Beatriz1", "123456789", endereco6, 1111111);
		Tutor tutor2 = new Tutor("Ana Beatriz2", "223456789", endereco7, 2111111);
		Tutor tutor3 = new Tutor("Ana Beatriz3", "323456789", endereco8, 3111111);
		Tutor tutor4 = new Tutor("Ana Beatriz4", "423456789", endereco9, 4111111);
		Tutor tutor5 = new Tutor("Ana Beatriz5", "523456789", endereco10, 5111111);
		
		Pet pet1 = new Pet(1, "Panqueca1", "cachorro", "pitbull", "femea", tutor1);
		Pet pet2 = new Pet(2, "Pimentinha", "cachorro", "beagle", "femea", tutor2);
		Pet pet3 = new Pet(3, "Panqueca3", "cachorro", "pitbull", "femea", tutor3);
		Pet pet4 = new Pet(4,"Panqueca4", "cachorro", "pitbull", "femea", tutor4);
		Pet pet5 = new Pet(5,"Panqueca5", "cachorro", "pitbull", "femea", tutor5);
		
		manager.store(pet1);
		manager.store(pet2);
		manager.store(pet3);
		manager.store(pet4);
		manager.store(pet5);
		
		tutor1.getPets().add(pet1);
		tutor2.getPets().add(pet2);
		tutor3.getPets().add(pet3);
		tutor4.getPets().add(pet4);
		tutor5.getPets().add(pet5);
		
		manager.store(tutor1);
		manager.store(tutor2);
		manager.store(tutor3);
		manager.store(tutor4);
		manager.store(tutor5);
		
		Modalidade modalidade1 = new Modalidade("basico", true);
		Modalidade modalidade2 = new Modalidade("intermediario", true);
		Modalidade modalidade3 = new Modalidade("completo", true);
		Modalidade modalidade4 = new Modalidade("basico", false);
		Modalidade modalidade5 = new Modalidade("intermediario", false);
		Modalidade modalidade6 = new Modalidade("completo", false);
		
		
		manager.store(modalidade1);
		manager.store(modalidade2);
		manager.store(modalidade3);
		manager.store(modalidade4);
		manager.store(modalidade5);
		manager.store(modalidade6);
		
		Contrato contrato1 = new Contrato("1", "11/11/2011", modalidade1, pet1);
		Contrato contrato2 = new Contrato("2", "12/11/2011", modalidade2, pet2);
		Contrato contrato3 = new Contrato("3", "13/11/2011", modalidade3, pet3);
		Contrato contrato4 = new Contrato("4", "14/11/2011", modalidade4, pet4);
		Contrato contrato5 = new Contrato("5", "15/11/2011", modalidade5, pet5);
		
		manager.store(contrato1);
		manager.store(contrato2);
		manager.store(contrato3);
		manager.store(contrato4);
		manager.store(contrato5);
		
		Procedimento procedimento1 = new Procedimento(1, "descricao1", 10, pet1, veterinario1, "21/05/2022");
		Procedimento procedimento2 = new Procedimento(2, "descricao2", 11, pet2, veterinario2, "22/05/2022");
		Procedimento procedimento3 = new Procedimento(3, "descricao3", 12, pet3, veterinario3, "23/05/2022");
		Procedimento procedimento4 = new Procedimento(4, "descricao4", 13, pet4, veterinario4, "24/05/2022");
		Procedimento procedimento5 = new Procedimento(5, "descricao5", 14, pet5, veterinario5, "25/05/2022");
		
		manager.store(procedimento1);
		manager.store(procedimento2);
		manager.store(procedimento3);
		manager.store(procedimento4);
		manager.store(procedimento5);
		
		manager.commit();

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


