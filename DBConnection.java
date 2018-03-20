package utils;

import java.sql.*;

public class DBConnection {
	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/Evil_Proof";
		String username = "root";
		String password = "Spacial-rend4";
		{

			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");// loading mysql driver

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				con = DriverManager.getConnection(url, username, password);// attemting to connect to MySQL database
				System.out.println("Printing connection object" + con);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
	}
}
