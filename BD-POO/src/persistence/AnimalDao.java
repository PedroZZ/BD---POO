package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Animal;

/**
 * Interface para os m�todos da AnimalDaoImpl
 * @author Pedro Zuzi
 *
 */
public interface AnimalDao {
	
	/**
	 * M�todo para retorno de informa��es do banco de dados
	 * @param idCliente id do cliente
	 * @return List<Animal> contendo informa��es do objeto Animal
	 * @throws SQLException exce��o do banco de dados
	 */
	List<Animal> listaAnimal(int idCliente) throws SQLException;
	
	/**
	 * M�todo para inser��o no banco de dados um novo
	 * registro de um Objeto Animal
	 * @param a Objeto Animal
	 * @throws SQLException exce��o do banco de dados
	 */
	void inserirAnimal( Animal a ) throws SQLException;
	
	/**
	 * M�todo para atualiza��o das informa��es no banco
	 * de dados de um objeto Animal
	 * @param a Objeto Animal
	 * @throws SQLException exce��o do banco de dados
	 */
	void atualizaAnimal ( Animal a ) throws SQLException;
	
	/**
	 * M�todo para exclus�o de um objeto Animal do banco
	 * de dados
	 * @param a Objeto Animal
	 * @throws SQLException exce��o do banco de dados
	 */
	void excluiAnimal( Animal a ) throws SQLException;
}
