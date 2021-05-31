package br.opet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MeuDB {
	public static Connection criaConexao(boolean Autocommit) {
		Connection conexao = null;
		String myDriver = "com.mysql.cj.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost/shop?serverTimezone=UTC&useSSL=false&requireSSL=false";
		String usuario = "app_user";
		String senha = "adm102030";

		try {
			Class.forName(myDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conexao = DriverManager.getConnection(myUrl, usuario, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conexao.setAutoCommit(Autocommit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexao;

	}

}
