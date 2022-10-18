
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import model.Pet;

public class DAOPet  extends DAO<Pet>{

	//nome � usado como campo unico 
	public Pet read (Object chave) {
		String id = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Pet.class);
		q.descend("id").constrain(id);
		List<Pet> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}}
	
