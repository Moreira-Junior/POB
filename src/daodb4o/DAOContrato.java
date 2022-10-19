
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import model.Contrato;

public class DAOContrato  extends DAO<Contrato>{

	//nome � usado como campo unico 
	public Contrato read (Object chave) {
		String id = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Contrato.class);
		q.descend("id").constrain(id);
		List<Contrato> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public List<Contrato> contratosPorModalidadePorEstado(String modalidade, String estado){
		Query q5 = manager.query();
		q5.constrain(Contrato.class);
		q5.descend("pet").descend("tutor").descend("endereco").descend("estado").constrain(estado);
		q5.descend("modalidade").descend("nome").constrain(modalidade);
		List<Contrato> resultados5 = q5.execute();
		return resultados5;
	}
}
	
