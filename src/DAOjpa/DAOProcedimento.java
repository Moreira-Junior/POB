
package DAOjpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Procedimento;

public class DAOProcedimento  extends DAO<Procedimento>{

	//nome � usado como campo unico 
	public Procedimento read (Object chave) {
		try {
			Integer id = (Integer) chave;
			TypedQuery<Procedimento> q = manager.createQuery("select p from Procedimento p where p.codigo = :n", Procedimento.class);
			q.setParameter("n", id);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Procedimento> procedimentosPorPetPorDono(String dono){
		try {
			String nome = (String) dono;
			TypedQuery<Procedimento> q = manager.createQuery("select p from Procedimento p where p.pet.tutor.nome = :n", Procedimento.class);
			q.setParameter("n", nome);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	} 
	
}
	
