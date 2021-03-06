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
import entity.Funcionario;
import entity.Usuario;

/**
 * Classe para comunica��o com o banco para 
 * realiza��o das funcionalidades do Usu�rio
 * @author Pedro Afonso
 *
 */
public class UsuarioDaoImpl implements UsuarioDao {
	
	private Connection c;
	
	/**
	 * Construtor
	 */
	public UsuarioDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	/**
	 * M�todo para inser��o de um novo Usu�rio ao
	 * banco de dados
	 * @param u Objeto Usu�rio
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void inserirUsuario(Usuario u) throws SQLException {
		String query = "INSERT INTO usuario (id,username,passwor) "
				+ "VALUES (?, ?, ?) ";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, u.getF().getId() );			//NAO SEI SE FUNCIONA
		ps.setString(2, u.getNome() );
		ps.setString(3, u.getSenha() );
		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null, "Usu�rio criado com sucesso!",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * M�todo para atualiza��o de um Usu�rio no banco
	 * de dados
	 * @param u Objeto Usu�rio
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void alterarUsuario(Usuario u) throws SQLException {
		String query = "update usuario set "
				+ "username = ?,"
				+ "passwor = ?"
				+ "where username = ?";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, u.getNome());
		ps.setString(2, u.getSenha());
		ps.setString(3, u.getNome());
		System.out.println(u.getNome());
		ps.execute();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Usu�rio alterado com sucesso!",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
	
	}

	/**
	 * M�todo para exclus�o de um Usu�rio no banco
	 * de dados
	 * @param u Objeto Usu�rio
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void excluirUsuario(Usuario u) throws SQLException {
		String query = "delete usuario "
				+"where username = ?";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, u.getNome());
		ps.execute();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Usu�rio excluido com sucesso!",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * M�todo para verfica��o da exist�ncia de um nome de Usu�rio
	 * @param nome
	 * @return true nome existe, false nome n�o existe
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public boolean verificarUsuario(String nome) throws SQLException {
		
		String query = "select "
				+ "case "
				+ "when exists (select * from usuario where username = ?) then "
				+ "cast(1 AS bit) "
				+ "else "
				+ "cast(0 AS bit) "
				+ "end as verificacao";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getBoolean("verificacao");
	}

	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Usu�rio
	 * @param nome
	 * @return List<Usuario> contendo as informa��es
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public List<Usuario> pesquisarUsuario(String nome) throws SQLException {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		String query = "select  f.id, u.username, u.passwor, f.nome, f.cpf, f.salario, f.telefone "
				+ "from usuario u "
				+ "inner join funcionario f "
				+ "on u.id = f.id "
				+ "where f.nome like ? ";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, "%" + nome + "%");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Usuario u = new Usuario();
			Funcionario f = new Funcionario();
			f.setId( rs.getInt("id") );
			f.setCpf( rs.getString("cpf"));
			f.setSalario( rs.getInt("salario"));
			f.setTelefone( rs.getInt("telefone"));
			u.setNome( rs.getString("username") );
			u.setSenha( rs.getString("passwor") );
			f.setNome( rs.getString("nome") );
			u.setF(f);
			lista.add(u);
		}
		return lista;
	}
}
