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
import entity.Cliente;

/**
 * Classe para comunica��o com o banco para 
 * realiza��o das funcionalidades do Objeto Cliente
 * @author Pedro Zuzi
 *
 */
public class ClienteDaoImpl implements ClienteDao{
	
	private Connection con;
	
	/**
	 * Construtor
	 */
	public ClienteDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		con = gc.getConnection();
	}
	
	/**
	 * M�todo para inser��o de um novo cliente ao
	 * banco de dados
	 * @param c Objeto Cliente
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void inserirCliente(Cliente c) throws SQLException {
		String query = "insert into cliente values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt( 1, c.getId() );
		ps.setString( 2, c.getNome() );
		ps.setString(3, c.getCpf() );
		ps.setString( 4 , c.getLogradouro() );
		ps.setInt( 5 , c.getNumero() );
		ps.setString( 6 , c.getBairro() );
		ps.setInt( 7 , c.getTelefone() );
		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * M�todo para atualiza��o de um cliente no banco
	 * de dados
	 * @param c Objeto Cliente
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void atualizarCliente(Cliente c) throws SQLException {
		String sql = "update cliente set "
				+ "nome = ?,"
				+ "cpf = ?,"
				+ "logradouro = ?,"
				+ "numero = ?,"
				+ "bairro = ?,"
				+ "telefone = ? "
				+ "where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString( 1, c.getNome() );
		ps.setString( 2, c.getCpf() );
		ps.setString( 3, c.getLogradouro() );
		ps.setInt( 4, c.getNumero() );
		ps.setString( 5, c.getBairro() );
		ps.setInt( 6, c.getTelefone() );
		ps.setInt( 7, c.getId() );
		ps.execute();
		JOptionPane.showMessageDialog(null, "Dados atualizados");
		ps.close();
	}

	/**
	 * M�todo para exclus�o de um cliente no banco
	 * de dados
	 * @param c Objeto Cliente
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void excluirCliente(Cliente c) throws SQLException {
		
		String sql = "delete cliente where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt( 1, c.getId() );
		ps.execute();
		JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
		ps.close();
		
	}

	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Cliente
	 * @param nome
	 * @return List<Cliente> contendo as informa��es
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public List<Cliente> listaCliente(String nome) throws SQLException {
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		String sql = "SELECT * FROM cliente WHERE nome like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString( 1 , "%" + nome + "%");
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {
			Cliente c = new Cliente();
			c.setId( rs.getInt("id") );
			c.setNome( rs.getString("nome") );
			c.setCpf( rs.getString("cpf") );
			c.setLogradouro( rs.getString("logradouro") );
			c.setNumero( rs.getInt("numero") );
			c.setBairro( rs.getString("bairro") );
			c.setTelefone( rs.getInt("telefone") );
			lista.add( c );
		}
		ps.close();
		return lista;
	}


}
