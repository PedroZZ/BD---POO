package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Animal;
import entity.Cliente;
import entity.Servico;

/**
 * Classe para comunica��o com o banco para 
 * realiza��o das funcionalidades do Servi�o
 * @author Pedro Afonso
 *
 */
public class ServicoDaoImpl implements ServicoDao {

	private Connection c;
	
	/**
	 * Construtor
	 */
	public ServicoDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	/**
	 * M�todo para inser��o de um novo Servi�o ao
	 * banco de dados
	 * @param servico
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void adicionarServico(Servico servico) throws SQLException {
		String query = "insert into servico (id, nome, valor, id_animal, id_cliente_servico) values"
				+ " (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, servico.getCodigo());
		ps.setString(2, servico.getNome());
		ps.setInt(3, servico.getValor());
		ps.setInt(4, servico.getAnimal().getId() );
		ps.setInt(5, servico.getCliente().getId());
		ps.execute();
		ps.close();
		

	}
	
	/**
	 * M�todo para buscar um novo c�digo de servi�o
	 * @return C�digo
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void adicionaServicoAgenda(Servico servico) throws SQLException {
		String query = "insert into servico (id, nome, id_animal, id_cliente_servico) values"
				+ " (?, ?, ?, ?)";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, servico.getCodigo());
		ps.setString(2, servico.getNome());
		System.out.println(servico.getNome());
		ps.setInt(3, servico.getAnimal().getId() );
		ps.setInt(4, servico.getCliente().getId());
		System.out.println(servico.getAnimal().getNome());
		ps.execute();
		ps.close();
	}

	/**
	 * M�todo para buscar do banco de dados Objetos
	 * do tipo Servi�o
	 * @return List<Servico> com as informa��es
	 * @throws SQLException exce��o do banco de dados
	 */ 
	@Override
	public int buscarNovaEntrada() throws SQLException {
		
		String query = "select max(id) from servico";
		
		PreparedStatement ps = c.prepareStatement( query );

		ResultSet rs = ps.executeQuery();
		rs.next();

		return rs.getInt(1) == 0 ? 1 : rs.getInt(1)+1;
	}

	/**
	 * M�todo para adicionar um servi�o a Agenda
	 * @param s Objeto Servico
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public List<Servico> buscarServicosAgendados() throws SQLException {
		List<Servico> lista = new ArrayList<Servico>();
		
		String query = "select s.id as codigo_servico, s.nome as servico, "
				+ "c.nome as nome_cliente, c.id as codigo_cliente, "
				+ "a.id as codigo_animal, a.nome as nome_animal, a.raca as raca_animal "
				+ "from cliente c "
				+ "inner join animal a "
				+ "on c.id = a.id_cliente "
				+ "inner join servico s "
				+ "on a.id = s.id_animal "
				+ "right outer join agenda ag "
				+ "on s.id = ag.id_servico "
				+ "where hora > CONVERT(CHAR(5), GETDATE()-'00:10', 108) "
				+ "and ag.id_servico is not null";	
		
		PreparedStatement ps = c.prepareStatement( query );
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Servico s = new Servico();
			Cliente c = new Cliente();
			Animal a = new Animal();
			a.setId( rs.getInt("codigo_animal") );
			a.setNome( rs.getString("nome_animal") );
			a.setRaca( rs.getString("raca_animal") );
			s.setAnimal(a);
			c.setId( rs.getInt("codigo_cliente") );
			c.setNome( rs.getString("nome_cliente") );
			s.setCliente(c);
			s.setCodigo( rs.getInt("codigo_servico") );
			s.setNome( rs.getString("servico") );			
			lista.add(s);
		}
		return lista;
	}

}
