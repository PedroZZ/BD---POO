package persistence;

import java.sql.SQLException;
import java.util.List;
import entity.Agenda;

/**
 * Interface para os m�todos da AgendaDaoImpl
 * @author Pedro Zuzi
 *
 */
public interface AgendaDao {
	
	/**
	 * M�todo para retorno de informa��es do banco de dados
	 * @return List<Agenda> contendo valores do objeto agenda
	 * @throws SQLException exce��o do banco de dados
	 */
	List<Agenda> buscarAgenda() throws SQLException;
	
	/**
	 * M�todo para atualizar a Agenda
	 * @param a
	 * @throws SQLException
	 */
	void atualizaAgenda( Agenda a) throws SQLException;
	
	/**
	 * M�todo que encerra a Agenda
	 * @throws SQLException exce��o do banco de dados
	 */
	void encerraAgenda() throws SQLException;
}
