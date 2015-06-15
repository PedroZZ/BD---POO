package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Funcionario;

/**
 * Interface para os m�todos do FornecedorDaoImpl
 * @author Pedro Afonso
 *
 */
public interface FuncionarioDao {
	
	/**
	 * M�todo para inser��o de um novo Funcion�rio ao
	 * banco de dados
	 * @param func Objeto Funcion�rio
	 * @throws SQLException exce��o do banco de dados
	 */
	public void inserirFuncionario(Funcionario func) throws SQLException;
	
	/**
	 * M�todo para atualiza��o de um Funcion�rio no banco
	 * de dados
	 * @param func Objeto Funcion�rio
	 * @throws SQLException exce��o do banco de dados
	 */
	public void atualizarFuncionario(Funcionario func) throws SQLException;
	
	/**
	 * M�todo para exclus�o de um Funcion�rio no banco
	 * de dados
	 * @param func Objeto Funcion�rio
	 * @throws SQLException exce��o do banco de dados
	 */
	public void excluirFuncionario(Funcionario func) throws SQLException;
	
	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Funcion�rio
	 * @param nome a ser pesquisado
	 * @return List<Funcionario> contendo as informa��es
	 * @throws SQLException exce��o do banco de dados
	 */
	public List<Funcionario> pesquisarFuncionario(String nome) throws SQLException;
	
	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Funcion�rio que n�o possuem um usu�rio cadastrado
	 * @param nome a ser pesquisado
	 * @return List<Funcionario> contendo as informa��es
	 * @throws SQLException exce��o do banco de dados
	 */
	public List<Funcionario> pesquisarFuncionarioSemUsuario(String nome) throws SQLException;
}
