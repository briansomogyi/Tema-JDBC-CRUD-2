package ro.emanuel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseHelper {
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if(connection == null || connection.isClosed()) {
			Properties connectionProperties = new Properties();
			connectionProperties.put("user", "root");
			connectionProperties.put("password", "");
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/oop2024", 
					connectionProperties);
		}
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		if(connection != null && !connection.isClosed())
			connection.close();
	}
	
}