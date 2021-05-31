package br.opet.model;

import java.sql.Connection;

import br.opet.dao.UsuariosDao;

public class Usuarios extends UsuariosDao {
	private int id;
	private String senha;
	private String email;

	public Usuarios(String login, String senha) {
		this.email = login;
		this.senha = senha;

	}

	public Usuarios() {
	}

	public boolean insert() {

		return false;

//	return super._inserir(this);	

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean ValidarLogin() {
		return super._ValidarLogin(this);

	}

	public boolean inserirUsuario(Connection conexao, Usuarios login) {
		return super._inserirUsuario(conexao, login);

	}

}
