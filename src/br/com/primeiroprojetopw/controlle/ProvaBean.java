package br.com.primeiroprojetopw.controlle;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.primeiroprojeto.dao.ProvaDao;
import br.com.primeiroprojeto.modelo.Aluno;
import br.com.primeiroprojeto.modelo.Prova;

@ManagedBean(name = "ProvaBean")
@RequestScoped
public class ProvaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Prova novaProva;
	ProvaDao provaDao;
	

	@PostConstruct
	public void init() {
		novaProva = new Prova();
		provaDao = new ProvaDao();
		
		
		
	}

	public void salvarProva() throws SQLException {

		if (novaProva.getDescricao().equals("")) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("MensagensErro", new FacesMessage(
					"Informe a Descricao da Prova: "));
		} else if (novaProva.getDataProva() == null) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("MensagensErro", new FacesMessage(
					"Informe a data da Realização da Prova"));
		} else {
			int conseguiuSalvar = provaDao.inserirProva(novaProva);

			if (conseguiuSalvar != 0) {
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage("menssagesSucesso", new FacesMessage(
						"Prova Salva Com Sucesso"));
				novaProva = new Prova();
			} else {
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage("MensagensErro", new FacesMessage(
						"Prova não salva!"));
			}
		}
	}

	public Prova getNovaProva() {
		return novaProva;
	}

	public void setNovaProva(Prova novaProva) {
		this.novaProva = novaProva;
	}

	public ProvaDao getProvaDao() {
		return provaDao;
	}

	public void setProvaDao(ProvaDao provaDao) {
		this.provaDao = provaDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
