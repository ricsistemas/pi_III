package br.opet.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.opet.model.Grupos;
import br.opet.model.Produtos;

@ManagedBean
public class ControllerProdutos {

	public ControllerProdutos() {

	}

	public String salvar(Produtos prod) {

		if (prod.getId() == 0) {
			if (prod.insert()) {
				return "painel";
			} else
				return "null";
		}
		return "";

	}

	public String produtos() {
		return "produtos/listar.xhtml";

	}

	public String cadastrar() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("produtos", new Produtos());
		return "produtos/produtos.xhtml";
	}

	public ArrayList<Produtos> listar_produtos() {

		Produtos prod = new Produtos();
		return prod.listar();
	}

	public ArrayList<Grupos> listar_grupos() {

		Grupos grup = new Grupos();
		return grup.listar();
	}

}
