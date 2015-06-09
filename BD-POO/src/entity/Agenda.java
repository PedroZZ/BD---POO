package entity;

import java.util.Date;

public class Agenda {
	
	private Date horario;
	private String servico;
	private String descricao;
	
	@Coluna(nome="Hor�rio", posicao=0)
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	
	@Coluna(nome="Servi�o", posicao=1)
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	
	@Coluna(nome="Tipo de Servi�o", posicao=2)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
