package br.opet.model;

import java.sql.Date;

import br.opet.dao.PedidosDao;

public class Pedidos extends PedidosDao {
	private Clientes clientes;
	private Date dt_pedido;
	private Date dt_entrega;
	private int status;
	private Date dt_baixa;
	private int baixa;
	private Double vl_pedido;
	private String form_pag;

	public Pedidos() {

		clientes = new Clientes();

	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Date getDt_pedido() {
		return dt_pedido;
	}

	public void setDt_pedido(Date dt_pedido) {
		this.dt_pedido = dt_pedido;
	}

	public Date getDt_entrega() {
		return dt_entrega;
	}

	public void setDt_entrega(Date dt_entrega) {
		this.dt_entrega = dt_entrega;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDt_baixa() {
		return dt_baixa;
	}

	public void setDt_baixa(Date dt_baixa) {
		this.dt_baixa = dt_baixa;
	}

	public int getBaixa() {
		return baixa;
	}

	public void setBaixa(int baixa) {
		this.baixa = baixa;
	}

	public Double getVl_pedido() {
		return vl_pedido;
	}

	public void setVl_pedido(Double vl_pedido) {
		this.vl_pedido = vl_pedido;
	}

	public String getForm_pag() {
		return form_pag;
	}

	public void setForm_pag(String form_pag) {
		this.form_pag = form_pag;
	}

}
