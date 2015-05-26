package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class FrmUsuario implements ActionListener{

	private JFrame janela;
	private JPanel panelPrincipal;
	private JTable table;
	private JTextField txtNome;
	private JTextField txtUsuario;
	private JPasswordField pwdSenha;
	private JPasswordField pwdConfirmarSenha;
	private JPanel panelAcoes;
	private JButton btnPesquisarNome;
	private JLabel lblNome;
	private JPanel panelFuncionario;
	private JButton btnIncluir;
	private JLabel lblIncluir;
	private JButton btnAlterar;
	private JLabel lblAlterar;
	private JButton btnExcluir;
	private JLabel lblExcluir;
	private JScrollPane scrollPane;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblConfirmaSenha;
	private JButton btnVerificar;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JButton btnGravar;
	private JLabel lblDadosObrigatorios;
	private JLabel lblLogoLudPet;
	
	
	public FrmUsuario() {

		janela = new JFrame("Usuario");
		janela.setTitle("Usu\u00E1rio");
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(SystemColor.window);
		janela.setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		panelAcoes = new JPanel();
		panelAcoes.setLayout(null);
		panelAcoes.setForeground(Color.WHITE);
		panelAcoes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAcoes.setBackground(SystemColor.window);
		panelAcoes.setBounds(128, 11, 338, 79);
		panelPrincipal.add(panelAcoes);
		
		btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		btnIncluir.setActionCommand("Incluir");
		panelAcoes.add(btnIncluir);
		
		lblIncluir = new JLabel("Incluir");
		lblIncluir.setVerticalTextPosition(SwingConstants.TOP);
		lblIncluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIncluir.setBounds(59, 54, 39, 19);
		panelAcoes.add(lblIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		btnAlterar.setActionCommand("Alterar");
		panelAcoes.add(btnAlterar);
		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlterar.setBounds(153, 54, 44, 19);
		panelAcoes.add(lblAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		btnExcluir.setActionCommand("Excluir");
		panelAcoes.add(btnExcluir);
		
		lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExcluir.setBounds(242, 54, 39, 19);
		panelAcoes.add(lblExcluir);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(10, 103, 598, 163);
		panelPrincipal.add(scrollPane);
		
		table = new JTable();
		table.setVisible(false);
		scrollPane.setViewportView(table);
		
		panelFuncionario = new JPanel();
		panelFuncionario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Funcionario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFuncionario.setForeground(Color.WHITE);
		panelFuncionario.setBackground(Color.WHITE);
		panelFuncionario.setBounds(28, 288, 553, 84);
		panelPrincipal.add(panelFuncionario);
		panelFuncionario.setVisible(false);
		panelFuncionario.setLayout(null);
		
		lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 31, 58, 14);
		lblNome.setVisible(false);
		panelFuncionario.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBackground(SystemColor.info);
		txtNome.setBounds(78, 30, 261, 23);
		panelFuncionario.add(txtNome);
		txtNome.setColumns(10);
		
		btnPesquisarNome = new JButton("");
		btnPesquisarNome.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/MiniLupa.png")));
		btnPesquisarNome.setBounds(349, 27, 40, 23);
		panelFuncionario.add(btnPesquisarNome);
		
		lblUsuario = new JLabel("Usu\u00E1rio : *");
		lblUsuario.setVisible(false);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(38, 383, 80, 14);
		panelPrincipal.add(lblUsuario);
		
		lblSenha = new JLabel("Senha : *");
		lblSenha.setVisible(false);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(38, 426, 80, 14);
		panelPrincipal.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setVisible(false);
		txtUsuario.setBackground(SystemColor.info);
		txtUsuario.setBounds(128, 382, 141, 23);
		panelPrincipal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setVisible(false);
		pwdSenha.setBackground(SystemColor.info);
		pwdSenha.setBounds(128, 425, 141, 23);
		panelPrincipal.add(pwdSenha);
		
		lblConfirmaSenha = new JLabel("Confirmar senha : *");
		lblConfirmaSenha.setVisible(false);
		lblConfirmaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmaSenha.setBounds(38, 472, 141, 14);
		panelPrincipal.add(lblConfirmaSenha);
		
		pwdConfirmarSenha = new JPasswordField();
		pwdConfirmarSenha.setVisible(false);
		pwdConfirmarSenha.setBackground(SystemColor.info);
		pwdConfirmarSenha.setBounds(189, 471, 141, 23);
		panelPrincipal.add(pwdConfirmarSenha);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.setVisible(false);
		btnVerificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerificar.setBounds(279, 381, 90, 23);
		panelPrincipal.add(btnVerificar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setVisible(false);
		btnVoltar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(29, 562, 98, 31);
		panelPrincipal.add(btnVoltar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setVisible(false);
		btnLimpar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(261, 562, 98, 31);
		panelPrincipal.add(btnLimpar);
		
		btnGravar = new JButton("Gravar\r\n");
		btnGravar.setVisible(false);
		btnGravar.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setBounds(483, 562, 98, 31);
		panelPrincipal.add(btnGravar);
		
		lblDadosObrigatorios = new JLabel("* Dados obrigat\u00F3rios");
		lblDadosObrigatorios.setVisible(false);
		lblDadosObrigatorios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosObrigatorios.setBounds(464, 537, 117, 14);
		panelPrincipal.add(lblDadosObrigatorios);
		
		lblLogoLudPet = new JLabel("");
		lblLogoLudPet.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/LogoLudpet.png")));
		lblLogoLudPet.setBounds(20, 174, 587, 286);
		
		panelPrincipal.add(lblLogoLudPet);
		janela.setSize(633, 671);		
		ConfigTelas.centralizarFrame(janela);
		
		btnIncluir.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnExcluir.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		lblLogoLudPet.setVisible(false);
		
		if(acao.equalsIgnoreCase("Incluir")){
			montarTelaIncluir();
		} else if(acao.equalsIgnoreCase("Alterar")){
			montarTelaIncluir();
			montarTelaAlterarRemover();
		}else if(acao.equalsIgnoreCase("Excluir")){
			montarTelaIncluir();
			montarTelaAlterarRemover();
		}
		
	}
	
	private void montarTelaAlterarRemover() {
		// TODO Auto-generated method stub
		
	}

	private void montarTelaIncluir() {
		//FAZER OS ENABLE
		table.setVisible(true);
		scrollPane.setVisible(true);
		panelFuncionario.setVisible(true);
		lblNome.setVisible(true);
		lblSenha.setVisible(true);
		lblUsuario.setVisible(true);
		lblDadosObrigatorios.setVisible(true);
		lblConfirmaSenha.setVisible(true);
		txtNome.setVisible(true);
		txtUsuario.setVisible(true);
		pwdSenha.setVisible(true);
		pwdConfirmarSenha.setVisible(true);
		btnGravar.setVisible(true);
		btnVoltar.setVisible(true);
		btnLimpar.setVisible(true);
	}

	public static void main(String[] args) {
		new FrmUsuario();
	}


}
