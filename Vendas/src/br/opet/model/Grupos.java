package br.opet.model;

import javax.faces.bean.ManagedBean;

import br.opet.dao.Grupos_Dao;

@ManagedBean
public class Grupos extends Grupos_Dao {
	private int id;
	private String Descricao;

	public boolean Insert() {
		return super._insert(this);

	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.ArrayList<Grupos> listar() {
		return super._listar();
	}

}
