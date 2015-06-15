package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Fornecedor;

/**
 * Ineterface para os m�todos da classe FornecedorDaoImpl
 * @author Pedro Zuzi
 *
 */
public interface FornecedorDao {
	
	/**
	 * M�todo para inser��o de um novo Fornecedor ao
	 * banco de dados
	 * @param f Objeto Fornecedor
	 * @throws SQLException exce��o do banco de dados
	 */
	void inserirFornecedor(Fornecedor f) throws SQLException;
	
	/**
	 * M�todo para atualiza��o de um Fornecedor no banco
	 * de dados
	 * @param f Objeto Fornecedor
	 * @throws SQLException exce��o do banco de dados
	 */
	void atualizarFornecedor(Fornecedor f) throws SQLException;
	
	/**
	 * M�todo para exclus�o de um Fornecedor no banco
	 * de dados
	 * @param f Objeto Fornecedor
	 * @throws SQLException exce��o do banco de dados
	 */
	void excluirFornecedor(Fornecedor f) throws SQLException;
	
	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Fornecedor
	 * @param nome
	 * @return  List<Fornecedor> contendo as informa��es
	 * @throws SQLException exce��o do banco de dados
	 */
	List<Fornecedor> listaFornecedor(String nome) throws SQLException;

}
