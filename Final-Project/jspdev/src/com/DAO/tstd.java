package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.getDataBaseConn.GetConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class tstd {
public static void main(String args[]){
	  DAO scheck=new DAO();
	  /*List<String> list;
	  list=scheck.gettopten();
	  for(int i=0;i<list.size();i++){
		  System.out.println(list.get(i));
	  }*/
	  scheck.giverate(".classpath", 1);
}
}
