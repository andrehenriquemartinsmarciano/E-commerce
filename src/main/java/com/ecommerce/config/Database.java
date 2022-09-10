package com.ecommerce.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {

	public class fabricaConexao {

		public Connection conecta() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/paraleloF", "root", "99210361");

			} catch (ClassNotFoundException | SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}
}
