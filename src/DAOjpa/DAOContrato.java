
package DAOjpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Contrato;

public class DAOContrato  extends DAO<Contrato>{

	//nome � usado como campo unico 
	public Contrato read(Object chave) {
		try {
			String id = (String) chave;
			TypedQuery<Contrato> q = manager.createQuery("select c from Contrato c where c.id = :n", Contrato.class);
			q.setParameter("n", id);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Contrato> contratosPorModalidadePorEstado(String modalidade, String estado){
		try {
//			TypedQuery<Contrato> q = manager.createQuery("select c from Pet p join Contrato c where c.modalidade.nome = :n and p.tutor.endereco.estado = :m", Contrato.class);
			TypedQuery<Contrato> q = manager.createQuery("select c from Contrato c where c.pet.contrato.modalidade.nome = :n and c.pet.tutor.endereco.estado = :m", Contrato.class);
			q.setParameter("n", modalidade);
			q.setParameter("m", estado);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
	
