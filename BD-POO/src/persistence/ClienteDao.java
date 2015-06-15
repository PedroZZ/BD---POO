package persistence;

import java.sql.SQLException;
import java.util.List;
import entity.Cliente;

/**
 * Interface para os m�todos do ClienteDaoImpl
 * @author Pedro Zuzi
 *
 */
public interface ClienteDao {
	
	/**
	 * M�todo para inser��o de um novo cliente ao
	 * banco de dados
	 * @param c Objeto Cliente
	 * @throws SQLException exce��o do banco de dados
	 */
	void inserirCliente(Cliente c) throws SQLException;
	
	/**
	 * M�todo para atualiza��o de um cliente no banco
	 * de dados
	 * @param c Objeto Cliente
	 * @throws SQLException exce��o do banco de dados
	 */
	void atualizarCliente(Cliente c) throws SQLException;
	
	/**
	 * M�todo para exclus�o de um cliente no banco
	 * de dados
	 * @param c Objeto Cliente
	 * @throws SQLException exce��o do banco de dados
	 */
	void excluirCliente(Cliente c) throws SQLException;
	
	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Cliente
	 * @param nome
	 * @return List<Cliente> contendo as informa��es
	 * @throws SQLException exce��o do banco de dados
	 */
	List<Cliente> listaCliente(String nome) throws SQLException;

}
