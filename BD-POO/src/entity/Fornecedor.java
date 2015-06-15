package entity;

/**
 * Classe para os objetos do tipo Fornecedor, onde ser�o contidos
 * os valores e m�todos para o mesmo
 * @author Pedro Afonso
 * @author Pedro Zuzi
 *
 */
public class Fornecedor extends Pessoa{
	
	/**
	 * M�todo para retorno do nome do fornecedor
	 * @return Nome do Fornecedor
	 */
	@Coluna(nome="Nome", posicao=0)
	@Override
	public String getNome() {
		return super.getNome();
	}
	
	/**
	 * M�todo para retorno do telefone do Fornecedor
	 * @return telefone
	 */
	@Coluna(nome="Telefone", posicao=1)
	@Override
	public int getTelefone() {
		return super.getTelefone();
	}	


}
