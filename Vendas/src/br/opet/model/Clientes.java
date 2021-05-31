package br.opet.model;

import java.sql.Date;

import br.opet.dao.ClientesDao;

public class Clientes extends ClientesDao {
	private String nome_completo;
	private char genero;
	private String cpf;
	private String rg;
	private String celular;
	private String telefone;
	private Date dt_nascimento;
	private Usuarios login;
	private Enderecos endereco;

	public Clientes() {
		login = new Usuarios();

		endereco = new Enderecos();
	}

	public boolean inserir() {

		return super._inserir(this);

	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public Usuarios getLogin() {
		return login;
	}

	public void setLogin(Usuarios login) {
		this.login = login;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

}
