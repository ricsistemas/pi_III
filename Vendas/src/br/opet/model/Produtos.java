package br.opet.model;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import br.opet.dao.ProdutosDao;

public class Produtos extends ProdutosDao {
	private int id;
	private Grupos grupo;
	private String Descricao;
	private int Qtd;
	private Double custo;
	private Double preco;

	public Produtos() {
		grupo = new Grupos();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Grupos getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupos grupo) {
		this.grupo = grupo;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return Qtd;
	}

	public void setQtd(int qtd) {
		Qtd = qtd;
	}

	public boolean insert() {
		return super._inserir(this);

	}

	public ArrayList<Produtos> listar() {
		return super.listar();
	}

}
