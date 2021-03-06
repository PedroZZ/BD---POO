package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import util.ConfiguracoesTela;
import util.ModeloTabela;
import util.TratamentoTextFields;
import control.CtrlAnimal;
import control.CtrlCliente;
import entity.Animal;
import entity.Cliente;
import entity.Usuario;

/**
 * Classe que possui os componentes de tela para manipula��o
 * dos dados de Animais
 * @author Pedro Zuzi
 *
 */
public class FrmAnimal extends MouseAdapter {
	
	private JFrame janelaAnimal;
	private JPanel panPrincipalAnimal;
	private JPanel panelAnimal;
	private JButton btnIncluir;
	private JLabel lblIncluir;
	private JButton btnAlterar;
	private JLabel lblAlterar;
	private JButton btnExcluir;
	private JLabel lblExcluir;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JButton btnLupaPesquisar;
	private JTextField txtNome;
	private JTextField txtRga;
	private JTextField txtRaca;
	private JTextField txtCor;
	private JTable tableAnimal;
	private JTable tableBusca;
	private JTextField txtCliente;
	private JLabel lblEspecie;
	private JComboBox<String> comboBoxEspecie;
	private JScrollPane scrollPane;
	private JLabel lblRaca;
	private JLabel lblCor;
	private JLabel lblSexo;
	private JLabel lblRga;
	private JComboBox<String> comboBoxSexo;
	private ModeloTabela modelo;
	private CtrlCliente controlCliente;
	private List<Cliente> listaCliente;
	private List<Animal> listaAnimal;
	private JPanel panPrincipalBusca;
	private JScrollPane scrollPaneBusca;
	private JButton btnLupaPesquisarBusca;
	private JTextField txtBuscaCliente;
	private JLabel lblNome;
	private int idCliente;
	private CtrlAnimal controlAnimal;
	private int idAnimal;
	private JDialog jd = new JDialog();
	private JPanel panelCliente;
	private JLabel lblLogo;
	private JMenuBar menuBarra;
	private JMenu menu;
	private JMenuItem menuPrincipal;
	private JMenuItem logOff;
	private JLabel lblTiraCinza;
	private JLabel label;
	private JLabel lblTiraCinza2;
	private JLabel lblTiraCinza3;
	private JLabel lblTiraVermelha2;
	private JLabel lblTiraVermelha;
	private ConfiguracoesTela configTela;
	
