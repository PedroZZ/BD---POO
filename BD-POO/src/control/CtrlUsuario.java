package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.UsuarioDao;
import persistence.UsuarioDaoImpl;
import entity.Usuario;

/**
 * Classe para controlar as funcionalidades 
 * da tela do usu�rio
 * @author Pedro Afonso
 *
 */
public class CtrlUsuario {

	private UsuarioDao uDao;
	
	/**
	 * M�todo para cadastrar um usuario
	 * @param us dados do usu�rio
	 */
	public void adicionarUsuario(Usuario us){
		uDao = new UsuarioDaoImpl();
		
		try {
			uDao.inserirUsuario(us);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * M�todo para verificar se o nome de usu�rio ja existe
	 * @param nome a ser verificado
	 * @return se o nome j� existe ou nao
	 */
	public boolean verificarNomeUsuario(String nome){
		uDao = new UsuarioDaoImpl();
		
		try {
			
			if(uDao.verificarUsuario(nome)){
				return true;
			}else{
				return false;
			}
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	/**
	 * M�todo para buscar, pelo nome, um usu�rio cadastrado
	 * @param nome do usu�rio
	 * @return lista de usu�rios
	 */
	public List<Usuario> pesquisarUsuario(String nome){
		uDao = new UsuarioDaoImpl();
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			lista = uDao.pesquisarUsuario(nome);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		return lista;
		
	}
	
	/**
	 * M�todo para alterar dados de um usu�rio cadastrado
	 * @param us dados do usu�rio
	 */
	public void alterarUsuario(Usuario us){
		uDao = new UsuarioDaoImpl();
		
		try {
			uDao.alterarUsuario(us);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * M�todo para excluir um usu�rio cadastrado
	 * @param us dados do usuario
	 */
	public void deletarUsuario(Usuario us){
		uDao = new UsuarioDaoImpl();
		
		try {
			uDao.excluirUsuario(us);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
