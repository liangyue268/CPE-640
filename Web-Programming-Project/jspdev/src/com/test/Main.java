package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.DAO.DAO;
import com.bean.User;
import com.bean.addUserBean;

public class Main {
	
	public static void main(String args[]){
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

        System.out.println("Success");
       
        try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
        
        User  user = new User();
		user.setNam("dd");
		user.setPwd("ss");
		user.setSex("SSSS");
		user.setBir("11");
		user.setClass_("");
		user.setQq("ddd");
		user.setEmail("dddddd");
		user.setTel("dddddd");
		user.setAddress("dddddd");
		user.setJoin_time("dddddd");
		user.setLik("dddddd");
		user.setInfo("dddddd");
		
	
        
        DAO dao  = new DAO();
        
		try {
			dao.add(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}

}
