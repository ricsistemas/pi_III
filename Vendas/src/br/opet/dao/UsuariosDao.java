package br.opet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.opet.model.Base;
import br.opet.model.Usuarios;

public class UsuariosDao extends Base {

	protected boolean _inserirUsuario(Connection conexao, Usuarios u) {

		boolean insert = false;

		String sql = "insert into Usuarios (email,senha,isdelete ) values(?, ?, 0)";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, u.getEmail());
			stmt.setString(2, u.getSenha());
			stmt.executeUpdate();
			final ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				u.setId(rs.getInt(1));
				insert = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insert;

	}

	protected boolean _ValidarLogin(Usuarios user) {
		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet Resultado = null;
		boolean login = false;
		try {
			conexao = MeuDB.criaConexao(true);
			String sql = "SELECT id from Usuarios where email=? and senha =?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getSenha());
			Resultado = stmt.executeQuery();
			while (Resultado.next()) {
				login = true;
				user.setId(Resultado.getInt("id"));

			}
			stmt.close();
			conexao.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("Deu ruim aqui =>Got an exception! ");

		}

		return login;
	}

}
