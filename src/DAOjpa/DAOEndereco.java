
package DAOjpa;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Endereco;

public class DAOEndereco  extends DAO<Endereco>{

	//nome � usado como campo unico 
	
	public Endereco read (Object chave) {
		try {
			String rua = (String) chave;
			TypedQuery<Endereco> q = manager.createQuery("select e from Endereco e where c.rua = :e", Endereco.class);
			q.setParameter("n", rua);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
	
