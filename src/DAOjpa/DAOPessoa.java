
package DAOjpa;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Pessoa;

public class DAOPessoa  extends DAO<Pessoa>{

	//nome � usado como campo unico 
	
	public Pessoa read (Object chave) {
		try {
			String nome = (String) chave;
			TypedQuery<Pessoa> q = manager.createQuery("select p from Pessoa p where p.nome = :n", Pessoa.class);
			q.setParameter("n", nome);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
	
