package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import control.ConfigTelas;
import control.CtrlCliente;
import control.CtrlTabela;
import control.CtrlTableCliente;
import entity.Cliente;

public class FrmCliente extends MouseAdapter {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JPanel panel;
	private JButton btnIncluir;
	private JLabel lblIncluir;
	private JButton btnAlterar;
	private JLabel lblAlterar;
	private JLabel lblExcluir;
	private JLabel lblPesquisar;
	private JButton btnPesquisar;
	private JButton btnExcluir;
	private JLabel lblLogo;
	private JTextField txtNome;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtTelefone;
	private JLabel lblTelefone;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnLupaPesquisar;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private CtrlCliente control;
	private int id;
	private JLabel lblNome;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private DefaultTableModel modelo;
	private List<Cliente> lista;
	private CtrlTableCliente controlTable;
	
	public FrmCliente() {
		janela = new JFrame("Cliente");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		table = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setVisible(false);
		scrollPane.setBounds(10, 113, 649, 186);
		panPrincipal.add(scrollPane);
		
		lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setVisible(false);
		lblLogradouro.setBounds(45, 387, 74, 14);
		panPrincipal.add(lblLogradouro);
		
		lblNome = new JLabel("Nome:");
		lblNome.setVisible(false);
		lblNome.setBounds(45, 339, 46, 14);
		panPrincipal.add(lblNome);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setVisible(false);
		txtLogradouro.setBounds(129, 384, 318, 20);
		panPrincipal.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setVisible(false);
		txtNome.setBounds(129, 336, 318, 20);
		panPrincipal.add(txtNome);
		txtNome.setColumns(10);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(112, 11, 426, 79);
		panPrincipal.add(panel);
		
		btnIncluir = new JButton("");
		btnIncluir.setBounds(49, 11, 69, 41);
		btnIncluir.setVisible(true);
		panel.add(btnIncluir);
		
		lblIncluir = new JLabel("(F2) Incluir");
		btnIncluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Insert.png")));
		lblIncluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIncluir.setVisible(true);
		lblIncluir.setBounds(54, 54, 69, 19);
		panel.add(lblIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		btnAlterar.setVisible(true);
		panel.add(btnAlterar);
		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlterar.setVisible(true);
		lblAlterar.setBounds(162, 54, 44, 19);
		panel.add(lblAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		btnExcluir.setVisible(true);
		panel.add(btnExcluir);
		
		lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblExcluir.setVisible(true);
		lblExcluir.setBounds(252, 53, 38, 19);
		panel.add(lblExcluir);
		
		lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPesquisar.setVisible(true);
		lblPesquisar.setBounds(336, 53, 59, 19);
		panel.add(lblPesquisar);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/View.png")));
		btnPesquisar.setVisible(true);
		btnPesquisar.setBounds(326, 11, 69, 41);
		panel.add(btnPesquisar);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setVisible(false);
		btnGravar.setBounds(495, 531, 96, 31);
		panPrincipal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(285, 531, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(83, 531, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(479, 322, 65, 31);
		btnLupaPesquisar.setVisible(false);
		panPrincipal.add(btnLupaPesquisar);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmFuncionario.class.getResource
				("/img/LogoLudpet.png")));
		lblLogo.setBounds(45, 154, 546, 199);
		panPrincipal.add(lblLogo);
		
		
		janela.setSize(685,622);
		janela.setContentPane( panPrincipal);
		
		txtNumero = new JTextField();
		txtNumero.setVisible(false);
		txtNumero.setBounds(128, 419, 86, 20);
		panPrincipal.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setVisible(false);
		txtBairro.setBounds(290, 419, 269, 20);
		panPrincipal.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setVisible(false);
		txtTelefone.setBounds(129, 473, 133, 20);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setVisible(false);
		lblNumero.setBounds(45, 425, 61, 14);
		panPrincipal.add(lblNumero);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setVisible(false);
		lblBairro.setBounds(234, 422, 46, 14);
		panPrincipal.add(lblBairro);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setVisible(false);
		lblTelefone.setBounds(45, 476, 69, 14);
		panPrincipal.add(lblTelefone);
		ConfigTelas.centralizarFrame(janela);
		
		modelo = montarTabela();
		
		btnLimpar.addActionListener(l -> limpaCampos() );
		
		btnIncluir.addActionListener(l -> {
			btnGravar.setEnabled(true);
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Gravar");
			btnGravar.setActionCommand("Incluir");
			telaInserirFornecedor();
		});
		
		btnAlterar.addActionListener(l -> {
			btnGravar.setEnabled(true);
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Alterar");
			btnGravar.setActionCommand("Alterar");
			telaAlterarExcluirPesquisarFornecedor();
		});
		
		btnGravar.addActionListener(e -> {
			String cmd = e.getActionCommand();
			acaoGravar(cmd);
		});
		
		btnLupaPesquisar.addActionListener(l -> {
			modelo.setNumRows(0); //apagar Jtable para uma nova consulta
			buscarDadosTabelaPorNome(modelo);
			limpaCampos();
		});
		
		
	}
	
	private void acaoGravar(String cmd) {
		Cliente c = new Cliente();
		control = new CtrlCliente();
		
		 if("Incluir".equalsIgnoreCase(cmd)){
				c.setIdTipo(5);
				c.setNome(txtNome.getText());
				c.setLogradouro(txtLogradouro.getText());
				c.setNumero(Integer.parseInt(txtNumero.getText()));
				c.setBairro(txtBairro.getText());
				c.setTelefone(Integer.parseInt(txtTelefone.getText()));
				control.inserir(c);
		 }else if("Alterar".equalsIgnoreCase(cmd)){
				c.setId(id);
				c.setNome(txtNome.getText());
				c.setLogradouro(txtLogradouro.getText());
				c.setNumero(Integer.parseInt(txtNumero.getText()));
				c.setBairro(txtBairro.getText());
				c.setTelefone(Integer.parseInt(txtTelefone.getText()));
				control.atualiza(c);
				modelo.setNumRows(0); //apagar Jtable para uma nova consulta
		 }
		 limpaCampos();
	}

	private void telaInserirFornecedor() {
		btnLupaPesquisar.setVisible(false);
		txtNome.setVisible(true);
		txtLogradouro.setVisible(true);
		txtNumero.setVisible(true);
		txtBairro.setVisible(true);
		txtTelefone.setVisible(true);
		lblNome.setVisible(true);
		lblLogradouro.setVisible(true);
		lblNumero.setVisible(true);
		lblBairro.setVisible(true);
		lblTelefone.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
		lblLogo.setVisible(false);
		scrollPane.setVisible(false);
		table.setVisible(false);
	}
	
	private void telaAlterarExcluirPesquisarFornecedor() {
		lblLogo.setVisible(false);
		btnLupaPesquisar.setVisible(true);
		txtNome.setVisible(true);
		txtLogradouro.setVisible(true);
		txtNumero.setVisible(true);
		txtBairro.setVisible(true);
		txtTelefone.setVisible(true);
		lblNome.setVisible(true);
		lblLogradouro.setVisible(true);
		lblNumero.setVisible(true);
		lblBairro.setVisible(true);
		lblTelefone.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
		scrollPane.setVisible(true);
		table.setVisible(true);
	}

	private void limpaCampos() {
		txtNome.setText("");
		txtLogradouro.setText("");
		txtNumero.setText("");
		txtBairro.setText("");
		txtTelefone.setText("");
	}
	
	public DefaultTableModel montarTabela () {
		String[] colunas = new String[5];
		colunas[0] = "Nome";
		colunas[1] = "Logradouro";
		colunas[2] = "N�mero";
		colunas[3] = "Bairro";
		colunas[4] = "Telefone";

		modelo = new CtrlTabela(new Object[][] {}, colunas);

		table.setModel(modelo);
		table.addMouseListener(this);
		table.getTableHeader().setReorderingAllowed(false); //deixar as colunas para nao serem movidas de seu lugar original
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.setVisible(false);
		scrollPane.setViewportView(table);
		return modelo;
}

public void buscarDadosTabelaPorNome(DefaultTableModel modelo) {
	controlTable = new CtrlCliente(); //instanciado comoa tribulto
	lista = new ArrayList<Cliente>();
	
		if (!txtNome.getText().equals("")) {
			try {
				lista = controlTable.buscaClientePorNome(txtNome.getText());
				if (!lista.isEmpty()) {
					for (Cliente c : lista) {
						Object[] linha = new Object[5];
						linha[0] = c.getNome();
						linha[1] = c.getLogradouro();
						linha[2] = c.getNumero();
						linha[3] = c.getBairro();
						linha[4] = c.getTelefone();
						modelo.addRow(linha);
					} 
				}else{
					JOptionPane.showMessageDialog(null, "Nenhum registro encontrado",
							"Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, "Digite um nome para pesquisar",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object[] valores = new Object[5];
		int linha = table.getSelectedRow();
		int coluna = table.getSelectedColumn();
		
		for (coluna = 0; coluna < table.getColumnCount(); coluna++) {
			valores[coluna] = table.getValueAt(linha, coluna);
		}
		
		id = lista.get(linha).getId();
		System.out.println(id);
		txtNome.setText( String.valueOf(valores[0]));
		txtLogradouro.setText(String.valueOf(valores[1])); 
		txtNumero.setText(String.valueOf(valores[2]));
		txtBairro.setText(String.valueOf(valores[3]));
		txtTelefone.setText(String.valueOf(valores[4]));
	}

	public static void main(String[] args) {
		new FrmCliente();
	}
}