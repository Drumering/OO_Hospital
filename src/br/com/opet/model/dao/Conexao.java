package br.com.opet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConexao() {

		Connection conn = null;

		try {
			// 1 - Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2 - Propriedades da conexao
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Falha ao conectar com o Banco!");
		}

		return conn;
	}
}
