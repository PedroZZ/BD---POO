package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Servico;

/**
 * Interface para os m�todos do ServicoDaoImpl
 * @author Pedro Afonso
 *
 */
public interface ServicoDao {

	/**
	 * M�todo para inser��o de um novo Servi�o ao
	 * banco de dados
	 * @param servico
	 * @throws SQLException exce��o do banco de dados
	 */
	public void adicionarServico(Servico servico) throws SQLException;
	
	/**
	 * M�todo para buscar um novo c�digo de servi�o
	 * @return C�digo
	 * @throws SQLException exce��o do banco de dados
	 */
	public int buscarNovaEntrada() throws SQLException;
	
	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Servi�o
	 * @return List<Servico> com as informa��es
	 * @throws SQLException exce��o do banco de dados
	 */ 
	public List<Servico> buscarServicosAgendados() throws SQLException;
	
	/**
	 * M�todo para adicionar um servi�o a Agenda
	 * @param s Objeto Servico
	 * @throws SQLException exce��o do banco de dados
	 */
	void adicionaServicoAgenda(Servico s) throws SQLException;
}
