package br.opet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.opet.model.Enderecos;

public class EnderecosDao {

	protected boolean _inserirEnd(Connection conexao, Enderecos e) {

		boolean insert = false;

		String sql = "insert into Enderecos (cliente_id, Cep, logradouro, numero,Estado, " + "Cidade, " + "Bairro, "
				+ "Complemento, " + "Local_Descricao, " + "Principal, " + " isdelete) "
				+ "values(?,?,?,?,?,?,?,?,?,1,0)";

		PreparedStatement stmt = null;

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, e.getCliente_id());
			stmt.setString(2, e.getCep());
			stmt.setString(3, e.getLogradouro());
			stmt.setInt(4, e.getNumero());
			stmt.setString(5, e.getEstado());
			stmt.setString(6, e.getCidade());
			stmt.setString(7, e.getBairro());
			stmt.setString(8, e.getCompl());
			stmt.setString(9, e.getLocal());
			stmt.executeUpdate();
			insert = true;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			stmt.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		return insert;

	}

}
