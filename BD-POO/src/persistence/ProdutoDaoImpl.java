package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Fornecedor;
import entity.Lote;
import entity.LoteProduto;
import entity.Produto;

/**
 * Classe que possui implementações de produto, lote e lote_Produto,
 * responsavel pelos codigos SQL.
 * @author Hury
 *
 */

public class ProdutoDaoImpl implements ProdutoDao, LoteDao, LoteProdutoDao {

	private Connection c;

	/**
	 * Construtor da classe.
	 */
	
	public ProdutoDaoImpl() {
		GenericConnection gDao = new ConnectionImpl();
		c = gDao.getConnection();
	}

	// Metodos implementados Produto
	
	/**
	 * Insere um produto na tabela produto a partir da query SQL
	 */
	
	@Override
	public int insereProduto(Produto prod) throws SQLException {

		String sql = "INSERT INTO produto (nome,descricao,id_fornecedor,valor_venda,valor_compra)"
				+ "VALUES(?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, prod.getNome());
		ps.setString(2, prod.getDescricao());
		ps.setInt(3, prod.getId_fornecedor());
		ps.setInt(4, prod.getValor_venda());
		ps.setInt(5, prod.getValor_compra());
		ps.execute();

		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		prod.setId(id);
		ps.close();
		System.out.println("ID produto:" + id + " " + prod.getId());
		return id;

	}

	/**
	 * Atualiza um produto na tabela produto a partir da query SQL
	 */
	
	@Override
	public void atualizaProduto(Produto prod) throws SQLException {

		String sql = "UPDATE produto SET nome = ?, " + "descricao = ?, "
				+ "id_fornecedor = ?, " + "valor_venda = ?, "
				+ "valor_compra = ? " + "WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);

		ps.setString(1, prod.getNome());
		ps.setString(2, prod.getDescricao());
		ps.setInt(3, prod.getId_fornecedor());
		ps.setInt(4, prod.getValor_venda());
		ps.setInt(5, prod.getValor_compra());
		ps.setInt(6, prod.getId());

		ps.execute();
		ps.close();

	}
	
	/**
	 * Exclui um produto na tabela produto a partir da query SQL
	 */

	@Override
	public void excluiProduto(Produto prod) throws SQLException {
		// TODO Auto-generated method stub

		String query = "delete produto "
				+ " where id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, prod.getId());
		ps.execute();
		JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
		ps.close();
			
	}
	
	/**
	 * Consulta um produto na tabela produto a partir da query SQL
	 */

	@Override
	public Produto consultaProduto(String id) throws SQLException {
		// TODO Auto-generated method stub

		Produto p = new Produto();
		String query = "SELECT id, nome, descricao, id_fornecedor, valor_venda, valor_compra "
				+ "FROM produto WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, Integer.parseInt(id));
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			p.setId(rs.getInt("id"));
			p.setDescricao(rs.getString("descricao"));
			p.setId_fornecedor(rs.getInt("id_fornecedor"));
			p.setValor_venda(rs.getInt("valor_venda"));
			p.setValor_compra(rs.getInt("valor_compra"));
		}
		ps.close();
		return p;

	}
	
	/**
	 * Consulta produtos na tabela produto a partir da query SQL e cria uma lista de produtos
	 */

	@Override
	public List<Produto> listaProduto(String nome) throws SQLException {

		List<Produto> lista = new ArrayList<Produto>();
		String query = "SELECT * FROM produto WHERE nome like ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + nome + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Produto p = new Produto();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setDescricao(rs.getString("descricao"));
			p.setId_fornecedor(rs.getInt("id_fornecedor"));
			p.setValor_venda(rs.getInt("valor_venda"));
			p.setValor_compra(rs.getInt("valor_compra"));
			lista.add(p);

			System.out.println(p.getNome());
		}

		ps.close();
		return lista;
	}

	// Metodos implementados Lote
	@Override
	public int insereLote(Lote lot) throws SQLException {
		String sql = "INSERT INTO lote (data_validade)" + "VALUES(?)";
		PreparedStatement ps = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setDate(1, lot.getData_validade());
		ps.execute();

		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		lot.setId(id);
		ps.close();
		System.out.println("ID Lote:" + id + " " + lot.getId());
		return id;

	}

	@Override
	public void atualizaLote(Lote lot) throws SQLException {
		String sql = "UPDATE lote SET data_validade = ?"
				+ "WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);

		ps.setDate(1, lot.getData_validade());
		ps.setInt(2, lot.getId());

		ps.execute();
		ps.close();

	}

	@Override
	public void excluiLote(Lote lot) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Lote consultaLote(Lote lot) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lote> listaLote(int id) throws SQLException {
		List<Lote> lista = new ArrayList<Lote>();

		String query = "select lot.data_validade, lot.id as idlote "
				+ "from lote lot " + "inner join lote_produto lp "
				+ "on lot.id = lp.idLote " + "inner join produto prod "
				+ "on prod.id = lp.idProduto " + "where prod.id = ? "
				+ "order by prod.id ";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Lote l = new Lote();
			l.setData_validade(rs.getDate("data_validade"));
			l.setId(rs.getInt("idlote"));

			lista.add(l);

			System.out.println(l.getId());
		}

		ps.close();
		return lista;
	}

	// Metodos implementados LoteProduto
	@Override
	public void insereLoteProduto(LoteProduto lotProd) throws SQLException {
		String sql = "INSERT INTO lote_produto (idProduto,idLote)"
				+ "VALUES(?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, lotProd.getIdProduto());
		ps.setInt(2, lotProd.getIdLote());
		ps.execute();

		ps.close();

	}

	@Override
	public void atualizaLoteProduto(LoteProduto lotProd) throws SQLException {
		String sql = "UPDATE lote_produto SET idProduto = ?, idLote = ?"
				+ "WHERE id = ? VALUES(?,?)";
		PreparedStatement ps = c.prepareStatement(sql);

		ps.setInt(1, lotProd.getIdProduto());
		ps.setInt(2, lotProd.getIdLote());

		ps.execute();
		ps.close();

	}

	@Override
	public void excluiLoteProduto(LoteProduto lotProd) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public LoteProduto consultaLoteProduto(LoteProduto lotProd)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoteProduto> listaLoteProduto() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
