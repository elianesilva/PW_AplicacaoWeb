package br.com.primeiroprojetopw.controlle;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="inicioBean")
@RequestScoped
public class InicioBean implements Serializable {
	
	private static final long serialVersionUID =1L;
	Usuario usuarioLogado;
	
	@PostConstruct
	public void init(){
		usuarioLogado = new Usuario();
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		usuarioLogado = (Usuario) session.getAttribute("user");
		
	}
		public Usuario getUsuarioLogado(){
			return usuarioLogado;
		}
		
		public void setUsuarioLogado(Usuario usuarioLogado) {
			this.usuarioLogado = usuarioLogado;
		}
		
		public String Logout(){
			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
			session.removeAttribute("usuario");
			return "/index";
		}
		
		

}
