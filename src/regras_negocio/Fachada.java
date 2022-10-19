/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package regras_negocio;

import java.util.List;

import daodb4o.DAO;
import daodb4o.DAOContrato;
import daodb4o.DAOEndereco;
import daodb4o.DAOModalidade;
import daodb4o.DAOPet;
import daodb4o.DAOProcedimento;
import daodb4o.DAOTutor;
import daodb4o.DAOVeterinario;
import model.Contrato;
import model.Endereco;
import model.Modalidade;
import model.Pet;
import model.Procedimento;
import model.Tutor;
import model.Veterinario;

public class Fachada {
	
	private static DAOContrato daocontrato = new DAOContrato();
	private static DAOEndereco daoendereco = new DAOEndereco();
	private static DAOModalidade daomodalidade = new DAOModalidade();
	private static DAOPet daopet = new DAOPet();
	private static DAOProcedimento daoprocedimento = new DAOProcedimento();
	private static DAOTutor daotutor = new DAOTutor();
	private static DAOVeterinario daoveterinario = new DAOVeterinario();
	
	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
	public static void criarVeterinario(String crv, String nome, String cpf, String rua, String bairro, 
			String cidade, String estado, String especialidade) throws  Exception{
		DAO.begin();
		if(daoveterinario.read(crv) != null) {
			DAO.rollback();
			throw new RuntimeException("Veterinario j√° existe!");
		}
		Veterinario veterinario = new Veterinario(crv, nome, cpf, 
				new Endereco (rua, bairro, cidade, estado), especialidade);
		daoveterinario.create(veterinario);
		DAO.commit();
	}
	
	public static void criarTutor(String nome, String cpf, String rua, String bairro, 
			String cidade, String estado, int telefone) {
		DAO.begin();
		if (daotutor.read(cpf) != null) {
			DAO.rollback();
			throw new RuntimeException("Tutor j√° existe!");
		}
		Tutor tutor = new Tutor(nome, cpf, new Endereco(rua, bairro, cidade, estado), telefone);
		daotutor.create(tutor);
		DAO.commit();		
	}
	
	public static void criarPet(String nome, String especie, String raca, String cpf, String sexo,
			String data, String nomeModalidade, boolean cooparticipacao) {
		DAO.begin();
		Tutor tutor = daotutor.read(cpf);
		if (tutor == null) {
			DAO.rollback();
			throw new RuntimeException("Tutor n√£o existe!");
		}
		if (tutor.getPets().stream().anyMatch(pet -> pet.getNome() == nome)) {
			DAO.rollback();
			throw new RuntimeException("Pet j√° existe!");
		}
		int id = geraIdPet();
		Pet pet = new Pet(id, nome, especie, raca, sexo, tutor);
		Contrato contrato = new Contrato(geraIdContrato(), data, new Modalidade(nomeModalidade, cooparticipacao), pet);
		pet.setContrato(contrato);
		tutor.getPets().add(pet);
		daotutor.update(tutor);
		daopet.create(pet);
		DAO.commit();
	}
	
	public static void criarProcedimento(String data, String descricao, double valor, int codPet, String crv) {
		DAO.begin();
		Pet pet = daopet.read(codPet);
		if (pet == null) {
			DAO.rollback();
			throw new RuntimeException("Pet n„o existe!");
		}
		Veterinario veterinario = daoveterinario.read(crv);
		if (veterinario == null) {
			DAO.rollback();
			throw new RuntimeException("Veterinario n„o existe");
		}
		Procedimento procedimento = new Procedimento(geraIdProcedimento(), descricao, 
				valor, pet, veterinario, data);
		daoprocedimento.create(procedimento);
		DAO.commit();
	}
	
	public static int geraIdPet() {
		DAO.begin();
		List<Pet> pets = daopet.readAll();
		DAO.commit();
		if (pets.size() == 0) {
			return 1;
		}
		else {
			return pets.stream().map(pet -> pet.getId()).max(Integer::compare).get() + 1;
		}
	}
	
	public static int geraIdContrato() {
		DAO.begin();
		List<Contrato> contratos = daocontrato.readAll();
		DAO.commit();
		if (contratos.size() == 0) {
			return 1;
		}
		else {
			return contratos.stream().map(contrato -> contrato.getId()).max(Integer::compare).get() + 1;
		}
	}
	
	public static int geraIdProcedimento() {
		DAO.begin();
		List<Procedimento> procedimentos = daoprocedimento.readAll();
		DAO.commit();
		if (procedimentos.size() == 0) {
			return 1;
		}
		else {
			return procedimentos.stream().map(procedimento -> procedimento.getCodigo()).max(Integer::compare).get() + 1;
		}
	}
	
	public static List<Veterinario> listarVeterinarios(){
		DAO.begin();
		List<Veterinario> veterinarios = daoveterinario.readAll();
		DAO.commit();
		return veterinarios;
	}
	
	public static Veterinario listarVeterinario(String crv){
		DAO.begin();
		Veterinario veterinario = daoveterinario.read(crv);
		DAO.commit();
		if (veterinario == null) {
			DAO.rollback();
			throw new RuntimeException("Veterinario n„o existe!");
		}
		return veterinario;
	}
	
	public static List<Tutor> listarTutores(){
		DAO.begin();
		List<Tutor> tutores = daotutor.readAll();
		DAO.commit();
		return tutores;
	}
	
	public static Tutor listarTutor(String cpf){
		DAO.begin();
		Tutor tutor = daotutor.read(cpf);
		DAO.commit();
		if (tutor == null) {
			DAO.rollback();
			throw new RuntimeException("Tutor n„o existe!");
		}
		return tutor;
	}
	
