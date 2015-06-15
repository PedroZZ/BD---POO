package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.ClienteDao;
import persistence.ClienteDaoImpl;
import persistence.PessoaDao;
import persistence.PessoaDaoImpl;
import entity.Cliente;

/**
 * Classe para controle das funcionalidades
 * do tela do cliente
 * @author Pedro Afonso
 *
 */
public class CtrlCliente {
	
	private PessoaDao pDao;
	private ClienteDao cDao;
	
	/**
	 * M�todo para cadatrar um cliente
	 * @param c cliente a ser cadastrado
	 */
	public void inserir(Cliente c) {
		pDao = new PessoaDaoImpl();
		cDao = new ClienteDaoImpl();
		try {
			pDao.inserePessoa(c);
			cDao.inserirCliente(c);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * M�todo para atualizar um cliente cadastrado
	 * @param c dados do cliente a serem atualizados
	 */
	public void atualiza(Cliente c) {
		cDao = new ClienteDaoImpl();
		try {
			cDao.atualizarCliente(c);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	/**
	 * M�todo para buscar um cliente cadastrado pelo nome
	 * @param nome do cliente a ser pesquisado
	 * @return lista de clientes  
	 * @throws SQLException exce��o do banco de dados sql
	 */
	public List<Cliente> buscaClientePorNome(String nome) throws SQLException {
		List<Cliente> lista = new ArrayList<Cliente>();
		cDao = new ClienteDaoImpl();
		try {
			lista = cDao.listaCliente(nome);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

	/**
	 * M�todo para excluir um cliente cadastrado
	 * @param c dados do cliente a ser exclu�do
	 */
	public void excluir(Cliente c) {
		cDao = new ClienteDaoImpl();
		
		try {
			cDao.excluirCliente(c);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
