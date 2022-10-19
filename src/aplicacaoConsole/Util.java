/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

package aplicacaoConsole;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

import model.Contrato;
import model.Endereco;
import model.Modalidade;
import model.Pessoa;
import model.Pet;
import model.Procedimento;
import model.Tutor;
import model.Veterinario;



public class Util {

	public static ObjectContainer conectarDb4oAgendaLocal(){
		//---------------------------------------
		//configurar e conectar/criar banco local
		//---------------------------------------
		
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // mensagens na tela 0(desliga),1,2,3...
		
		// habilitar cascata na altera��o, remo��o e leitura
		config.common().objectClass(Veterinario.class).cascadeOnDelete(false);
		config.common().objectClass(Veterinario.class).cascadeOnUpdate(true);
		config.common().objectClass(Veterinario.class).cascadeOnActivate(true);
		config.common().objectClass(Contrato.class).cascadeOnDelete(false);
		config.common().objectClass(Contrato.class).cascadeOnUpdate(true);
		config.common().objectClass(Contrato.class).cascadeOnActivate(true);
		config.common().objectClass(Endereco.class).cascadeOnDelete(false);
		config.common().objectClass(Endereco.class).cascadeOnUpdate(true);
		config.common().objectClass(Endereco.class).cascadeOnActivate(true);
		config.common().objectClass(Modalidade.class).cascadeOnDelete(false);
		config.common().objectClass(Modalidade.class).cascadeOnUpdate(true);
		config.common().objectClass(Modalidade.class).cascadeOnActivate(true);
		config.common().objectClass(Pessoa.class).cascadeOnDelete(false);
		config.common().objectClass(Pessoa.class).cascadeOnUpdate(true);
		config.common().objectClass(Pessoa.class).cascadeOnActivate(true);
		config.common().objectClass(Pet.class).cascadeOnDelete(false);
		config.common().objectClass(Pet.class).cascadeOnUpdate(true);
		config.common().objectClass(Pet.class).cascadeOnActivate(true);
		config.common().objectClass(Procedimento.class).cascadeOnDelete(false);
		config.common().objectClass(Procedimento.class).cascadeOnUpdate(true);
		config.common().objectClass(Procedimento.class).cascadeOnActivate(true);
		config.common().objectClass(Tutor.class).cascadeOnDelete(false);
		config.common().objectClass(Tutor.class).cascadeOnUpdate(true);
		config.common().objectClass(Tutor.class).cascadeOnActivate(true);
		
		// criar indices (opcional) sobre campos de busca
		config.common().objectClass(Veterinario.class).objectField("crv").indexed(true);
		
		// nivel de profundidade do grafo para leitura e atualiza��o
		config.common().objectClass(Veterinario.class).updateDepth(5);
		config.common().objectClass(Veterinario.class).minimumActivationDepth(5);
		config.common().objectClass(Contrato.class).updateDepth(5);
		config.common().objectClass(Contrato.class).minimumActivationDepth(5);
		config.common().objectClass(Endereco.class).updateDepth(5);
		config.common().objectClass(Endereco.class).minimumActivationDepth(5);
		config.common().objectClass(Modalidade.class).updateDepth(5);
		config.common().objectClass(Modalidade.class).minimumActivationDepth(5);
		config.common().objectClass(Pessoa.class).updateDepth(5);
		config.common().objectClass(Pessoa.class).minimumActivationDepth(5);
		config.common().objectClass(Pet.class).updateDepth(5);
		config.common().objectClass(Pet.class).minimumActivationDepth(5);
		config.common().objectClass(Procedimento.class).updateDepth(5);
		config.common().objectClass(Procedimento.class).minimumActivationDepth(5);
		config.common().objectClass(Tutor.class).updateDepth(5);
		config.common().objectClass(Tutor.class).minimumActivationDepth(5);
		
		//conexao local
		ObjectContainer manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
	}

	
	
}
