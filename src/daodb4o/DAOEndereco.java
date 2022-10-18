
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import model.Endereco;

public class DAOEndereco  extends DAO<Endereco>{

	//nome � usado como campo unico 
	public Endereco read (Object chave) {
		String rua = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Endereco.class);
		q.descend("rua").constrain(rua);
		List<Endereco> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}}
	
