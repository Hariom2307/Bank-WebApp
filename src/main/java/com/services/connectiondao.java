package com.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectiondao {
	
	public Connection Myconnection() {
		Connection con=null;
		
		try {
			Class.forName("oracle.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","123456789");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;
		
		
	}

}
