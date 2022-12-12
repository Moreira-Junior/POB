
package DAOjpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Pet;

public class DAOPet  extends DAO<Pet>{

	//nome � usado como campo unico 
	
	public Pet read (Object chave) {
		try {
			Integer id = (Integer) chave;
			TypedQuery<Pet> q = manager.createQuery("select p from Pet p where p.id = :n", Pet.class);
			q.setParameter("n", id);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Pet> petsPorRua(String rua){
		try {
			String r = (String) rua;
			TypedQuery<Pet> q = manager.createQuery("select p from Pet p where p.tutor.endereco.rua = :n", Pet.class);
			q.setParameter("n", r);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
	
