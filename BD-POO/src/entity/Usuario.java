package entity;

/**
 * Classe para os objetos do tipo Usu�rio, onde ser�o contidos
 * os valores e m�todos para o mesmo
 * @author Pedro Afonso
 *
 */
public class Usuario {
	
	private String nome;
	private String senha;
	private Funcionario f;

	/**
	 * M�todo para retorno da senha
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * M�todo para setar o valor da senha
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * M�todo para retorno do objeto Funcion�rio
	 * @return objeto funcion�rio
	 */
	public Funcionario getF() {
		return f;
	}
	
	/**
	 * M�todo para setar o objeto Funcion�rio
	 * @param f
	 */
	public void setF(Funcionario f) {
		this.f = f;
	}
	
	/**
	 * M�todo para retorno do nome do usu�rio
	 * @return nome do Usu�rio
	 */
	@Coluna(nome="Usu�rio (Login)", posicao=0)
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�todo para setar o nome do Usu�rio
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
