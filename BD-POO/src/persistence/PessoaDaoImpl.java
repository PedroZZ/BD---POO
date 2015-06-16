package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Pessoa;

/**
 * Classe para comunica��o com o banco para
 * realiza��o das funcionalidades do Objeto Pessoa
 * @author Pedro Zuzi
 * @author Pedro Afonso
 *
 */
public class PessoaDaoImpl implements PessoaDao {
	
private Connection c;
		
	/**
	 * Construtor
	 */
	public PessoaDaoImpl() {
		GenericConnection gDao = new ConnectionImpl();
		c = gDao.getConnection();
	}

	/**
	 * M�todo para inser��o de um nova Pessoa ao
	 * banco de dados
	 * @param pes Objeto Pessoa
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void inserePessoa(Pessoa pes) throws SQLException { 
		String sql = "insert into pessoa (idTipo) values (?)";
		PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, pes.getIdTipo() );
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		pes.setId(rs.getInt(1));
		
		ps.close();

	}
		
	/**
	 * M�todo para atualiza��o de uma Pessoa no banco
	 * de dados
	 * @param pes Objeto Pessoa
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void atualizaPessoa(Pessoa pes) throws SQLException {
		String query = "update pessoa set "
				+ "idTipo = ?"
				+ "where idPessoa = ?";
				
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, pes.getIdTipo() );
		ps.setInt(2, pes.getId() );
		ps.execute();
		ps.close();
		
	}

	/**
	 * M�todo para exclus�o de uma Pessoa no banco
	 * de dados
	 * @param pes Objeto Pessoa
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void excluiPessoa(Pessoa pes) throws SQLException {
		String sql = "delete pessoa "
				+ "where idPessoa = ?";
		
		PreparedStatement ps = c.prepareStatement( sql );
		ps.setInt(1, pes.getId() );
		ps.execute();
		ps.close();
		
	}

}
