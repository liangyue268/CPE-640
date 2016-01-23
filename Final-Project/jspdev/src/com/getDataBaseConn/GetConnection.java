package com.getDataBaseConn;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;


public class GetConnection {
	public static Connection getConnection(){
		
		Connection conn = null;
        String sql;
        
        String url = "jdbc:mysql://localhost:3306/jspdev?"
                + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return conn;
	}
	
}