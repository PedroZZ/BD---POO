package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Animal;

/**
 * Classe para comunica��o com o banco para 
 * realiza��o das funcionalidades do Objeto Animal
 * @author Pedro Zuzi
 *
 */
public class AnimalDaoImpl implements AnimalDao{
	
	private Connection c;
	
	public AnimalDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	/**
	 * M�todo para retorno de informa��es do banco de dados
	 * @param idCliente id do cliente
	 * @return List<Animal> contendo informa��es do objeto Animal
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public List<Animal> listaAnimal(int idCliente) throws SQLException {
		
		List<Animal> lista = new ArrayList<Animal>();
		String query = "select an.id, an.nome, an.rga, an.raca, an.especie, an.sexo, an.cor "
						+ "from cliente cli "
						+ "inner join animal an "
						+ "on cli.id = an.id_cliente "
						+ "where cli.id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, idCliente);
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {
			Animal a = new Animal();
			a.setNome( rs.getString("nome") );
			a.setRga( rs.getString("rga") );
			a.setRaca( rs.getString("raca") );
			a.setEspecie(rs.getString("especie") );
			a.setSexo( rs.getString("sexo") );
			a.setCor( rs.getString("cor") );
			a.setId( rs.getInt("id"));
			lista.add(a);
		}
		ps.close();
		return lista;
	}

	/**
	 * M�todo para inser��o no banco de dados um novo
	 * registro de um Objeto Animal
	 * @param a Objeto Animal
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void inserirAnimal(Animal a) throws SQLException {
		String query = "insert into animal (id_cliente, rga, nome, raca, especie, sexo, cor) "
				+ "values (?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, a.getId() );
		ps.setString(2, a.getRga() );
		ps.setString(3, a.getNome() );
		ps.setString(4, a.getRaca() );
		ps.setString(5, a.getEspecie() );
		ps.setString(6, a.getSexo() );
		ps.setString(7, a.getCor() );
		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null, "Animal inserido com sucesso!",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * M�todo para atualiza��o das informa��es no banco
	 * de dados de um objeto Animal
	 * @param a Objeto Animal
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void atualizaAnimal( Animal a ) throws SQLException {
		String query = "update animal set "
				+ "rga = ?,"
				+ "nome = ?,"
				+ "raca = ?,"
				+ "especie = ?,"
				+ "sexo = ?,"
				+ "cor = ?"
				+ "where id = ?";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, a.getRga() );
		ps.setString(2, a.getNome() );
		ps.setString(3, a.getRaca() );
		ps.setString(4, a.getEspecie() );
		ps.setString(5, a.getSexo() );
		ps.setString(6, a.getCor() );
		ps.setInt(7, a.getId() );
		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null, "Dados atualizados");
	}

	/**
	 * M�todo para exclus�o de um objeto Animal do banco
	 * de dados
	 * @param a Objeto Animal
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void excluiAnimal(Animal a) throws SQLException {
		String query = "delete animal where id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, a.getId());
		ps.execute();
		JOptionPane.showMessageDialog(null, "Animal excluido com sucesso!");
		ps.close();
		
	}

}
