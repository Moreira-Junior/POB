
package DAOjpa;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Modalidade;

public class DAOModalidade  extends DAO<Modalidade>{

	//nome � usado como campo unico 
	
	public Modalidade read (Object chave) {
		try {
			String nome = (String) chave;
			TypedQuery<Modalidade> q = manager.createQuery("select m from Modalidade m where m.nome = :n", Modalidade.class);
			q.setParameter("n", nome);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
	
