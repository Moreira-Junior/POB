
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import model.Procedimento;

public class DAOProcedimento  extends DAO<Procedimento>{

	//nome � usado como campo unico 
	public Procedimento read (Object chave) {
		int codigo = (Integer) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Procedimento.class);
		q.descend("codigo").constrain(codigo);
		List<Procedimento> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public List<Procedimento> procedimentosPorPetPorDono(String dono){
		Query q4 = manager.query();
		q4.constrain(Procedimento.class);
		q4.descend("pet").descend("tutor").descend("nome").constrain(dono);
		List<Procedimento> resultados4 = q4.execute();
		return resultados4;
	} 
}
	
