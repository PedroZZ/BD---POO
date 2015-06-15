package entity;

/**
 * Classe para os objetos do tipo agenda, onde ser�o contidos
 * os valores e m�todos para o mesmo
 * @author Pedro Zuzi
 *
 */
public class Agenda {
	
	private String horario;
	private Boolean escolhaHorario;
	private Servico servico;
	private Cliente cliente;
	private int auxiliar;
	
	/**
	 * M�todo para retorno da escolha do hor�rio
	 * @return Hor�rio escolhido
	 */
	@Coluna(nome="Servi�o", posicao=1)
	public Boolean getEscolhaHorario() {
		return escolhaHorario;
	}
	
	/**
	 * M�todo para setar o valor da escolha do hor�rio
	 * @param escolhaHorario
	 */
	public void setEscolhaHorario(Boolean escolhaHorario) {
		this.escolhaHorario = escolhaHorario;
	}
	
	/**
	 * M�todo para retorno do objeto Cliente
	 * @return Um Objeto cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * M�todo para setar o objeto cliente
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	

	/**
	 * M�todo para retorno do hor�rio
	 * @return horario
	 */
	@Coluna(nome="Hor�rio", posicao=0)
	public String getHorario() {
		return horario;
	}

	/**
	 * M�todo para setar o hor�rio
	 * @param horario
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	/**
	 * 
	 * @return auxiliar
	 */
	public int getAuxiliar() {
		return auxiliar;
	}
	
	public void setAuxiliar(int auxiliar) {
		if(this.auxiliar == 0){
			setEscolhaHorario(new Boolean(false));
		} else {
			setEscolhaHorario(new Boolean(true));
			System.out.println("true");
		}
	}
	
	/**
	 * M�todo para retorno do hor�rio formatado
	 */
	@Override
	public String toString() {
		return this.horario;
	}
	
	/**
	 * M�todo para retorno do objeto servi�o
	 * @return Objeto servi�o
	 */
	public Servico getServico() {
		return servico;
	}
	
	/**
	 * M�tod para setar o objeto servi�o
	 * @param servico
	 */
	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
