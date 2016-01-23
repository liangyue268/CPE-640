package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
	
public static void main(String[] args){
	Connection conn = null;
    String sql;
    
    String url = "jdbc:mysql://localhost:3306/jspdev?"
            + "user=root&password=920827&useUnicode=true&characterEncoding=UTF8";
    try {
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("OKKKKKK");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    try {
		conn = DriverManager.getConnection(url);
		System.out.println("OKKKKKK");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	//return conn;

}

}
