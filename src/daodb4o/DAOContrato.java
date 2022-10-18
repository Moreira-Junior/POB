
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import model.Contrato;

public class DAOContrato  extends DAO<Contrato>{

	//nome � usado como campo unico 
	public Contrato read (Object chave) {
		String id = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Contrato.class);
		q.descend("id").constrain(id);
		List<Contrato> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}
	
