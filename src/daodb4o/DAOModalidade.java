
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import model.Modalidade;

public class DAOModalidade  extends DAO<Modalidade>{

	//nome � usado como campo unico 
	public Modalidade read (Object chave) {
		String nome = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Modalidade.class);
		q.descend("nome").constrain(nome);
		List<Modalidade> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}
	
