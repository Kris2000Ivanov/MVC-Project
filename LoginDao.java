package dao;

import java.sql.*;

import models.Bean;
import utils.DBConnection;
import conntorllers.LoginController;

public class LoginDao {
	public Bean authenticateUser(String username,String password) {
	//	String userName = loginBean.getUsername();
		//String password = loginBean.getPassword();

		Connection con = null;
		Bean bean=null;
		PreparedStatement pc= null;
		ResultSet resultSet = null;

	//	String userNameDB = "";
		//String passwordDB = "";

		try {
			con = DBConnection.createConnection();
			pc = (PreparedStatement) con.createStatement();
			resultSet = pc.executeQuery("SELECT * FROM User WHERE username="+"?"+" AND password="+"?"+"");
            pc.setString(1, username);
			pc.setString(2, password);
			while (resultSet.next()) {
			
				bean.setUsername(resultSet.getString("userName"));
				bean.setPassword(resultSet.getString("password"));

				if (username.equals(resultSet.getString(username)) && password.equals(resultSet.getString(password)))
					return bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
