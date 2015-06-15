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
import entity.Fornecedor;

/**
 * Classe para comunica��o com o banco para 
 * realiza��o das funcionalidades do objeto Fornecedor
 * @author Pedro Zuzi
 *
 */
public class FornecedorDaoImpl implements FornecedorDao{
	
	/**
	 * Construtor
	 */
	public FornecedorDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	private Connection c;

	/**
	 * M�todo para inser��o de um novo Fornecedor ao
	 * banco de dados
	 * @param f Objeto Fornecedor
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void inserirFornecedor(Fornecedor f) throws SQLException {
		String query = "insert into fornecedor values (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, f.getId() );
		ps.setString(2, f.getNome() );
		ps.setInt(3, f.getTelefone() );
		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null, "Fornecedor inserido com sucesso!",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * M�todo para atualiza��o de um Fornecedor no banco
	 * de dados
	 * @param f Objeto Fornecedor
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void atualizarFornecedor(Fornecedor f) throws SQLException {
		String query = "update fornecedor set "
				+ "nome = ?,"
				+ "telefone = ?"
				+ "where id = ?";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, f.getNome() );
		ps.setInt(2, f.getTelefone() );
		ps.setInt(3, f.getId() );
		ps.execute();
		JOptionPane.showMessageDialog(null, "Dados atualizados");
		ps.close();
		
	}

	/**
	 * M�todo para exclus�o de um Fornecedor no banco
	 * de dados
	 * @param f Objeto Fornecedor
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void excluirFornecedor(Fornecedor f) throws SQLException {
		String query = "delete fornecedor "
				+ " where id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, f.getId());
		ps.execute();
		JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso!");
		ps.close();
		
	}

	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Fornecedor
	 * @param nome
	 * @return  List<Fornecedor> contendo as informa��es
	 * @throws SQLException
	 */
	@Override
	public List<Fornecedor> listaFornecedor(String nome) throws SQLException {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		String query = "SELECT * FROM fornecedor WHERE nome like ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString( 1, "%" + nome + "%" );
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			Fornecedor f = new Fornecedor();
			f.setId( rs.getInt( "id") );
			f.setNome( rs.getString( "nome" ) );
			f.setTelefone( rs.getInt( "telefone" ) );
			lista.add( f );
		}
		ps.close();
		return lista;
	}
}
