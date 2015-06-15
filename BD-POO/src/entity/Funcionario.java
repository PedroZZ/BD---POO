package entity;

/**
 * Classe para objeto do tipo Funcionario com valores e 
 * tipo do mesmo
 * @author x036157
 *
 */
public class Funcionario extends Pessoa{

	private String cpf;
	private double salario;
	
	/**
	 * M�todo para retorno do sal�rio do funcin�rio
	 * @return valor do sal�rio'
	 */
	public double getSalario() {
		return salario;
	}
	
	/**
	 * M�todo para setar o sal�rio do funcionario
	 * @param salario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	/**
	 * M�todo para retorno do cpf do funcion�rio
	 * @return valor do cpf
	 */
	@Coluna(nome="CPF", posicao=1)
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * M�todo para setar o cpf do funcion�rio
	 * @param cpf valor do cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	/**
	 * 
	 */
	@Coluna(nome="Nome", posicao=0)
	@Override
	public String getNome() {
		return super.getNome();
	}
	
	/**
	 * 
	 */
	@Override
	public int getIdTipo() {
		return super.getIdTipo();
	}
	
}