	/**
	 * Contrutor.
	 * @param u usu�rio logado no sistema
	 */
	public FrmAnimal(Usuario u) {
		
		janelaAnimal = new JFrame("Animal");
		
		panPrincipalAnimal = new JPanel();
		panPrincipalAnimal.setBackground(SystemColor.text);
		panPrincipalAnimal.setForeground(Color.WHITE);
		panPrincipalAnimal.setLayout(null);
		
		menuBarra = new JMenuBar();
		janelaAnimal.setJMenuBar(menuBarra);
		
		menu = new JMenu("Menu");
		menuBarra.add(menu);
		
		menuPrincipal = new JMenuItem("Menu Principal");
		menuPrincipal.setIcon(new ImageIcon(getClass()
				.getResource("/img/HomeMenu.png")));
		menu.add(menuPrincipal);
		
		logOff = new JMenuItem("Log Off");
		logOff.setIcon(new ImageIcon(getClass()
				.getResource("/img/LogOffMenu.png")));
		menu.add(logOff);
		
		txtCliente = new JTextField();
		txtCliente.setEnabled(false);
		txtCliente.setVisible(false);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		label.setBounds(368, 463, 270, 14);
		panPrincipalAnimal.add(label);
		
		lblTiraCinza2 = new JLabel("");
		lblTiraCinza2.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		lblTiraCinza2.setBounds(-10, 463, 236, 14);
		panPrincipalAnimal.add(lblTiraCinza2);
		
		lblTiraVermelha = new JLabel("");
		lblTiraVermelha.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/TiraVermelha.png")));
		lblTiraVermelha.setBounds(0, 0, 621, 14);
		panPrincipalAnimal.add(lblTiraVermelha);
			
		lblTiraVermelha2 = new JLabel("");
		lblTiraVermelha2.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/TiraVermelha.png")));
		lblTiraVermelha2.setBounds(-10, 488, 648, 14);
		panPrincipalAnimal.add(lblTiraVermelha2);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(177, 265, 263, 237);
		panPrincipalAnimal.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/img/logo.png")));
		txtCliente.setBounds(145, 301, 238, 20);
		panPrincipalAnimal.add(txtCliente);
		txtCliente.setColumns(10);
		
		panelAnimal = new JPanel();
		panelAnimal.setLayout(null);
		panelAnimal.setForeground(Color.WHITE);
		panelAnimal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAnimal.setBackground(Color.WHITE);
		panelAnimal.setBounds(129, 17, 343, 79);
		panPrincipalAnimal.add(panelAnimal);
		
		btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		btnIncluir.setVisible(true);
		panelAnimal.add(btnIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		btnAlterar.setVisible(true);
		panelAnimal.add(btnAlterar);
		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlterar.setVisible(true);
		lblAlterar.setBounds(162, 54, 44, 19);
		panelAnimal.add(lblAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		btnExcluir.setVisible(true);
		panelAnimal.add(btnExcluir);
		
		lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblExcluir.setVisible(true);
		lblExcluir.setBounds(252, 53, 38, 19);
		panelAnimal.add(lblExcluir);
		
		lblIncluir = new JLabel("Incluir");
		lblIncluir.setBounds(59, 54, 69, 19);
		panelAnimal.add(lblIncluir);
		lblIncluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIncluir.setVisible(true);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setVisible(false);
		btnGravar.setBounds(417, 543, 96, 31);
		panPrincipalAnimal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(258, 543, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipalAnimal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(94, 543, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipalAnimal.add(btnVoltar);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setVisible(false);
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(417, 290, 65, 31);
		panPrincipalAnimal.add(btnLupaPesquisar);
		
		txtNome = new TratamentoTextFields();
		txtNome.setVisible(false);
		txtNome.setBounds(157, 369, 238, 20);
		panPrincipalAnimal.add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setVisible(false);
		lblNome.setBounds(83, 372, 46, 14);
		panPrincipalAnimal.add(lblNome);
		
		txtRga = new TratamentoTextFields(6);
		txtRga.setVisible(false);
		txtRga.setBounds(157, 410, 128, 20);
		panPrincipalAnimal.add(txtRga);
		txtRga.setColumns(10);
		
		lblRga = new JLabel("RGA:");
		lblRga.setVisible(false);
		lblRga.setBounds(83, 410, 46, 14);
		panPrincipalAnimal.add(lblRga);
		
		txtRaca = new TratamentoTextFields();
		txtRaca.setVisible(false);
		txtRaca.setBounds(157, 448, 138, 20);
		panPrincipalAnimal.add(txtRaca);
		txtRaca.setColumns(10);
		
		lblRaca = new JLabel("Ra\u00E7a:");
		lblRaca.setVisible(false);
		lblRaca.setBounds(83, 451, 46, 14);
		panPrincipalAnimal.add(lblRaca);
		
		lblCor = new JLabel("Cor:");
		lblCor.setVisible(false);
		lblCor.setBounds(315, 451, 46, 14);
		panPrincipalAnimal.add(lblCor);
		
		txtCor = new TratamentoTextFields();
		txtCor.setVisible(false);
		txtCor.setBounds(358, 448, 86, 20);
		panPrincipalAnimal.add(txtCor);
		txtCor.setColumns(10);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setVisible(false);
		lblSexo.setBounds(83, 485, 46, 14);
		panPrincipalAnimal.add(lblSexo);
		
		lblEspecie = new JLabel("Esp\u00E9cie:");
		lblEspecie.setVisible(false);
		lblEspecie.setBounds(207, 482, 68, 14);
		panPrincipalAnimal.add(lblEspecie);
		
		comboBoxEspecie = new JComboBox<String>();
		comboBoxEspecie.setVisible(false);
		comboBoxEspecie.setBounds(274, 479, 138, 20);
		comboBoxEspecie.addItem("Cachorro");
		comboBoxEspecie.addItem("Gato");	
		panPrincipalAnimal.add(comboBoxEspecie);
			
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setVisible(false);
		comboBoxSexo.setBounds(129, 482, 38, 20);
		comboBoxSexo.addItem("M");
		comboBoxSexo.addItem("F");
		panPrincipalAnimal.add(comboBoxSexo);
		
		tableAnimal = new JTable();
		tableAnimal.setVisible(false);
		tableAnimal.addMouseListener(this);
		tableAnimal.setBorder(new LineBorder(Color.BLACK));
		tableAnimal.setGridColor(Color.BLACK);
		tableAnimal.setShowGrid(true);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.getViewport().setBorder(null);
		scrollPane.setViewportView(tableAnimal);
		scrollPane.setBounds(10, 107, 591, 159);
		panPrincipalAnimal.add(scrollPane);
		
		panelCliente = new JPanel();
		panelCliente.setVisible(false);
		panelCliente.setForeground(Color.WHITE);
		panelCliente.setBackground(Color.WHITE);
		panelCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCliente.setBounds(129, 278, 363, 65);
		panPrincipalAnimal.add(panelCliente);
		
		lblTiraCinza = new JLabel("");
		lblTiraCinza.setBounds(454, 17, 184, 14);
		panPrincipalAnimal.add(lblTiraCinza);
		lblTiraCinza.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		
		lblTiraCinza3 = new JLabel("");
		lblTiraCinza3.setBounds(0, 17, 129, 14);
		panPrincipalAnimal.add(lblTiraCinza3);
		lblTiraCinza3.setIcon(new ImageIcon(this.getClass().getResource("/img/TiraCinza.png")));
		
		janelaAnimal.setContentPane( panPrincipalAnimal );
		
		configTela = new ConfiguracoesTela();
		janelaAnimal.setSize(627,656);
		configTela.iconeBarra(janelaAnimal);
		configTela.tamanho(janelaAnimal);
		
		logOff.addActionListener(e -> {
			janelaAnimal.dispose();
			new FrmLogin();
		});
		
		menuPrincipal.addActionListener(e -> {
			janelaAnimal.dispose();
			janelaAnimal = null;
			new FrmPrincipal(u);
		}); 
		
		btnLupaPesquisar.addActionListener(l -> {
			cliente(jd);
		});
		
		btnIncluir.addActionListener(l -> {
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Gravar");
			montarTela();
			btnGravar.setActionCommand("Incluir");
		});
		
		btnAlterar.addActionListener(l -> {
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Alterar");
			montarTela();
			btnGravar.setActionCommand("Alterar");
		});
		
		btnExcluir.addActionListener(l -> {
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/trash.png")));
			btnGravar.setText("Excluir");
			montarTela();
			btnGravar.setActionCommand("Excluir");
		});
		
		btnGravar.addActionListener(e -> {
			String cmd = e.getActionCommand();
			try {
				if (!validaCampos()) {
					acaoGravar(cmd);
					buscaAnimaisDoCliente();
				}else{
					JOptionPane.showMessageDialog(null, "Sem dados para processar");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btnLimpar.addActionListener(e -> limpaCampos() );
		
		btnVoltar.addActionListener(e -> {
			new FrmCadastros(u);
			janelaAnimal.dispose();
		});
	}
	
	/**
	 * M�todo para valida��o dos campos
	 * @return true se campos vazios, false se campos preenchidos
	 */
	private boolean validaCampos() {
		return txtCliente.getText().isEmpty() || 
				txtCor.getText().isEmpty() || 
				txtCor.getText().isEmpty() || 
				txtNome.getText().isEmpty() || 
				txtRaca.getText().isEmpty() || 
				txtRga.getText().isEmpty();
	}

	/**
	 * M�todo que monta a tela para o usu�rio
	 */
	private void montarTela() {
		lblLogo.setVisible(false);
		lblTiraCinza2.setVisible(false);
		label.setVisible(false);
		lblTiraVermelha2.setVisible(false);
		tableAnimal.setVisible(true);
		scrollPane.setVisible(true);
		panelCliente.setVisible(true);
		txtCliente.setVisible(true);
		btnLupaPesquisar.setVisible(true);
		lblNome.setVisible(true);
		txtNome.setVisible(true);
		lblRga.setVisible(true);
		txtRga.setVisible(true);
		comboBoxSexo.setVisible(true);
		comboBoxEspecie.setVisible(true);
		lblSexo.setVisible(true);
		lblEspecie.setVisible(true);
		txtCor.setVisible(true);
		lblCor.setVisible(true);
		txtRaca.setVisible(true);
		lblRaca.setVisible(true);
		btnGravar.setVisible(true);
		btnLimpar.setVisible(true);
		btnVoltar.setVisible(true);
	}

	/**
	 * M�todo para abrir um JDialog para buscar clientes
	 * @param jd recebe um JDialog
	 */
	public void cliente(JDialog jd) {
		jd = new JDialog(jd, "Buscar Cliente", true);
		
		try {
			BufferedImage image = ImageIO.read(  
			        this.getClass().getResource("/img/icon.png"));
			jd.setIconImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		panPrincipalBusca = new JPanel();
		panPrincipalBusca.setBackground(SystemColor.text);
		panPrincipalBusca.setForeground(Color.WHITE);
		panPrincipalBusca.setLayout(null);
		
		tableBusca = new JTable();
		tableBusca.addMouseListener(this);
		tableBusca.setBorder(new LineBorder(Color.BLACK));
		tableBusca.setGridColor(Color.BLACK);
		tableBusca.setShowGrid(true);
		
		scrollPaneBusca = new JScrollPane();
		scrollPaneBusca.getViewport().setBorder(null);
		scrollPaneBusca.setViewportView(tableBusca);
		scrollPaneBusca.setBounds(10, 64, 539, 159);
		panPrincipalBusca.add(scrollPaneBusca);
		
		btnLupaPesquisarBusca = new JButton("");
		btnLupaPesquisarBusca.setIcon(new ImageIcon(FrmAnimal.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisarBusca.setBounds(368, 22, 65, 31);
		btnLupaPesquisarBusca.setVisible(true);
		panPrincipalBusca.add(btnLupaPesquisarBusca);
		
		txtBuscaCliente = new JTextField();
		txtBuscaCliente.setBounds(92, 33, 264, 20);
		panPrincipalBusca.add(txtBuscaCliente);
		txtBuscaCliente.setColumns(10);
		
		btnLupaPesquisarBusca.addActionListener(l -> {
			buscaCliente();
		});
		
		jd.setContentPane( panPrincipalBusca );
		jd.setSize(580,280);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
		
	}
	
	/**
	 * M�todo chamado para invocar uma a��o ao bot�o pressionado
	 * @param cmd recebe um comando ao qual ser� chamado uma a��o
	 * @throws SQLException
	 */
	private void acaoGravar(String cmd) throws SQLException {
		Animal a = new Animal();
		controlAnimal = new CtrlAnimal();
			if ("Incluir".equalsIgnoreCase(cmd)) {
				a.setId(idCliente);
				a.setNome(txtNome.getText());
				a.setRaca(txtRaca.getText());
				a.setCor(txtCor.getText());
				a.setEspecie(String.valueOf(comboBoxEspecie.getSelectedItem()));
				a.setSexo(String.valueOf(comboBoxSexo.getSelectedItem()));
				a.setRga(txtRga.getText());
				controlAnimal.inserir(a);
			} else if ("Alterar".equalsIgnoreCase(cmd)) {
				a.setId(idAnimal);
				a.setNome(txtNome.getText());
				a.setRaca(txtRaca.getText());
				a.setCor(txtCor.getText());
				a.setEspecie(String.valueOf(comboBoxEspecie.getSelectedItem()));
				a.setSexo(String.valueOf(comboBoxSexo.getSelectedItem()));
				a.setRga(txtRga.getText());
				controlAnimal.atualiza(a);
			} else if ("Excluir".equalsIgnoreCase(cmd)) {
				a.setId(idAnimal);
				a.setNome(txtNome.getText());
				a.setRaca(txtRaca.getText());
				a.setCor(txtCor.getText());
				a.setEspecie(String.valueOf(comboBoxEspecie.getSelectedItem()));
				a.setSexo(String.valueOf(comboBoxSexo.getSelectedItem()));
				a.setRga(txtRga.getText());
				controlAnimal.excluir(a);
			}
			limpaCampos();
	}
	
	/**
	 * M�todo invocado para busca de clientes do banco de dados
	 */
	public void buscaCliente() {
		controlCliente = new CtrlCliente();
		listaCliente = new ArrayList<Cliente>();

			try {
				listaCliente = controlCliente.buscaClientePorNome(txtBuscaCliente.getText());
				if (!listaCliente.isEmpty()) {
					modelo = new ModeloTabela(listaCliente);
					tableBusca.getTableHeader().setReorderingAllowed(false);
					tableBusca.setModel(modelo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		limpaCampos();

	}
	
	/**
	 * M�todo para limpar os campos
	 */
	private void limpaCampos() {
		txtNome.setText("");
		txtCor.setText("");
		txtRaca.setText("");
		txtRga.setText("");
	}
	
	/**
	 * M�todo chamado quando ocorre um clique em uma tabela
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		Object acao = e.getSource();
		Object valorCliente;
		if (tableBusca.equals(acao)) {
			int linha = tableBusca.getSelectedRow();
			idCliente = listaCliente.get(linha).getId();
			valorCliente = tableBusca.getValueAt(linha, 0);
			txtCliente.setText(String.valueOf(valorCliente));
			
			buscaAnimaisDoCliente();
		}
		
		if (tableAnimal.equals(acao)) {
			int linha = tableAnimal.getSelectedRow();
			int coluna = tableAnimal.getSelectedColumn();
			Object[] valoresAnimal = new Object[6];
			
			for (coluna = 0; coluna < tableAnimal.getColumnCount(); coluna++) {
				valoresAnimal[coluna] = tableAnimal.getValueAt(linha, coluna);
			}
			
			idAnimal = listaAnimal.get(linha).getId();
			txtNome.setText( String.valueOf(valoresAnimal[0]));
			txtRga.setText( String.valueOf(valoresAnimal[1]));
			txtRaca.setText( String.valueOf(valoresAnimal[2]));
			comboBoxEspecie.setSelectedItem(valoresAnimal[3]);
			comboBoxSexo.setSelectedItem(valoresAnimal[4]);
			txtCor.setText( String.valueOf(valoresAnimal[5]));
		}
	}
	
	/**
	 * M�todo para busca de animais de um cliente no banco de dados
	 */
	private void buscaAnimaisDoCliente() {
		controlAnimal = new CtrlAnimal();
		listaAnimal = new ArrayList<Animal>();
		
		try {
			listaAnimal = controlAnimal.buscaAnimal(idCliente);
			
			if (!listaAnimal.isEmpty()) {
				modelo = new ModeloTabela(listaAnimal);
				tableAnimal.getTableHeader().setReorderingAllowed(false);
				tableAnimal.setModel(modelo);
			}else{
				modelo.clear();
				jd.dispose();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
