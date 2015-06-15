package persistence;

import java.sql.SQLException;

/**
 * Interface com o m�todo para a classe StatusDaoImpl
 * @author Hury
 *
 */
public interface StatusDao {

	/**
	 * M�todo para verifica��o da conex�o com o banco
	 * @param status
	 * @return String Online ou OffLine
	 * @throws SQLException exce��o do banco de dados
	 */
	String status(String status) throws SQLException;

}