	public static List<Pet> listarPets(){
		DAO.begin();
		List<Pet> pets = daopet.readAll();
		DAO.commit();
		return pets;
	}
	
	public static Pet listarPet(int id){
		DAO.begin();
		Pet pet = daopet.read(id);
		DAO.commit();
		if (pet == null) {
			DAO.rollback();
			throw new RuntimeException("Pet n„o existe!");
		}
		return pet;
	}
	
	public static List<Procedimento> listarProcedimentos(){
		DAO.begin();
		List<Procedimento> procedimentos = daoprocedimento.readAll();
		DAO.commit();
		return procedimentos;
	}
	
	public static Procedimento listarProcedimento(int id){
		DAO.begin();
		Procedimento procedimento = daoprocedimento.read(id);
		DAO.commit();
		if (procedimento == null) {
			DAO.rollback();
			throw new RuntimeException("Procedimento n„o existe!");
		}
		return procedimento;
	}
	
	public static void deletarVeterinario(String crv) {
		DAO.begin();
		Veterinario veterinario = daoveterinario.read(crv);
		if (veterinario == null) {
			DAO.rollback();
			throw new RuntimeException("Veterinario n„o existe!");
		}
		List<Procedimento> procedimentos = daoprocedimento.readAll();
		for(Procedimento procedimento: procedimentos) {
			if (procedimento.getVeterinario() == veterinario) {
				procedimento.setVeterinario(null);
				daoprocedimento.update(procedimento);
			}
		}
		daoveterinario.delete(veterinario);
		DAO.commit();
	}
	
	public static void deletarTutor(String cpf) {
		DAO.begin();
		Tutor tutor = daotutor.read(cpf);
		if (tutor == null) {
			DAO.rollback();
			throw new RuntimeException("Veterinario n„o existe!");
		}
		for(Pet pet: tutor.getPets()) {
			pet.setTutor(null);
			daopet.update(pet);
		}
		daotutor.delete(tutor);
		DAO.commit();
	}
	
	public static void deletarPet(int id) {
		DAO.begin();
		Pet pet = daopet.read(id);
		if (pet == null) {
			DAO.rollback();
			throw new  RuntimeException("Pet n„o existe!");
		}
		pet.setTutor(null);
		pet.setContrato(null);
		daopet.delete(pet);
		DAO.commit();
	}
	
	public static void deletarProcedimento(int id) {
		DAO.begin();
		Procedimento procedimento = daoprocedimento.read(id);
		if (procedimento == null) {
			DAO.rollback();
			throw new RuntimeException("Procedimento n„o existe!");
		}
		procedimento.setPet(null);
		procedimento.setVeterinario(null);
		daoprocedimento.delete(procedimento);
		DAO.commit();
	}
	
	public static void alterarEspecialidadeVeterinario(String crv, String novaEspecialidade) {
		DAO.begin();
		Veterinario veterinario = daoveterinario.read(crv);
		if (veterinario == null) {
			DAO.rollback();
			throw new RuntimeException("Veterinario n„o existe!");
		}
		veterinario.setEspecialidade(novaEspecialidade);
		daoveterinario.update(veterinario);
		DAO.commit();
	}
	
	public static void adicionarPet(String nome, String especie, String raca, String cpf, String sexo,
			String data, String nomeModalidade, boolean cooparticipacao) {
		criarPet(nome, especie, raca, cpf, sexo,
			data, nomeModalidade, cooparticipacao);
	}
	
	public static void alterarContratoDoPet(int id, String novaModalidade, boolean cooparticipacao) {
		DAO.begin();
		Pet pet = daopet.read(id);
		if (pet == null) {
			DAO.rollback();
			throw new  RuntimeException("Pet n„o existe!");
		}
		pet.getContrato().setModalidade(new Modalidade(novaModalidade, cooparticipacao));
		daopet.update(pet);
		DAO.commit();
	}
	
	public static void alterarValorDeProcedimento(int id, double novoValor) {
		DAO.begin();
		Procedimento procedimento = daoprocedimento.read(id);
		if (procedimento == null) {
			DAO.rollback();
			throw new RuntimeException("Procedimento n„o existe!");
		}
		procedimento.setValor(novoValor);
		daoprocedimento.update(procedimento);
		DAO.commit();
	}
	
	public static List<Veterinario> veterinarioTrechoDeNome(String trechoDeNome){
		DAO.begin();
		List<Veterinario> veterinarios = daoveterinario.veterinarioTrechoDeNome(trechoDeNome); 
		DAO.commit();
		return veterinarios;
	}
	
	public static List<Veterinario> listarVeterinarioPorEspecialidade(String especialidade){
		DAO.begin();
		List<Veterinario> veterinarios = daoveterinario.listarVeterinarioPorEspecialidade(especialidade);
		DAO.commit();
		return veterinarios;
	}
	
	public static List<Pet> petsPorRua(String rua){
		DAO.begin();
		List<Pet> pets = daopet.petsPorRua(rua);
		DAO.commit();
		return pets;
	}
	
	public static List<Procedimento> procedimentosPorPetPorDono(String dono){
		DAO.begin();
		List<Procedimento> procedimentos = daoprocedimento.procedimentosPorPetPorDono(dono);
		DAO.commit();
		return procedimentos;
	}
	
	public static List<Contrato> contratosPorModalidadePorEstado(String modalidade, String estado){
		DAO.begin();
		List<Contrato> contratos = daocontrato.contratosPorModalidadePorEstado(modalidade, estado);
		DAO.commit();
		return contratos;
	}
}
