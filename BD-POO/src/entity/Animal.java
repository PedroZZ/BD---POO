package entity;

/**
 * Classe para o tipo do animal com valores e
 * tipo do mesmo
 * @author Pedro Afonso
 *
 */
public class Animal {
	
	private int id;
	private String rga;
	private String nome;
	private String raca;
	private String sexo;
	private String especie;
	private String cor;

	/**
	 * M�todo para retorno o valor do id do animal
	 * @return valor do id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * M�todo para setar o id do anil
	 * @param id valor do id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * M�todo para retorno do rga do animal
	 * @return valor do rga
	 */
	@Coluna(nome="RGA", posicao=1)
	public String getRga() {
		return rga;
	}
	
	/**
	 * M�todo para setar o rga do animal
	 * @param rga valor do rga 
	 */
	public void setRga(String rga) {
		this.rga = rga;
	}
	
	/**
	 * M�todo para retorno do nome do animal
	 * @return nome no animal
	 */
	@Coluna(nome="Nome", posicao=0)
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�todo para setar o nome do animal 
	 * @param nome do animal
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * M�todo para retorno do da ra�a do animal
	 * @return nome da ra�a
	 */
	@Coluna(nome="Ra�a", posicao=2)
	public String getRaca() {
		return raca;
	}
	
	/**
	 * M�todo para setar a ra�a do animal
	 * @param raca nome da ra�a
	 */
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	/**
	 * M�todo para escrever o nome do animal
	 * pela instancia do mesmo
	 */
	@Override
	public String toString() {
		return this.nome;
	}
	
	/**
	 * M�todo para retorno da cor do animal
	 * @return nome da cor 
	 */
	@Coluna(nome="Cor", posicao=5)
	public String getCor() {
		return cor;
	}
	
	/**
	 * M�todo para setar a cor do animal
	 * @param cor nome da cor 
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	/**
	 * M�todo para retorno do sexo do animal
	 * @return
	 */
	@Coluna(nome="Sexo", posicao=4)
	public String getSexo() {
		return sexo;
	}
	
	/**
	 * M�todo para setar o sexo do animal
	 * @param sexo nome do sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	/**
	 * M�todo para retorno da esp�cie do animal
	 * @return nome da esp�cie 
	 */
	@Coluna(nome="Esp�cie", posicao=3)
	public String getEspecie() {
		return especie;
	}
	
	/**
	 * M�todo para setar o nome da esp�cie do animal
	 * @param especie nome da esp�cie
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	

}
