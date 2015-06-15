package persistence;

import java.sql.SQLException;
import entity.Pessoa;

/**
 * Interface com os m�todos para a classe PessoaDaoImpl
 * @author Pedro Zuzi
 * @author Pedro Afonso
 *
 */
public interface PessoaDao {
	
	/**
	 * M�todo para inser��o de um nova Pessoa ao
	 * banco de dados
	 * @param pes Objeto Pessoa
	 * @throws SQLException exce��o do banco de dados
	 */
	void inserePessoa(Pessoa pes) throws SQLException;
	
	/**
	 * M�todo para atualiza��o de uma Pessoa no banco
	 * de dados
	 * @param pes Objeto Pessoa
	 * @throws SQLException exce��o do banco de dados
	 */
	void atualizaPessoa(Pessoa pes) throws SQLException;
	
	/**
	 * M�todo para exclus�o de uma Pessoa no banco
	 * de dados
	 * @param pes Objeto Pessoa
	 * @throws SQLException exce��o do banco de dados
	 */
	void excluiPessoa(Pessoa pes) throws SQLException;
}
