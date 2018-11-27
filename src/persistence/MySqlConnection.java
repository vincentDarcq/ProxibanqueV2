package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe permettant l'intéraction avec la BDD
 * @author Adminl
 *
 */
public class MySqlConnection {

	private static MySqlConnection INSTANCE = new MySqlConnection();
	
	public static MySqlConnection getInstance() {
		return MySqlConnection.INSTANCE;
	}
	
	private Connection conn;
	
	/**
	 * Méthode permettant la connection à MySQL Workbench
	 */
	public MySqlConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanque2vb?serverTimezone=Europe/Paris", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
}