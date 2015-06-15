package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Agenda;

/**
 * Classe para comunica��o com o banco para 
 * realiza��o das funcionalidades da agenda
 * no mesmo
 * @author Pedro Zuzi
 *
 */
public class AgendaDaoImpl implements AgendaDao{
	
	private Connection c;
	
	/**
	 * Construtor
	*/
	public AgendaDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	/**
	 * M�todo para retorno do banco de dados
	 * @return List<Agenda> contendo valores do objeto agenda
	 * @throws SQLException exce��o do banco de dados
	*/
	@Override
	public List<Agenda> buscarAgenda() throws SQLException {
		List<Agenda> lista = new ArrayList<Agenda>();
		
		String sql = "select CONVERT(CHAR(5), a.hora, 108) as hora, a.disponibilidade, s.nome"
				+ " from servico s"
				+ " right outer join agenda a"
				+ " on s.id = a.id_servico"
				+ " where id_servico is null";
		
		PreparedStatement ps = c.prepareStatement( sql );
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			Agenda a = new Agenda();
			a.setHorario( rs.getString("hora"));
			a.setAuxiliar( rs.getInt("disponibilidade") );
			lista.add(a);
		}
		ps.close();
		return lista;
	}

	/**
	 * M�todo para atualizar a Agenda
	 * @param a
	 * @throws SQLException
	 */
	@Override
	public void atualizaAgenda( Agenda a ) throws SQLException {
		String sql = "update agenda set disponibilidade = 1, "
				+ "id_servico = ? "
				+ "where hora = ?";
		PreparedStatement ps = c.prepareStatement( sql );
		ps.setInt(1, a.getServico().getCodigo() );
		ps.setString(2, a.getHorario() );
		ps.execute();
		ps.close();
	}

	/**
	 * M�todo que encerra a Agenda
	 * @throws SQLException exce��o do banco de dados
	 */
	@Override
	public void encerraAgenda() throws SQLException {
		String sql = "update agenda set id_servico = null, disponibilidade=0";
		PreparedStatement ps = c.prepareStatement( sql );
		ps.execute();
		ps.close();
	}


}
