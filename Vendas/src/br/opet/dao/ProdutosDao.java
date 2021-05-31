package br.opet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.opet.model.Base;
import br.opet.model.Grupos;
import br.opet.model.Produtos;

public class ProdutosDao extends Base {
	protected boolean _inserir(Produtos prod) {
		Connection conexao = null;
		PreparedStatement stmt = null;
		boolean insert = false;
		try {
			conexao = MeuDB.criaConexao(false);
			String sql = "insert into Produtos (grupo_id,descricao,qtd,custo,preco,isdelete) values(?,?,?,?,?,0)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, prod.getGrupo().getId());
			stmt.setString(2, prod.getDescricao());
			stmt.setInt(3, prod.getQtd());
			stmt.setDouble(4, prod.getCusto());
			stmt.setDouble(5, prod.getPreco());
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

	public ArrayList<Produtos> listar() {
		ArrayList<Produtos> lista = new ArrayList<Produtos>();

		Connection conexao = null;

		try {
			conexao = MeuDB.criaConexao(true);
			String query = "SELECT id, descricao,custo, preco   from Produtos where isdelete =0";

			Statement st = conexao.createStatement();
			ResultSet Resultado = st.executeQuery(query);

			while (Resultado.next()) {
				Produtos prod = new Produtos();
				prod.setId(Resultado.getInt("id"));
				prod.setDescricao(Resultado.getString("descricao"));
				prod.setCusto(Resultado.getDouble("custo"));
				prod.setPreco(Resultado.getDouble("preco"));

				lista.add(prod);

			}
			st.close();
			Resultado.close();
			conexao.close();

		} catch (Exception e) {
			System.err.println("Deu ruim aqui =>Got an exception! ");
			System.err.println(e.getMessage());

			return null;
		}
		return lista;
	}
}
