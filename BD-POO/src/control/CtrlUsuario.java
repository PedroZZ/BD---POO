package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.UsuarioDao;
import persistence.UsuarioDaoImpl;
import entity.Usuario;

public class CtrlUsuario {

	private UsuarioDao uDao;
	
	public void adicionarUsuario(Usuario us){
		uDao = new UsuarioDaoImpl();
		
		try {
			uDao.inserirUsuario(us);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
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
	
	public void alterarUsuario(Usuario us){
		uDao = new UsuarioDaoImpl();
		
		try {
			uDao.alterarUsuario(us);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
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
