package entity;

import java.util.Date;

public class Agenda {
	
	private Date horario;
	private Boolean servico;
	private String descricao;
	
	@Coluna(nome="Hor�rio", posicao=0)
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	
	@Coluna(nome="Servi�o", posicao=1)
	public Boolean getServico() {
		return servico;
	}
	
	public void setServico(Boolean boolean1) {
		this.servico = boolean1;
	}
	
	@Coluna(nome="Tipo de Servi�o", posicao=2)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
