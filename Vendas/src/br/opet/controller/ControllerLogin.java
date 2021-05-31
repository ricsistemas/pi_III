package br.opet.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import br.opet.model.Usuarios;

@ManagedBean
@RequestScoped
public class ControllerLogin {
	private String email;
	private String senha;
	private String msg;

	public Boolean islogin() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (session != null);

	}

	public String ValidaLogin() {
		Usuarios user = new Usuarios();
		user.setEmail(email);
		user.setSenha(senha);
		if (user.ValidarLogin()) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("Usuario", email);
			return "painel";

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Email ou senha invalido", "Por favor tente Novamente"));
			return "login";

		}

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
