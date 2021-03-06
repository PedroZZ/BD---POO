package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistence.LoteDao;
import persistence.LoteProdutoDao;
import persistence.ProdutoDao;
import persistence.ProdutoDaoImpl;
import entity.Lote;
import entity.LoteProduto;
import entity.Produto;

/**
 * Classe reponsavel pelo controle do produto
 * 
 * @author Hury
 *
 */

public class CtrlProduto implements ActionListener, CtrlTableProduto,
		CtrlTableLote {
	private JTextField txtIdProduto, txtNome, txtDescricao, txtValorVenda,
			txtValorCompra, txtIdFornecedor, txtIdLote, txtDataValidadeLote,
			txtQtde;

	private ProdutoDao pDao;
	private LoteDao lDao;
	private LoteProdutoDao lpDao;

	/**
	 * Contrutor
	 * 
	 * @param objetosTela
	 *            possui todos os objetos da tela
	 */

	public CtrlProduto(Object[] objetosTela) {

		this.txtIdProduto = (JTextField) objetosTela[0];
		this.txtNome = (JTextField) objetosTela[1];
		this.txtDescricao = (JTextField) objetosTela[2];
		this.txtValorVenda = (JTextField) objetosTela[3];
		this.txtValorCompra = (JTextField) objetosTela[4];
		this.txtIdFornecedor = (JTextField) objetosTela[5];
		this.txtIdLote = (JTextField) objetosTela[6];
		this.txtDataValidadeLote = (JTextField) objetosTela[7];
		this.txtQtde = (JTextField) objetosTela[8];
	}

	/**
	 * A��o dos bot�es
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		if (acao.equalsIgnoreCase("ACAOSALVA")) {

			Produto prod = new Produto();
			Lote lot = new Lote();
			LoteProduto lotprod = new LoteProduto();

			prod.setNome(txtNome.getText());
			prod.setDescricao(txtDescricao.getText());
			prod.setValor_venda(Integer.parseInt(txtValorVenda.getText()));
			prod.setValor_compra(Integer.parseInt(txtValorCompra.getText()));
			prod.setId_fornecedor(Integer.parseInt(txtIdFornecedor.getText()));
			prod.setQuantidade(Integer.parseInt(txtQtde.getText()));

			try {
				String data = txtDataValidadeLote.getText();
				java.sql.Date date = null;
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				date = new java.sql.Date(
						((java.util.Date) formatter.parse(data)).getTime());
				lot.setData_validade(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			lotprod.setIdProduto(insereProduto(prod));
			lotprod.setIdLote(insereLote(lot));
			insereLoteProduto(lotprod);

			JOptionPane
					.showMessageDialog(null,
							" Os Novos produto e lote foram incluidos e vinculados com sucesso!");
			System.out
					.println("prod: " + prod.getId() + " lot: " + lot.getId());

		} else if (acao.equalsIgnoreCase("ACAOSALVAPRODUTO")) {

			Produto prod = new Produto();
			prod.setNome(txtNome.getText());
			prod.setDescricao(txtDescricao.getText());
			prod.setValor_venda(Integer.parseInt(txtValorVenda.getText()));
			prod.setValor_compra(Integer.parseInt(txtValorCompra.getText()));
			prod.setId_fornecedor(Integer.parseInt(txtIdFornecedor.getText()));
			prod.setQuantidade(Integer.parseInt(txtQtde.getText()));

			insereProduto(prod);
			JOptionPane.showMessageDialog(null,
					" O Novo produto foi incluido com sucesso!");

		} else if (acao.equalsIgnoreCase("ACAOSALVALOTE")) {

			Lote lot = new Lote();
			LoteProduto lotprod = new LoteProduto();

			try {
				String data = txtDataValidadeLote.getText();
				java.sql.Date date = null;
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				date = new java.sql.Date(
						((java.util.Date) formatter.parse(data)).getTime());
				lot.setData_validade(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			lotprod.setIdProduto(Integer.parseInt(txtIdProduto.getText()));

			lotprod.setIdLote(insereLote(lot));
			insereLoteProduto(lotprod);
			JOptionPane.showMessageDialog(null,
					" O Novo lote foi vinculado ao produto com sucesso!");

		} else if (acao.equalsIgnoreCase("ACAOGRAVA")) {

			if (!txtIdProduto.getText().equals("")
					&& txtIdLote.getText().equals("")) {
				Produto prod = new Produto();
				prod.setId(Integer.parseInt(txtIdProduto.getText()));
				prod.setNome(txtNome.getText());
				prod.setDescricao(txtDescricao.getText());
				prod.setValor_venda(Integer.parseInt(txtValorVenda.getText()));
				prod.setValor_compra(Integer.parseInt(txtValorCompra.getText()));
				prod.setId_fornecedor(Integer.parseInt(txtIdFornecedor
						.getText()));
				prod.setQuantidade(Integer.parseInt(txtQtde.getText()));

				atualizaProduto(prod);
			} else if (!txtIdProduto.getText().equals("")
					&& !txtIdLote.getText().equals("")) {

				Produto prod = new Produto();
				prod.setId(Integer.parseInt(txtIdProduto.getText()));
				prod.setNome(txtNome.getText());
				prod.setDescricao(txtDescricao.getText());
				prod.setValor_venda(Integer.parseInt(txtValorVenda.getText()));
				prod.setValor_compra(Integer.parseInt(txtValorCompra.getText()));
				prod.setId_fornecedor(Integer.parseInt(txtIdFornecedor
						.getText()));
				prod.setQuantidade(Integer.parseInt(txtQtde.getText()));

				atualizaProduto(prod);

				Lote lot = new Lote();
				lot.setId(Integer.parseInt(txtIdLote.getText()));
				try {
					String data = txtDataValidadeLote.getText();
					java.sql.Date date = null;
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					date = new java.sql.Date(
							((java.util.Date) formatter.parse(data)).getTime());
					lot.setData_validade(date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				atualizaLote(lot);
			}

		} else if (acao.equalsIgnoreCase("ACAOEXCLUI")) {
			Produto prod = new Produto();
			prod.setId(Integer.parseInt(txtIdProduto.getText()));

			excluiProduto(prod);

		} else if (acao.equalsIgnoreCase("ACAOEXCLUILOTE")) {
			Lote lot = new Lote();
			lot.setId(Integer.parseInt(txtIdLote.getText()));

			excluiLote(lot);

		} else if (acao.equalsIgnoreCase("ACAOPESQUISA")) {

		}

	}

	/**
	 * Insere um produto a partir do Dao
	 * 
	 * @param prod
	 * @return
	 */

	public int insereProduto(Produto prod) {
		pDao = new ProdutoDaoImpl();
		int id = 0;
		try {
			id = pDao.insereProduto(prod);
			System.out.println("Produto Incluido");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - Produto", JOptionPane.ERROR_MESSAGE);
		}
		return id;
	}

	/**
	 * Exclui um produto a partir do Dao
	 * 
	 * @param prod
	 */

	public void excluiProduto(Produto prod) {
		pDao = new ProdutoDaoImpl();
		try {
			pDao.excluiProduto(prod);
			System.out.println("Produto Excluido");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - Produto", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Insere um Lote a partir do Dao
	 */

	public int insereLote(Lote lot) {
		lDao = new ProdutoDaoImpl();
		int id = 0;
		try {
			id = lDao.insereLote(lot);
			System.out.println("Lote incluido!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO - Lote",
					JOptionPane.ERROR_MESSAGE);
		}
		return id;
	}

	/**
	 * Insere um Lote_Produto a partir do Dao
	 * 
	 * @param lotprod
	 */

	public void insereLoteProduto(LoteProduto lotprod) {
		lpDao = new ProdutoDaoImpl();
		try {
			lpDao.insereLoteProduto(lotprod);
			System.out.println("LoteProduto Incluido!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - LoteProduto", JOptionPane.ERROR_MESSAGE);
		}
	}

 
	/**
	 * Retorna uma lista de produtos a partir de um nome
	 */

	@Override
	public List<Produto> buscaProdutoPorNome(String nome) throws SQLException {
		List<Produto> lista = new ArrayList<Produto>();
		pDao = new ProdutoDaoImpl();
		try {
			lista = pDao.listaProduto(nome);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}

		return lista;
	}

	/**
	 * consulta um produto
	 */

	@Override
	public Produto concultaProdutoId(String id) throws SQLException {
		Produto p = new Produto();
		pDao = new ProdutoDaoImpl();
		p = pDao.consultaProduto(id);
		return p;
	}

	/**
	 * Atualiza um produto
	 * 
	 * @param prod
	 */

	public void atualizaProduto(Produto prod) {
		ProdutoDao pDao = new ProdutoDaoImpl();
		try {
			pDao.atualizaProduto(prod);
			JOptionPane.showMessageDialog(null,
					"Produto Atualizado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Busca um lote a partir de um produto.
	 */

	@Override
	public List<Lote> buscaLotePorProduto(int id) throws SQLException {
		List<Lote> lista = new ArrayList<Lote>();
		lDao = new ProdutoDaoImpl();
		try {
			lista = lDao.listaLote(id);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}

		return lista;
	}

	/**
	 * Atualiza um lote.
	 * 
	 * @param lot
	 */

	public void atualizaLote(Lote lot) {
		LoteDao lDao = new ProdutoDaoImpl();

		try {
			lDao.atualizaLote(lot);
			JOptionPane.showMessageDialog(null, "Lote Atualizado com sucesso!",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Exclui um lote.
	 * 
	 * @param lot
	 */

	public void excluiLote(Lote lot) {
		LoteDao lDao = new ProdutoDaoImpl();

		try {
			lDao.excluiLote(lot);
			JOptionPane.showMessageDialog(null, "Lote Excluido com sucesso!",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Consulta um lote a partir de um id
	 */

	@Override
	public Lote concultaLoteId(String id) throws SQLException {
		return null;
	}

}