package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.AnimalDao;
import persistence.AnimalDaoImpl;
import entity.Animal;

/**
 * Classe para controle das funcionalidades
 * da tela do animal
 * @author Pedro Afonso
 *
 */
public class CtrlAnimal {
	
	private AnimalDao aDao;
	
	/**
	 * M�todo para buscar os animais cadastrados 
	 * pelo seu dono
	 * @param idCliente c�digo do cliente 
	 * @return lista de animais do dono
	 * @throws SQLException exce��o do banco de dados sql
	 */
	public List<Animal> buscaAnimal(int idCliente) throws SQLException {
		List<Animal> lista = new ArrayList<Animal>();
		aDao = new AnimalDaoImpl();
		lista = aDao.listaAnimal(idCliente);
		return lista;
	}
	
	/**
	 * M�todo para cadastrar um animal
	 * @param a animal a ser cadastrado
	 * @throws SQLException exce��o do banco de dados sql
	 */
	public void inserir( Animal a ) throws SQLException {
		aDao = new AnimalDaoImpl();
		aDao.inserirAnimal(a);
	}
	
	/**
	 * M�todo para atualizar os dados de um animal cadastrado.
	 * @param a animal a ser atualizado
	 * @throws SQLException exce��o do banco de dados sql
	 */
	public void atualiza( Animal a ) throws SQLException {
		aDao = new AnimalDaoImpl();
		aDao.atualizaAnimal(a);
	}
	
	/**
	 * M�todo para excluir um animal cadastrado
	 * @param a animal a ser exclu�do
	 * @throws SQLException exce��o do banco de dados sql
	 */
	public void excluir ( Animal a ) throws SQLException {
		aDao = new AnimalDaoImpl();
		aDao.excluiAnimal(a);
	}

}
