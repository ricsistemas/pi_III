package br.opet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.opet.model.Base;
import br.opet.model.Clientes;

public class ClientesDao extends Base {

	public ClientesDao() {
	}

	protected boolean _inserir(Clientes cli) {
		Connection conexao = null;
		PreparedStatement stmt = null;
		boolean insert = false;
		try {

			conexao = MeuDB.criaConexao(false);
			insert = cli.getLogin().inserirUsuario(conexao, cli.getLogin());
			if (!insert) {
				conexao.rollback();
				return false;
			}

			String sql = "insert into Clientes (usuario_id, nome_completo,genero,cpf,rg,celular,telefone,dt_nascimento,isdelete) "
					+ " values(?,?,?,?,?,?,?,?,0)";
			stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, cli.getLogin().getId());
			stmt.setString(2, cli.getNome_completo());
			stmt.setLong(3, cli.getGenero());
			stmt.setString(4, cli.getCpf());
			stmt.setString(5, cli.getRg());
			stmt.setString(6, cli.getCelular());
			stmt.setString(7, cli.getTelefone());
			stmt.setDate(8, cli.getDt_nascimento());
			stmt.executeUpdate();
			conexao.commit();
			final ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				cli.getEndereco().setCliente_id(rs.getInt(1));
			}

			if (cli.getEndereco().inserirEnd(conexao, cli.getEndereco())) {
				insert = true;
				conexao.commit();
			} else {
				conexao.rollback();
			}

		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
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
