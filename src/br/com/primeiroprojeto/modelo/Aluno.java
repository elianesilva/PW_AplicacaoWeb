package br.com.primeiroprojeto.modelo;

import java.io.Serializable;
import java.util.Date;

public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private Date dataNasc;
	private Date dataMatricula;
	private String matricula;
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Date getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

}
