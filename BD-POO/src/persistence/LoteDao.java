package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Lote;

/**
 * Interface com os metodos de Lote a serem implementados
 * @author Hury
 *
 */

public interface LoteDao {
	
	/**
	 * M�todo para inser��o de um novo Lote ao
	 * banco de dados
	 * @param lot
	 * @return 
	 * @throws SQLException exce��o do banco de dados
	 */
	int insereLote(Lote lot) throws SQLException;

	/**
	 * M�todo para atualiza��o de um Lote no banco
	 * de dados
	 * @param lot
	 * @throws SQLException exce��o do banco de dados
	 */
	void atualizaLote(Lote lot) throws SQLException;

	/**
	 * M�todo para exclus�o de um Lote no banco
	 * de dados
	 * @param lot
	 * @throws SQLException exce��o do banco de dados
	 */
	void excluiLote(Lote lot) throws SQLException;

	/**
	 * M�todo para consulta de um lote
	 * @param lot
	 * @return
	 * @throws SQLException exce��o do banco de dados
	 */
	Lote consultaLote(Lote lot) throws SQLException;

	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Lote
	 * @param id
	 * @return List<Lote> contendo as informa��es
	 * @throws SQLException exce��o do banco de dados
	 */
	List<Lote> listaLote(int id) throws SQLException;
}
