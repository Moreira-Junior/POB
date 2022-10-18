
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import model.Pessoa;

public class DAOPessoa  extends DAO<Pessoa>{

	//nome � usado como campo unico 
	public Pessoa read (Object chave) {
		String nome = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("nome").constrain(nome);
		List<Pessoa> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}}
	
