package entity;

/**
 * Classe para os objetos do tipo Tipo, com seus valores
 * e m�todos
 * @author Pedro Afonso
 *
 */
public class Tipo {

	private int id;
	private String descricao;

	/**
	 * M�todo para retorno no id do tipo
	 * @return valor do id
	 */
	public int getId() {
		return id;
	}

	/**
	 * M�todo para setar o valor do id 
	 * @param id valor do id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * M�todo para retorno da descri��o do tipo
	 * @return descri��o do tipo
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * M�todo para setar 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
