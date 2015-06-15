package entity;

import java.util.Date;

/**
 * Classe para objeto do tipo VendaProduto com seus valores e
 * m�todos necess�rio
 * @author Hury
 *
 */
public final class VendaProduto {

	private Date data;
	private int idvenda;
	private int idproduto;
	private int quantidade;

	/**
	 * M�todo para retorno da data da venda
	 * @return data da venda
	 */
	@Coluna(nome = "data", posicao = 0)
	public Date getData() {
		return data;
	}

	/**
	 * M�todo para setar a data da venda
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * M�todo para retorno do id da venda
	 * @return valor do id da venda
	 */
	@Coluna(nome = "idvenda", posicao = 1)
	public int getIdvenda() {
		return idvenda;
	}

	/**
	 * M�todo para setar o valor do id da venda
	 * @param idvenda valor do id
	 */
	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}

	/**
	 * M�todo para retorno do id do produto
	 * @return
	 */
	@Coluna(nome = "idproduto", posicao = 2)
	public int getIdproduto() {
		return idproduto;
	}

	/**
	 * M�todo para setar o valor do id do produto
	 * @param idproduto
	 */
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}

	/**
	 * M�todo para retorno da quantidade da venda
	 * @return valor da quantidade
	 */
	@Coluna(nome = "idquantidade", posicao = 3)
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * M�todo para setar o valor da quantidade da venda
	 * @param quantidade valor da quantidade
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
