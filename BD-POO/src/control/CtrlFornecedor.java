package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.FornecedorDao;
import persistence.FornecedorDaoImpl;
import persistence.PessoaDao;
import persistence.PessoaDaoImpl;
import entity.Fornecedor;

/**
 * Classe para controle das funcionalidades da
 * tela do fornecedor
 * @author Pedro Afonso
 *
 */
public class CtrlFornecedor{
	
	private FornecedorDao fDao;
	private PessoaDao pDao;
	
	/**
	 * M�todo para cadastro do fornecedor
	 * @param f dados do funcion�rio
	 */
	public void inserir(Fornecedor f) {
		pDao = new PessoaDaoImpl();
		fDao = new FornecedorDaoImpl();
		try {
			pDao.inserePessoa(f);
			fDao.inserirFornecedor(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * M�todo para atualizar dados de um fornecedor j� cadastrado
	 * @param f dados do fornecedor
	 */
	public void atualiza(Fornecedor f) {
		fDao = new FornecedorDaoImpl();
		try {
			fDao.atualizarFornecedor(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * M�todo para excluir um fornecedor j� cadastrado
	 * @param f dados do fornecedor
	 */
	public void excluir(Fornecedor f) {
		fDao = new FornecedorDaoImpl();
		
		try {
			fDao.excluirFornecedor(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * M�todo para pesquisar um fornecedor cadastrado pelo nome
	 * @param nome do fornecedor 
	 * @return lista de fornecedores
	 * @throws SQLException excecao do banco sql
	 */
	public List<Fornecedor> buscaFornecedorPorNome(String nome) throws SQLException {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		fDao = new FornecedorDaoImpl();
		try {
			lista = fDao.listaFornecedor(nome);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return lista;
	}
	
}
