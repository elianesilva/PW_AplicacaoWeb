package br.com.primeiroprojeto.modelo;
import java.io.Serializable;

import java.util.Date;

public class Prova implements Serializable {
	
	private static final long serialVersionUID = 1L;;
	private String descricao;
	private Date dataProva;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataProva() {
		return dataProva;
	}
	public void setDataProva(Date dataProva) {
		this.dataProva = dataProva;
	}
	
	

}
