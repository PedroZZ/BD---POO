package entity;

/**
 * Classe para os objetos do tipo Servi�o, onde ser�o contidos
 * os valores e m�todos para o mesmo
 * @author Pedro Afonso
 *
 */
public class Servico {

	private int codigo;
	private String nome;
	private int valor;
	private Cliente cliente;
	private Animal animal;
	
	/**
	 * M�todo para retorno do valor
	 * @return valor
	 */
	public int getValor() {
		return valor;
	}
	
	/**
	 * M�todo para setar o valor
	 * @param valor
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	/**
	 * M�todo para retorno do nome do cliente
	 * @return nome do cliente
	 */
	@Coluna(nome="Nome Cliente", posicao=1)
	public String getNomeCliente(){
		return this.cliente.getNome();
	}
	
	/**
	 * M�todo para retorno do nome do animal
	 * @return nome do animal
	 */
	@Coluna(nome="Nome Animal", posicao=2)
	public String getNomeAnimal(){
		return animal.getNome();
	}
	
	/**
	 * M�todo para retorno da ra�a do animal
	 * @return ra�a do animal
	 */
	@Coluna(nome="Raca Animal", posicao=3)
	public String getRacaAnimal(){
		return animal.getRaca();
	}
	
	/**
	 * M�todo para retorno do objeto do tipo cliente
	 * @return objeto cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * M�todo para setar o valor do objeto cliente
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * M�todo para retorno do c�digo do servi�o
	 * @return c�digo do servi�o
	 */
	@Coluna(nome="Codigo Servi�o", posicao=0)
	public int getCodigo() {
		return codigo;
	}

	/**
	 * M�todo para setar o c�digo do servi�o
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * M�todo para retorno do nome do servi�o
	 * @return nome do servi�o
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * M�todo para setar o nome do servi�o
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * M�todo para escrever na inst�ncia do servi�o
	 * seu nome
	 */
	@Override
	public String toString() {
		return this.nome;
	}

	/**
	 * M�todo para retorno do objeto animal
	 * @return Objeto animal
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * M�todo para setar o objeto animal
	 * @param animal
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
}
