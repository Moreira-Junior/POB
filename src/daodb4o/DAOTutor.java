
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import model.Tutor;

public class DAOTutor extends DAO<Tutor>{

	//nome � usado como campo unico 
	public Tutor read (Object chave) {
		String cpf = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Tutor.class);
		q.descend("cpf").constrain(cpf);
		List<Tutor> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}}
	
