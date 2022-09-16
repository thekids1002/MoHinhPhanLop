package DAL;

import java.util.logging.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDataBaseManager {
	private Connection c;
	private Statement s;
	private PreparedStatement p;
	private String host, port, dbName, dbUser, dbPassword;

	public MyDataBaseManager() {
		super();
		host = "localhost";
		port = "3306";
		dbUser = "root";
		dbName = "school2";
		dbPassword = "";
	}

	public void connectDB() {
		String dbPath = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
		try {
			c = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
			s = c.createStatement();
			System.out.print("Connected");
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
	}

	public ResultSet doReadQuery(String sql) {
		ResultSet rs = null;
		try {
			rs = s.executeQuery(sql);
		} catch (SQLException ex) {
			Logger.getLogger(MyDataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return rs;
	}

	public void doUpdateQuery() {
		try {
			p.executeUpdate();
		} catch (Exception ex) {
			Logger.getLogger(MyDataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
