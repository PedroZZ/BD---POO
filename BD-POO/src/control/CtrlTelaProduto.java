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

public class CtrlTelaProduto implements ActionListener {

	private JTextField txtIdProduto, txtNome, txtDescricao, txtValorVenda,
			txtValorCompra, txtIdFornecedor, txtIdLote, txtDataValidadeLote,
			txtQtde;
	private JButton btnPesquisaProduto, btnPesquisaFornecedor, btnSalva;
	private JPanel panAcoes, panAcoes2, panProduto,
			panLote;
	private JLabel lblAcao;

//	private Object[] objetosTela = new Object[25];

	public CtrlTelaProduto(Object[] objetosTela) {

		this.txtIdProduto = (JTextField) objetosTela[0];
		this.txtNome = (JTextField) objetosTela[1];
		this.txtDescricao = (JTextField) objetosTela[2];
		this.txtValorVenda = (JTextField) objetosTela[3];
		this.txtValorCompra = (JTextField) objetosTela[4];
		this.txtIdFornecedor = (JTextField) objetosTela[5];
		this.txtIdLote = (JTextField) objetosTela[6];
		this.txtDataValidadeLote = (JTextField) objetosTela[7];
		this.txtQtde = (JTextField) objetosTela[8];
//
//		this.btnIncluir = (JButton) objetosTela[9];
//		this.btnAlterar = (JButton) objetosTela[10];
//		this.btnExcluir = (JButton) objetosTela[11];
//		this.btnPesquisar = (JButton) objetosTela[12];

		this.btnPesquisaProduto = (JButton) objetosTela[13];
		this.btnPesquisaFornecedor = (JButton) objetosTela[14];
//		this.btnVolta = (JButton) objetosTela[15];
//		this.btnLimpa = (JButton) objetosTela[16];
		this.btnSalva = (JButton) objetosTela[17];
		this.panAcoes = (JPanel) objetosTela[18];

//		this.panInferior = (JPanel) objetosTela[19];
//		this.panSuperior = (JPanel) objetosTela[20];
		this.panAcoes2 = (JPanel) objetosTela[21];
		this.panProduto = (JPanel) objetosTela[22];
		this.panLote = (JPanel) objetosTela[23];

		this.lblAcao = (JLabel) objetosTela[24];

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

	public void comp(Component[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i].setEnabled(!c[i].isEnabled());
		}
	}

	public void tfalse(Component[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i].setEnabled(false);
		}
	}

	public void botoesCrud() {
		Component[] c;
		comp(c = panAcoes.getComponents());
	}

	public void resetaTela() {
		Component[] c;
		comp(c = panProduto.getComponents());
		comp(c = panLote.getComponents());
		comp(c = panAcoes2.getComponents());
		limpaCampos();
		pesquisa(false);
	}

	public void incluiLote() {
		Component[] c;
		comp(c = panProduto.getComponents());
		txtNome.setEnabled(true);
	}

	public void excluiProduto() {
		Component[] c;
		comp(c = panProduto.getComponents());
		comp(c = panLote.getComponents());
		txtNome.setEnabled(true);
		btnPesquisaFornecedor.setEnabled(false);
	}

	public void incluiProduto() {
		Component[] c;
		comp(c = panLote.getComponents());
	}

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

	public void pesquisa(boolean status) {
		btnPesquisaProduto.setEnabled(status);
	}

	public void pesq() {
		Component[] c;
		comp(c = panProduto.getComponents());
		comp(c = panLote.getComponents());
		txtNome.setEnabled(true);
		btnPesquisaFornecedor.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		if (acao.equalsIgnoreCase("LIMPA")) {
			limpaCampos();
		} else if (acao.equalsIgnoreCase("VOLTA")) {
			vouta();
		}

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

		else if (acao.equalsIgnoreCase("INCLUIR")) {
			botoesCrud();
			resetaTela();
			lblAcao.setText("Salvar");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniSalvar.png")));
			btnSalva.setActionCommand("ACAOSALVA");
			pesquisa(false);
		} else if (acao.equalsIgnoreCase("INCLUIRPRODUTO")) {

			botoesCrud();
			resetaTela();

			incluiProduto();

			lblAcao.setText("Salvar");
			btnSalva.setIcon(new ImageIcon(FrmProduto.class
					.getResource("/img/MiniSalvar.png")));
			btnSalva.setActionCommand("ACAOSALVAPRODUTO");

			pesquisa(false);

		} else if (acao.equalsIgnoreCase("INCLUIRLOTE")) {

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
