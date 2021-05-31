package br.opet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.opet.model.Base;
import br.opet.model.Pedidos;

public class PedidosDao extends Base {
	protected boolean _inserir(Pedidos ped) {
		Connection conexao = null;
		PreparedStatement stmt = null;
		boolean insert = false;
		try {
			conexao = MeuDB.criaConexao(false);
			String sql = "insert into Produtos (grupo_id,descricao,qtd,custo,preco,isdelete) values(?,?,?,?,?,0)";
			stmt = conexao.prepareStatement(sql);
			// stmt.setInt(1, prod.getGrupo().getId());
			// stmt.setString(2, prod.getDescricao());
			// stmt.setInt(3, prod.getQtd());
			// stmt.setDouble(4, prod.getCusto());
			// stmt.setDouble(5, prod.getPreco());
			stmt.executeUpdate();
			conexao.commit();
			insert = true;

		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("** Cancelado erro **");
		}

		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insert;

	}

}
