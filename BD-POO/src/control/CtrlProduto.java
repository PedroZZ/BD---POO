package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistence.FornecedorDaoImpl;
import persistence.LoteDao;
import persistence.LoteProdutoDao;
import persistence.PessoaDaoImpl;
import persistence.ProdutoDao;
import persistence.ProdutoDaoImpl;
import entity.Fornecedor;
import entity.Lote;
import entity.LoteProduto;
import entity.Pessoa;
import entity.Produto;

/**
 * Classe que interage com o Dao
 * 
 * @author Hury
 *
 */

public class CtrlProduto implements ActionListener, CtrlTableProduto,
		CtrlTableLote {
	private JTextField txtIdProduto, txtNome, txtDescricao, txtValorVenda,
			txtValorCompra, txtIdFornecedor, txtIdLote, txtDataValidadeLote;

	private ProdutoDao pDao;
	private LoteDao lDao;
	private LoteProdutoDao lpDao;

	public CtrlProduto(JTextField txtIdProduto, JTextField txtNome,
			JTextField txtDescricao, JTextField txtValorVenda,
			JTextField txtValorCompra, JTextField txtIdFornecedor,
			JTextField txtIdLote, JTextField txtDataValidadeLote) {
		super();
		this.txtIdProduto = txtIdProduto;
		this.txtNome = txtNome;
		this.txtDescricao = txtDescricao;
		this.txtValorVenda = txtValorVenda;
		this.txtValorCompra = txtValorCompra;
		this.txtIdFornecedor = txtIdFornecedor;
		this.txtIdLote = txtIdLote;
		this.txtDataValidadeLote = txtDataValidadeLote;
	}

	/**
	 * Metodo que atribui a a��o necessaria ao bot�o.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		if (acao.equalsIgnoreCase("ACAOSALVA")) { // insere um novo produto e um
													// novo lote
			Produto prod = new Produto();
			Lote lot = new Lote();
			LoteProduto lotprod = new LoteProduto();

			prod.setNome(txtNome.getText());
			prod.setDescricao(txtDescricao.getText());
			prod.setValor_venda(Integer.parseInt(txtValorVenda.getText()));
			prod.setValor_compra(Integer.parseInt(txtValorCompra.getText()));
			prod.setId_fornecedor(Integer.parseInt(txtIdFornecedor.getText()));
			// data
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

			try {
				lotprod.setIdProduto(insereProduto(prod)); // insere produto
				lotprod.setIdLote(insereLote(lot)); // insere lote
				insereLoteProduto(lotprod); // insere lote_produto

				JOptionPane
						.showMessageDialog(null,
								" Os Novos produto e lote foram incluidos e vinculados com sucesso!");
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out
					.println("prod: " + prod.getId() + " lot: " + lot.getId());

		} else if (acao.equalsIgnoreCase("ACAOSALVAPRODUTO")) { // insere apenas
																// um novo
																// produto

			Produto prod = new Produto();
			prod.setNome(txtNome.getText());
			prod.setDescricao(txtDescricao.getText());
			prod.setValor_venda(Integer.parseInt(txtValorVenda.getText()));
			prod.setValor_compra(Integer.parseInt(txtValorCompra.getText()));
			prod.setId_fornecedor(Integer.parseInt(txtIdFornecedor.getText()));

			try {
				insereProduto(prod);
				JOptionPane.showMessageDialog(null,
						" O Novo produto foi incluido com sucesso!");
			} catch (Exception e2) {
				// TODO: handle exception
			}

		} else if (acao.equalsIgnoreCase("ACAOSALVALOTE")) { // insere um novo
																// lote a um
																// produto
																// existente

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

			try {
				lotprod.setIdProduto(Integer.parseInt(txtIdProduto.getText())); // pega
																				// o
																				// id
																				// do
																				// produto
																				// pesquisado
				lotprod.setIdLote(insereLote(lot)); // insere lote
				insereLoteProduto(lotprod); // insere lote_produto
				JOptionPane.showMessageDialog(null,
						" O Novo lote foi vinculado ao produto com sucesso!");
			} catch (Exception e2) {
				// TODO: handle exception
			}

		} else if (acao.equalsIgnoreCase("ACAOGRAVA")) { // Atualiza produto

			if (txtIdProduto.getText() != "" && txtIdLote.getText()=="") {  //Apenas produto
				Produto prod = new Produto();
				prod.setId(Integer.parseInt(txtIdProduto.getText()));
				prod.setNome(txtNome.getText());
				prod.setDescricao(txtDescricao.getText());
				prod.setValor_venda(Integer.parseInt(txtValorVenda.getText()));
				prod.setValor_compra(Integer.parseInt(txtValorCompra.getText()));
				prod.setId_fornecedor(Integer.parseInt(txtIdFornecedor
						.getText()));

				atualizaProduto(prod);
			}else if(txtIdProduto.getText() != "" && txtIdLote.getText()!=""){ //Produto e Lote
				
				Produto prod = new Produto();
				prod.setId(Integer.parseInt(txtIdProduto.getText()));
				prod.setNome(txtNome.getText());
				prod.setDescricao(txtDescricao.getText());
				prod.setValor_venda(Integer.parseInt(txtValorVenda.getText()));
				prod.setValor_compra(Integer.parseInt(txtValorCompra.getText()));
				prod.setId_fornecedor(Integer.parseInt(txtIdFornecedor
						.getText()));

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
			
			
		} else if (acao.equalsIgnoreCase("ACAOEXCLUI")) { // Exclui Produto
			Produto prod = new Produto();
			prod.setId(Integer.parseInt(txtIdProduto.getText()));

			excluiProduto(prod);
		}

	}

	/**
	 * Insere um produto
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

			// TODO limpa campos

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - Produto", JOptionPane.ERROR_MESSAGE);
		}
		return id;
	}

	/**
	 * Exclui um produto.
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
	 * Inclui um lote.
	 * 
	 * @param lot
	 * @return
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
	 * Inclui um LoteProduto
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

	@Deprecated
	public void insereLoteProduto(LoteProduto lotprod, int codprod, int codlot) {
		lpDao = new ProdutoDaoImpl();
		try {
			lotprod.setIdProduto(codprod);
			lotprod.setIdLote(codlot);
			lpDao.insereLoteProduto(lotprod);
			System.out.println("LoteProduto Incluido!");
			JOptionPane.showMessageDialog(null, "Produto incluido com Sucesso",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO - LoteProduto", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public List<Produto> BuscaProdutoPorNome(String nome) throws SQLException {
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

	@Deprecated
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

	private void atualizaProduto(Produto prod) {
		ProdutoDao pDao = new ProdutoDaoImpl();
		try {
			pDao.atualizaProduto(prod);
			// carregaCombo();
			JOptionPane.showMessageDialog(null,
					"Produto Atualizado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			// limpaCampos();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Busca Lotes a partir da ID de um produto.
	 * 
	 * @return Uma lista de todos os lotes relacionados ao produto.
	 */

	@Override
	public List<Lote> BuscaLotePorProduto(int id) throws SQLException {
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

	@Deprecated
	@Override
	public Lote concultaLoteId(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}