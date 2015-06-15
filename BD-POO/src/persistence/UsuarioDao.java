package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Usuario;

/**
 * Interface com os m�todos para a classe UsuarioDaoImpl
 * @author Pedro Afonso
 *
 */
public interface UsuarioDao {
	
	/**
	 * M�todo para inser��o de um novo Usu�rio ao
	 * banco de dados
	 * @param u Objeto Usu�rio
	 * @throws SQLException exce��o do banco de dados
	 */
	public void inserirUsuario(Usuario u) throws SQLException;
	
	/**
	 * M�todo para atualiza��o de um Usu�rio no banco
	 * de dados
	 * @param u Objeto Usu�rio
	 * @throws SQLException exce��o do banco de dados
	 */
	public void alterarUsuario(Usuario u) throws SQLException;
	
	/**
	 * M�todo para exclus�o de um Usu�rio no banco
	 * de dados
	 * @param u Objeto Usu�rio
	 * @throws SQLException exce��o do banco de dados
	 */
	public void excluirUsuario(Usuario u) throws SQLException;
	
	/**
	 * M�todo para verfica��o da exist�ncia de um nome de Usu�rio
	 * @param nome
	 * @return true nome existe, false nome n�o existe
	 * @throws SQLException exce��o do banco de dados
	 */
	public boolean verificarUsuario(String nome) throws SQLException;
	
	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Usu�rio
	 * @param nome
	 * @return List<Usuario> contendo as informa��es
	 * @throws SQLException exce��o do banco de dados
	 */
	public List<Usuario> pesquisarUsuario(String nome) throws SQLException;

}
