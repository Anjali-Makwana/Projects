package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmpConnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
		return con;
		
	}
}
