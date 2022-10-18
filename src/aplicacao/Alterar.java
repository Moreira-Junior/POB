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

import model.Veterinario;

public class Alterar {
	protected ObjectContainer manager;

	public Alterar(){
		manager = Util.conectarDb4oAgendaLocal();
		atualizar();
		manager.close();

		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplica��o");
	}

	public void atualizar(){
		//alterar a especialidade do veterinario de crv 123

		Query q = manager.query();
		q.constrain(Veterinario.class);  				
		q.descend("crv").constrain("523");		 
		List<Veterinario> resultados = q.execute(); 

		if(resultados.size()>0) {
			Veterinario v =  resultados.get(0);
			v.setEspecialidade("POB");
			manager.store(v);
			manager.commit();
			System.out.println("alterou ");
		}
		else
			System.out.println("inexistente");
	}



	//=================================================
	public static void main(String[] args) {
		new Alterar();
	}
}

