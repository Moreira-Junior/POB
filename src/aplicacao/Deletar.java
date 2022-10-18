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

import model.Procedimento;
import model.Veterinario;


public class Deletar {
	protected ObjectContainer manager;

	public Deletar(){
		manager = Util.conectarDb4oAgendaLocal();
		apagar();
		manager.close();
		
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplica��o");
	}

	public void apagar(){
		
		//deletar o veterinario de crv 523
		Query q = manager.query();
		q.constrain(Veterinario.class);  				
		q.descend("crv").constrain("523");		 
		List<Veterinario> resultados = q.execute(); 
	
		if(resultados.size()>0) {
			Veterinario v =  resultados.get(0);
			Query q2 = manager.query();
			q2.constrain(Procedimento.class);
			q2.descend("veterinario").descend("crv").constrain("523");
			List<Procedimento> procedimentos = q2.execute();
			for(Procedimento procedimento : procedimentos) {
				procedimento.setVeterinario(null);
				manager.store(procedimento);
			}
			manager.delete(v);
			manager.commit();
		}
		else
			System.out.println("não deletou");
	}

	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

