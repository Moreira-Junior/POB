
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import model.Veterinario;

public class DAOVeterinario  extends DAO<Veterinario>{

	//nome � usado como campo unico 
	public Veterinario read (Object chave) {
		String crv = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Veterinario.class);
		q.descend("crv").constrain(crv);
		List<Veterinario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}}
	
