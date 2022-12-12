
package DAOjpa;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Tutor;

public class DAOTutor extends DAO<Tutor>{

	//nome � usado como campo unico 
	public Tutor read (Object chave) {
		try {
			String cpf = (String) chave;
			TypedQuery<Tutor> q = manager.createQuery("select t from Tutor t where t.cpf = :n", Tutor.class);
			q.setParameter("n", cpf);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
	
