package connection;

import java.sql.Connection;

/**
 * Interface que possui os m�todos de conex�o.
 * @author 
 *
 */
public interface GenericConnection {

	public Connection getConnection();
	public void fechaConexao(Connection con);
	
}