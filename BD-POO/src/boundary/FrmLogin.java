package boundary;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;

import control.ConfigTelas;
import control.CtrlLogin;
import entity.Login;

public class FrmLogin implements ConfigTelas{

	private JFrame janela = new JFrame("Realizar Login");
	private JTextField txtUsuario;
	private JPasswordField pwdSenha;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JButton btnLogar;
	private CtrlLogin controlLogin;
	private JPanel panPrincipal;

	public FrmLogin(){
		
		controlLogin = new CtrlLogin();
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setLayout(null);
		
		janela.setContentPane( panPrincipal );
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(SystemColor.info);
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsuario.setBounds(95, 83, 241, 28);
		panPrincipal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBackground(SystemColor.info);
		pwdSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		pwdSenha.setBounds(95, 147, 241, 28);
		panPrincipal.add(pwdSenha);
		
		lblUsuario = new JLabel("Usu�rio:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 89, 61, 14);
		panPrincipal.add(lblUsuario);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSenha.setBounds(10, 152, 61, 14);
		panPrincipal.add(lblSenha);
		
		btnLogar = new JButton("");
		btnLogar.setIcon(new ImageIcon(FrmLogin.class.getResource
				("/img/icon_Login_in.png")));
		btnLogar.setToolTipText("Realizar Login no Sistema");
		btnLogar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLogar.setBounds(281, 186, 55, 36);
		panPrincipal.add(btnLogar);
		
		janela.setSize(564,398);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centralizarFrame(janela);
		
		btnLogar.addActionListener(e -> {
			Login l = new Login();
			l.setUsuario(txtUsuario.getText());
			l.setSenha(new String (pwdSenha.getPassword()));
			controlLogin.realizarLogin(l);
		});
	}
	public static void main(String[] args) {
		new FrmLogin();
	}
}
