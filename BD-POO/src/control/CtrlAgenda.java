package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistence.AgendaDao;
import persistence.AgendaDaoImpl;
import entity.Agenda;

/**
 * Classe para controle das funcionalidades
 * da tela da agenda.
 * @author Pedro Afonso
 *
 */
public class CtrlAgenda {
	
	private AgendaDao aDao;
	
	/**
	 * M�todo que busca a agenda
	 * @return a agenda em uma lista
	 */
	public List<Agenda> buscarAgenda() {
		aDao = new AgendaDaoImpl();
		List<Agenda> lista = new ArrayList<Agenda>();
		try {
			lista = aDao.buscarAgenda();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * M�todo para atualizar a agenda
	 * @param a agenda que ser� atualizada
	 */
	public void atualizaAgenda( Agenda a ) {
		aDao = new AgendaDaoImpl();
		try {
			aDao.atualizaAgenda(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * M�todo que encerra a agenda para o pr�ximo dia
	 */
	public void encerraAgenda() {
		aDao = new AgendaDaoImpl();
		try {
			aDao.encerraAgenda();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
