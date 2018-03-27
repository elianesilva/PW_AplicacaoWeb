package br.com.primeiroprojeto.modelo;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.primeiroprojeto.dao.UsuarioDao;
import br.com.primeiroprojetopw.controlle.Usuario;

@RequestScoped
@ManagedBean(name= "usuarioBean")
public class UsuarioBean implements Serializable{
	
	UsuarioDao usuarioDao;
	private Usuario usuarioBusca;
	private Usuario usuario;
	
	@PostConstruct
	public void init(){
		usuarioDao = new UsuarioDao();
		usuarioBusca = new Usuario();
		usuario = new Usuario();
	}
	public String buscarUsuario(){
	
	try{
	usuario = usuarioDao.buscaUsuario(usuarioBusca.getMatricula(), usuarioBusca.getSenha());
	
	if(usuario != null){
		FacesContext context =FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.setAttribute("user", usuario);
		return "/inicio";
		
	}else{
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage("MensagensErro", new FacesMessage("usuário ou senha incorretos, tente novamente"));
	}
	}catch (Exception e){
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage("MensagensErro", new FacesMessage("Erro ao autenticar usuário"));
	}
	
	return null;
}
	public Usuario getUsuarioBusca(){
		return usuarioBusca;
	}
	public void setUsuarioBusca(Usuario usuarioBusca){
		this.usuarioBusca = usuarioBusca;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public UsuarioDao getUsuarioDao(){
		return usuarioDao;
	}
	public void setUsuarioDao(UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}
}
