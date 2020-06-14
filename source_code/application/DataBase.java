package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	
	private static final DataBase instance = new DataBase();
	private Connection connection;
	
	private DataBase()
	{
		connect();
	}
	
	public static DataBase getInstance()
	{
		return instance;
	}
	
	private void connect() {
        connection = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:DB\\game.db";
            // create a connection to the database
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
	
	public Statement createStatement() throws SQLException {
		return connection.createStatement();
	}
	
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}
	
}
