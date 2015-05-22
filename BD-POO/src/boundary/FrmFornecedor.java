package boundary;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ConfigTelas;
import control.CtrlFornecedor;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Fornecedor;

import java.awt.SystemColor;

public class FrmFornecedor implements ConfigTelas{
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JLabel lblIncluir;
	private JPanel panel;
	private JLabel lblAlterar;
	private JLabel lblExcluir;
	private JLabel lblPesquisar;
	private JLabel lblTelefone;
	private JLabel lblId;
	private JLabel lblNome;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnPesquisar;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JLabel lblLogo;
	private CtrlFornecedor control;
	
	public FrmFornecedor() {
		janela = new JFrame("Fornecedor");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(62, 11, 426, 79);
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
		
		txtId = new JTextField();
		txtId.setBounds(137, 319, 109, 20);
		txtId.setVisible(false);
		panPrincipal.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(137, 360, 383, 20);
		txtNome.setVisible(false);
		panPrincipal.add(txtNome);
		txtNome.setColumns(10);
		
		lblId = new JLabel("C\u00F3digo:");
		lblId.setBounds(62, 322, 65, 14);
		lblId.setVisible(false);
		panPrincipal.add(lblId);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(62, 363, 65, 14);
		lblNome.setVisible(false);
		panPrincipal.add(lblNome);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(137, 406, 109, 20);
		txtTelefone.setVisible(false);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(62, 409, 58, 14);
		lblTelefone.setVisible(false);
		panPrincipal.add(lblTelefone);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setVisible(false);
		btnGravar.setBounds(434, 460, 96, 31);
		panPrincipal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(240, 460, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(46, 460, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmFunc.class.getResource
				("/img/LogoLudpet.png")));
		lblLogo.setBounds(10, 181, 546, 199);
		panPrincipal.add(lblLogo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 549, 159);
		scrollPane.setVisible(false);
		panPrincipal.add(scrollPane);
		
		table = new JTable();
		table.setVisible(false);
		scrollPane.setViewportView(table);
		
		janela.setSize(585,553);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centralizarFrame(janela);
		
		btnIncluir.addActionListener( l -> inserirFornecedor() );
		btnGravar.addActionListener(l -> {
			Fornecedor f = new Fornecedor();
			f.setNome(txtNome.getText());
			f.setTelefone(Integer.parseInt(txtTelefone.getText()));
			control = new CtrlFornecedor();
			control.inserir(f);
			limpaCampos();
		});
		
	}
	
	private void limpaCampos() {
		txtNome.setText("");
		txtId.setText("");
		txtTelefone.setText("");
		
	}

	public void inserirFornecedor(){
		txtId.setVisible(true);
		txtId.setEnabled(false);
		txtNome.setVisible(true);
		txtTelefone.setVisible(true);
		lblId.setVisible(true);
		lblNome.setVisible(true);
		lblTelefone.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
		lblLogo.setVisible(false);
		scrollPane.setVisible(true);
		table.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrmFornecedor();
	}
}
