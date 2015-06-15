package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Servico;
import persistence.ServicoDao;
import persistence.ServicoDaoImpl;

/**
 * Classe para controle das funcionalidades da 
 * tela de servi�o
 * @author Pedro Afonso
 *
 */
public class CtrlServico {

	ServicoDao sDao;
	
	/**
	 * M�todo que inclui um servi�o realizado
	 * @param servico dados do servi�o realizado
	 */
	public void incluirServico(Servico servico) {
		sDao = new ServicoDaoImpl();
		
		try {
			sDao.adicionarServico(servico);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * M�todo que busca a nova entrada para o servi�o
	 * a ser realizado
	 * @return c�digo do servi�o
	 */
	public int buscarNovaEntrada(){
		sDao = new ServicoDaoImpl();
		int auxiliar = 0;
		try {
			auxiliar = sDao.buscarNovaEntrada();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return auxiliar;
	}
	
	/**
	 * M�todo que busca os servi�os j� agendados
	 * @return lista de servi�os
	 */
	public List<Servico> buscarServicosAgendados(){
		sDao = new ServicoDaoImpl();
		List<Servico> lista = new ArrayList<Servico>();
		
		try {
			lista = sDao.buscarServicosAgendados();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return lista;
	}
	
	/**
	 * M�todo que inclui um servi�o na agenda
	 * @param s dados do servi�o a ser incluido
	 */
	public void incluiServicoAgenda(Servico s) {
		sDao = new ServicoDaoImpl();
		
		try {
			sDao.adicionaServicoAgenda(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
