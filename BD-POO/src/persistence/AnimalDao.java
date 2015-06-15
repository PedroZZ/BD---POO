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
	
	List<Animal> listaAnimal(int idCliente) throws SQLException;
	void inserirAnimal( Animal a ) throws SQLException;
	void atualizaAnimal ( Animal a ) throws SQLException;
	void excluiAnimal( Animal a ) throws SQLException;
}
