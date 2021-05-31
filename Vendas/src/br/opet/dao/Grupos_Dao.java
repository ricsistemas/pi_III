package br.opet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.opet.model.Base;
import br.opet.model.Grupos;

public class Grupos_Dao extends Base {

	protected boolean _insert(Grupos grup) {
		Connection conexao = null;
		PreparedStatement stmt = null;
		boolean insert = false;
		try {
			conexao = MeuDB.criaConexao(false);
			String sql = "insert into Grupos (descricao,isdelete) values(?,0)";
			stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, grup.getDescricao());
			stmt.executeUpdate();
			final ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				grup.setId(rs.getInt(1));
			}

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

	protected ArrayList<Grupos> _listar() {
		ArrayList<Grupos> lista = new ArrayList<Grupos>();

		Connection conexao = null;

		try {
			conexao = MeuDB.criaConexao(true);
			String query = "SELECT id, descricao from Grupos where isdelete =0";

			Statement st = conexao.createStatement();
			ResultSet Resultado = st.executeQuery(query);

			while (Resultado.next()) {
				Grupos grup = new Grupos();
				grup.setId(Resultado.getInt("id"));
				grup.setDescricao(Resultado.getString("descricao"));
				lista.add(grup);

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
