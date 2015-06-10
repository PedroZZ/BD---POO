package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import boundary.FrmProduto;

/**
 * Classe que realiza as intera��es de tela da classe FrmProduto
 * 
 * @author Hury
 *
 */

// TODO Diminuir Parametros
public class CtrlTelaProduto implements ActionListener {

	private JTextField txtIdProduto, txtNome, txtDescricao, txtValorVenda,
			txtValorCompra, txtIdFornecedor, txtIdLote, txtDataValidadeLote,
			txtQtde;
	private JButton btnIncluir, btnAlterar, btnExcluir, btnPesquisar,
			btnPesquisaProduto, btnPesquisaFornecedor, btnVolta, btnLimpa,
			btnSalva;
	private JPanel panAcoes, panInferior, panSuperior, panAcoes2, panProduto,
			panLote;
	private JLabel lblAcao;

	public CtrlTelaProduto(JTextField txtIdProduto, JTextField txtNome,
			JTextField txtDescricao, JTextField txtValorVenda,
			JTextField txtValorCompra, JTextField txtIdFornecedor,
			JTextField txtIdLote, JTextField txtDataValidadeLote,
			JTextField txtQtde,

			JButton btnIncluir, JButton btnAlterar, JButton btnExcluir,
			JButton btnPesquisar, JButton btnPesquisaProduto,
			JButton btnPesquisaFornecedor, JButton btnVolta, JButton btnLimpa,
			JButton btnSalva,

			JPanel panAcoes, JPanel panInferior, JPanel panSuperior,
			JPanel panAcoes2, JPanel panProduto, JPanel panLote,

			JLabel lblAcao) {

		this.txtIdProduto = txtIdProduto;
		this.txtNome = txtNome;
		this.txtDescricao = txtDescricao;
		this.txtValorVenda = txtValorVenda;
		this.txtValorCompra = txtValorCompra;
		this.txtIdFornecedor = txtIdFornecedor;
		this.txtIdLote = txtIdLote;
		this.txtDataValidadeLote = txtDataValidadeLote;
		this.txtQtde = txtQtde;

		this.btnIncluir = btnIncluir;
		this.btnAlterar = btnAlterar;
		this.btnExcluir = btnExcluir;
		this.btnPesquisar = btnPesquisar;

		this.btnPesquisaProduto = btnPesquisaProduto;
		this.btnPesquisaFornecedor = btnPesquisaFornecedor;
		this.btnVolta = btnVolta;
		this.btnLimpa = btnLimpa;
		this.btnSalva = btnSalva;
		this.panAcoes = panAcoes;
		this.panInferior = panInferior;
		this.panSuperior = panSuperior;
		this.panAcoes2 = panAcoes2;
		this.panProduto = panProduto;
		this.panLote = panLote;
		this.lblAcao = lblAcao;
	}

	public boolean camposProduto() {

		return !(txtNome.getText().equals("")
				|| txtDescricao.getText().equals("")
				|| txtValorVenda.getText().equals("")
				|| txtValorCompra.getText().equals("")
				|| txtIdFornecedor.getText().equals("") || txtQtde.getText()
				.equals(""));

	}

	public boolean camposLote() {
		return !(txtDataValidadeLote.getText().equals(""));
	}

	public boolean camposPesquisa() {
		return !(txtNome.getText().equals(""));

	}

	/**
	 * Limpa todos os textFilds do FrmProduto.
	 */

	public void limpaCampos() {

		txtIdProduto.setText("");
		txtNome.setText("");
		txtDescricao.setText("");
		txtValorVenda.setText("");
		txtValorCompra.setText("");
		txtIdFornecedor.setText("");
		txtIdLote.setText("");
		txtDataValidadeLote.setText("");
	 txtQtde.setText("");
	}

	/**
	 * Recebe um componente, desabilita/habilita todos os subcomponentes do
	 * mesmo.
	 * 
	 * @param c
	 *            O componente para intera��o.
	 */

