package persistence;

import java.sql.SQLException;

import entity.Usuario;

/**
 * Interface para o m�todo da classe LoginDaoImpl
 * @author Pedro Zuzi
 *
 */
public interface LoginDao {
	
	/**
	 * M�todo para verficar as credenciais do usu�rio
	 * @param u Objeto Usu�rio
	 * @return true se usu�rio existe, false se n�o existe
	 * @throws SQLException exce��o do banco de dados
	 */
	boolean realizarLogin(Usuario u) throws SQLException;

}
