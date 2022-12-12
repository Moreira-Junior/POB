
package DAOjpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Veterinario;

public class DAOVeterinario  extends DAO<Veterinario>{

	//nome � usado como campo unico 
	public Veterinario read (Object chave) {
		try {
			String crv = (String) chave;
			TypedQuery<Veterinario> q = manager.createQuery("select v from Veterinario v where v.crv = :n", Veterinario.class);
			q.setParameter("n", crv);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Veterinario> veterinarioTrechoDeNome(String trechoDeNome){
		try {
			TypedQuery<Veterinario> q = manager.createQuery("select v from Veterinario v where v.nome like :n", Veterinario.class);
			q.setParameter("n", trechoDeNome+"%");
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Veterinario> listarVeterinarioPorEspecialidade(String especialidade){
		try {
			TypedQuery<Veterinario> q = manager.createQuery("select v from Veterinario v where v.especialidade = :n", Veterinario.class);
			q.setParameter("n", especialidade);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
	
