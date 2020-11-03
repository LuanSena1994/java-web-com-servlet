package br.com.cadastroalunos.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/db_alunos?serverTimezone=UTC";
	final String USER = "root";
	final String PASSWORD = "1994";

	public Connection getConnection() throws SQLException{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager
				.getConnection(URL, USER, PASSWORD);

	}


}
