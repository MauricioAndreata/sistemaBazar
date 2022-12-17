package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection
					("jdbc:mysql://localhost/bazararmariofashion?useTimezone=true&serverTimezone=UTC","root","");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Não conectou: o erro segue descrito abaixo:");
			throw new RuntimeException(e);
		}
		
	}
}
