package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Classe que realiza a conex�o com o banco de dados
 * @author 
 *
 */

public class ConnectionImpl implements GenericConnection {
	
	private Connection con;
	
	/**
	 * Abre conex�o com o banco
	 */
	
	@Override
	public Connection getConnection() {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager
					.getConnection(
							"jdbc:jtds:sqlserver://localhost:1433;"
							+"DatabaseName=ludpet;namedPipe=true",
							"sa", "senha");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		return con;
	}
	
	/**
	 * Fecha a conex�o com o banco
	 */

	@Override
	public void fechaConexao(Connection con) {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
  }