	public void comp(Component[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i].setEnabled(!c[i].isEnabled());
		}
	}

	/**
	 * Recebe um componente, desabilita todos os subcomponentes do mesmo.
	 * 
	 * @param c
	 *            O componente para intera��o.
	 */

	public void tfalse(Component[] c) { // desabilita os components
		for (int i = 0; i < c.length; i++) {
			c[i].setEnabled(false);
		}
	}

	/**
	 * Desabilita/Habilita os Botoes de CRUD.
	 */

	public void botoesCrud() {
		Component[] c;
		comp(c = panAcoes.getComponents());
	}

	/**
	 * Desabilita/Habilita todos os componentes da tela.
	 */

	public void resetaTela() {
		// System.out.println("resetado");
		Component[] c;
		comp(c = panProduto.getComponents());
		comp(c = panLote.getComponents());
		comp(c = panAcoes2.getComponents());
		limpaCampos();
		pesquisa(false);
	}

	/**
	 * Configura os campos para a inclus�o de um lote.
	 */

	public void incluiLote() {
		Component[] c;
		comp(c = panProduto.getComponents());
		txtNome.setEnabled(true);
	}

	/**
	 * 
	 */

	public void excluiProduto() {
		Component[] c;
		comp(c = panProduto.getComponents());
		comp(c = panLote.getComponents());
		txtNome.setEnabled(true);
		btnPesquisaFornecedor.setEnabled(false);
	}

	/**
	 * Configura os campos para a inclus�o de um Produto.
	 */

	public void incluiProduto() {
		Component[] c;
		comp(c = panLote.getComponents());
	}

	/**
	 * 
	 */

	public void vouta() {
		Component[] c;
		botoesCrud();
		resetaTela();

		limpaCampos();
		pesquisa(false);
		tfalse(c = panLote.getComponents());
		tfalse(c = panProduto.getComponents());
		btnSalva.setEnabled(false);

	}

	/**
	 * Habilita/Desabilita os botoes de pesquisa
	 * 
	 * @param status
	 *            True ou False
	 */

	public void pesquisa(boolean status) {
		btnPesquisaProduto.setEnabled(status);
		// btnPesquisaFornecedor.setEnabled(status);
	}

	/**
	 * 
	 */
	public void pesq() {
		Component[] c;
		comp(c = panProduto.getComponents());
		comp(c = panLote.getComponents());
		txtNome.setEnabled(true);
		btnPesquisaFornecedor.setEnabled(false);
	}

	// TODO
	public void resetaTable() {

	}

	/**
	 * Verifica a a��o do bot�o e atribui as atividades, de tela, a serem
	 * realizadas.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		// acoes basicas de tela
		if (acao.equalsIgnoreCase("LIMPA")) {
			limpaCampos();
		} else if (acao.equalsIgnoreCase("VOLTA")) {
			vouta();
		}

		// botao de acoes
		else if (acao.equalsIgnoreCase("ACAOSALVA")) {
			vouta();
		} else if (acao.equalsIgnoreCase("ACAOSALVAPRODUTO")) {
			vouta();
		} else if (acao.equalsIgnoreCase("ACAOSALVALOTE")) {
			vouta();
		} else if (acao.equalsIgnoreCase("ACAOGRAVA")) {
			vouta();
		} else if (acao.equalsIgnoreCase("ACAOEXCLUI")) {
			vouta();
		} else if (acao.equalsIgnoreCase("ACAOEXCLUILOTE")) {
			vouta();
		} else if (acao.equalsIgnoreCase("ACAOPESQUISA")) {
			vouta();
		}

		// panAcaoes
		else if (acao.equalsIgnoreCase("INCLUIR")) { // lote e produto
			botoesCrud();
			resetaTela();
			lblAcao.setText("Salvar");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniSalvar.png")));
			btnSalva.setActionCommand("ACAOSALVA");
			pesquisa(false);
		} else if (acao.equalsIgnoreCase("INCLUIRPRODUTO")) { // inclui apenas
																// produto

			botoesCrud();
			resetaTela();

			incluiProduto();

			lblAcao.setText("Salvar");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniSalvar.png")));
			btnSalva.setActionCommand("ACAOSALVAPRODUTO");

			pesquisa(false);

		} else if (acao.equalsIgnoreCase("INCLUIRLOTE")) { // inclui lote

			botoesCrud();
			resetaTela();

			incluiLote();

			lblAcao.setText("Salvar novo lote a produto");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniSalvar.png")));
			btnSalva.setActionCommand("ACAOSALVALOTE");

			pesquisa(true);

		} else if (acao.equalsIgnoreCase("ALTERAR")) {

			botoesCrud();
			resetaTela();

			lblAcao.setText("Gravar");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniSalvar.png")));
			btnSalva.setActionCommand("ACAOGRAVA");

			pesquisa(true);

		} else if (acao.equalsIgnoreCase("EXCLUIR")) {

			botoesCrud();
			resetaTela();

			lblAcao.setText("Excluir");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/trash.png")));
			btnSalva.setActionCommand("ACAOEXCLUI");

			excluiProduto();

		} else if (acao.equalsIgnoreCase("EXCLUIRLOTE")) {

			botoesCrud();
			resetaTela();

			lblAcao.setText("Excluir Lote");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/trash.png")));
			btnSalva.setActionCommand("ACAOEXCLUILOTE");

			excluiProduto();

		} else if (acao.equalsIgnoreCase("PESQUISAR")) {
			botoesCrud();
			resetaTela();

			lblAcao.setText("Pesquisar");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniLupa.png")));
			btnSalva.setActionCommand("ACAOPESQUISA");

			pesq();
			pesquisa(true);

			btnSalva.setEnabled(false);
		}
	}

}
