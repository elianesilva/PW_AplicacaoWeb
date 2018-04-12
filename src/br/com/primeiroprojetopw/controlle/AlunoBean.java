package br.com.primeiroprojetopw.controlle;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.primeiroprojeto.dao.AlunoDao;
import br.com.primeiroprojeto.modelo.Aluno;

@ManagedBean(name = "alunoBean")
@RequestScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	Aluno novoAluno;
	AlunoDao alunoDao;
	List<Aluno> alunos;
	String nomeBusca;
		
	@PostConstruct
	public void init() {
		novoAluno = new Aluno();
		alunoDao = new AlunoDao();
		alunos = new ArrayList<Aluno>();
		
		try {
			alunos = alunoDao.buscaTodosAlunos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void consultarAlunoPorNome(){
		alunos = alunoDao.BuscaAlunoPorNome(nomeBusca);
	}
	


	public void salvarAluno() throws SQLException {
		
		if(novoAluno.getNome().equals("")){
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("MensagensErro", new FacesMessage(
					"Informe o nome do aluno"));
		}else if(novoAluno.getDataMatricula()==null){
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("MensagensErro", new FacesMessage(
					"Informe a data de mátricula do aluno"));
		}else if(novoAluno.getDataNasc()==null){
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("MensagensErro", new FacesMessage(
					"Informe a data de nascimento do aluno"));
		}else if(novoAluno.getMatricula().equals("")){
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("MensagensErro", new FacesMessage(
					"Informe a matricula do aluno"));
		}else{
		int conseguiuSalvar = alunoDao.inserirAluno(novoAluno);

		if (conseguiuSalvar != 0) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("menssagesSucesso", new FacesMessage(
					"Aluno Salvo Com Sucesso"));
			novoAluno = new Aluno();
		} else {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("MensagensErro", new FacesMessage(
					"Aluno Não Salvo!"));
		}
		}
	}

	public Aluno getNovoAluno() {
		return novoAluno;
	}

	public void setNovoAluno(Aluno novoAluno) {
		this.novoAluno = novoAluno;
	}

	public AlunoDao getAlunoDao() {
		return alunoDao;
	}

	public void setAlunoDao(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public String getNomeBusca() {
		return nomeBusca;
	}
	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}

}
