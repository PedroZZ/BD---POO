package control;

import java.sql.SQLException;

import persistence.LoginDao;
import persistence.LoginDaoImpl;
import entity.Usuario;

/**
 * Classe para controlar o acesso ao sistema
 * @author Pedro Afonso
 *
 */
public class CtrlLogin {
	
	private LoginDao lDao;
	
	/**
	 * M�todo para realizar o logon do usu�rio no sistema
	 * @param u dados do usuario a logar
	 * @return true se for poss�vel fazer o login
	 */
	public boolean realizarLogin(Usuario u) {
		lDao = new LoginDaoImpl();
		try {
			return lDao.realizarLogin(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
