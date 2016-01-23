package com.DAO;

import java.beans.Statement;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import com.bean.addUserBean;
import com.bean.pageBean;
import com.getDataBaseConn.GetConnection;

public class DAO {

		
	   
		private Connection conn;
		private PreparedStatement pstat;
		String sql="";
		
    public List info(int idx){
    	List users = null;
    	sql="Select * from admin where id = "+idx;
		conn= GetConnection.getConnection();
		try {
		pstat=conn.prepareStatement(sql);
		ResultSet rs =pstat.executeQuery();
		
		users = new ArrayList();
		
		while (rs.next())
		{
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int age=rs.getInt(4);
			String sex = rs.getString(5);
			String address=rs.getString(6);
			users.add(id);
			users.add(name);
			users.add(age);
			users.add(sex);
			users.add(address);
		} 
		rs.close();
		pstat.close();
		conn.close();
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return users;
    }
		
	public boolean add(User user) throws SQLException 
	{
		
		sql="insert into stu_info values(?,?,?,?,?,?,?,?,?,?,?,?)";
		conn= GetConnection.getConnection();
		int id = 0;
		boolean i = true ;
		try
			{
				
				String sqlGetMaxId="select max(idx) as id from stu_info";
				pstat=conn.prepareStatement(sqlGetMaxId);
				
				ResultSet rs =pstat.executeQuery();
				//ResultSet rs1 = pstat.executeQuery(sqlGetMaxId);
				if(rs.next()){
				id = rs.getInt(1)+1;
				}else{
				id = 0;
				}
               
				
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1,id);
				pstat.setString(2, user.getNam());
				pstat.setString(3, user.getSex());
				pstat.setString(4, user.getBir());
				pstat.setString(5, user.getClass_());
				pstat.setString(6, user.getQq());
				pstat.setString(7, user.getEmail());
				pstat.setString(8, user.getTel());
				pstat.setString(9, user.getAddress());
				pstat.setString(10, user.getJoin_time());
				pstat.setString(11, user.getLik());
				pstat.setString(12, user.getInfo());
				
				
				pstat.executeUpdate();
				pstat.close();
				conn.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace() ;
			}
		return i;
		
	}
	
	public int login(User user) throws SQLException 
	{
		conn= GetConnection.getConnection();
		
		int i = -1 ;
		System.out.println(conn.hashCode());
	
		sql = "select id from admin where nam=? and pwd=?";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, user.getNam());
		pstat.setString(2, user.getPwd());
		
		ResultSet rs1 = pstat.executeQuery();
		if (rs1.next())
		{
			i=rs1.getInt(1);
			rs1.close();
			pstat.close();
		}
		else 
		{
			i = -1 ;
			rs1.close();
			pstat.close();
		}
		conn.close();
		return i;
	}
	
	public int getTotalRows(String sql)
	{
		conn= GetConnection.getConnection();
		
		int i = 0; 
		try  
		{
			pstat = conn.prepareStatement(sql);
			ResultSet rs2 = pstat.executeQuery(); 
			rs2.next();
			i = rs2.getInt(1); 
			rs2.close();
			pstat.close();
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return i;
	}
	
	

	public List getInfo(pageBean page) 
	{
		int nowPage = page.getNowPage();  
		int perPageViwe = page.getPerPageRows();   
		
		int start = (nowPage - 1) * perPageViwe;     
		int maxResults = perPageViwe;    
		
		List users = null; 
		
		conn= GetConnection.getConnection();
		if (start >1)
		{
			sql = "select top "+maxResults+" * from admin  where " +
					"id not in (select top "+start+" id from admin) order by id";
		}
		else 
		{
			sql ="select top "+maxResults+" * from admin  order by id";
		}
		try {
			pstat=conn.prepareStatement(sql);
			ResultSet rs =pstat.executeQuery();
			
			users = new ArrayList();
			
			while (rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(5);
				int age = rs.getInt(4);
				String address = rs.getString(6);
				
				addUserBean user = new addUserBean();    
				
				user.setId(id);
				user.setName(name);
				user.setSex(sex);
				user.setAge(age);
				user.setAddress(address);
				
				users.add(user);
			} 
			rs.close();
			pstat.close();
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return users;
	}
	
	
	
	public void delete(int idx)
	{
		sql = "delete from admin where id = "+idx;
		conn = GetConnection.getConnection();
		try 
		{
			pstat = conn.prepareStatement(sql);
			pstat.executeUpdate(); 
			pstat.close();
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public List getInfo(String sql)
	{
		List users = null; 
		conn= GetConnection.getConnection();
		try 
		{
			pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			rs.next();
			
			users = new ArrayList();
			
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String sex = rs.getString(5);
			String address = rs.getString(6);
			int age=rs.getInt(4);
			
			addUserBean user = new addUserBean();    
			
			user.setId(id);
			user.setName(name);
			user.setSex(sex);
			user.setAge(age);
			user.setAddress(address);
			
			users.add(user);
			rs.close();
			pstat.close();
			conn.close();
		} 
		catch 
		(SQLException e) 
		{
			e.printStackTrace();
		}
		return users;
	}
	
	public void modi(addUserBean user)  
	{
		sql ="update admin set nam=?,age=?,sex=?,address=? where id =?";
		conn = GetConnection.getConnection();
		try 
		{
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getName());
			pstat.setInt(2, user.getAge());
			pstat.setString(3, user.getSex());
			pstat.setString(4,user.getAddress());
			pstat.setInt(5, user.getId());
			pstat.executeUpdate(); 
			pstat.close();
			conn.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public List getInfo1(pageBean page,String sql) 
	{
		
		List users = null; 
		
		conn= GetConnection.getConnection();
		
		try {
		
			pstat=conn.prepareStatement(sql);
			
			ResultSet rs =pstat.executeQuery();
			
			users = new ArrayList();
			
			while (rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(4);
				String sex = rs.getString(5);
				String address = rs.getString(6);
				
				addUserBean user = new addUserBean();  
				user.setId(id);
				user.setName(name);
				user.setSex(sex);
				user.setAge(age);
				user.setAddress(address);
				
				users.add(user);
			} 
			rs.close();
			pstat.close();
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return users;
	}
	public boolean addUser(addUserBean user) 
	{
		int id = 0;
		sql ="insert into admin values (?,?,?,?,?,?)";
		conn = GetConnection.getConnection();
		boolean addstr=false;
		try 
		{
			String sqlGetMaxId="select max(id) as id from admin";
            pstat=conn.prepareStatement(sqlGetMaxId);
			
			ResultSet rs =pstat.executeQuery();
			//ResultSet rs1 = pstat.executeQuery(sqlGetMaxId);
			if(rs.next()){
			id = rs.getInt("id")+1;
			}else{
			id = 0;
			}
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1,id);
			pstat.setString(2,user.getName());
			pstat.setString(3,user.getPwd());
			pstat.setInt(4,user.getAge());
			pstat.setString(5,user.getSex());
			pstat.setString(6,user.getAddress());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			addstr=true;
			rs.close();
			pstat.close();
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return addstr;
	}
	public boolean userinuse(String uname){
		boolean result=false;
		String sql="select nam from admin where nam=?";
		conn = GetConnection.getConnection();
		try {
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, uname);
			ResultSet rs=pstat.executeQuery();
			if(rs.next())
				result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public void addFiletodb(String fname){
		String sql="insert into rates(fname,rate,num) values(?,0,0)";
		conn=GetConnection.getConnection();
		try{
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, fname);
			pstat.executeUpdate();
			pstat.close();
			conn.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<String> gettopten(){
		sql="select * from rates order by rate desc limit 10";
		conn=GetConnection.getConnection();
		List<String> result=new ArrayList<String>();
		try{
			pstat=conn.prepareStatement(sql);
			ResultSet rs=pstat.executeQuery();
			while(rs.next()){
				result.add(""+rs.getDouble(2));
				result.add(rs.getString(4));
			}
			rs.close();
			pstat.close();
			conn.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public void giverate(String fnam,int rate){
		sql="select * from rates where fname=?";
		conn=GetConnection.getConnection();
		double currentrate = 0;
		int currentnum = 0;
		try{
			pstat=conn.prepareStatement(sql);
			pstat.setString(1,fnam);
			ResultSet rs=pstat.executeQuery();
			if(rs.next()){
			currentrate=rs.getDouble(2);
			currentnum=rs.getInt(3);
			currentnum++;
			currentrate=(currentrate*(currentnum-1)+rate)/currentnum;
			System.out.println(currentnum+" "+currentrate);
			}
			sql="update rates set rate=? where fname=?";
			pstat.close();
			pstat=conn.prepareStatement(sql);
			pstat.setString(2,fnam);
			pstat.setDouble(1, currentrate);
			pstat.executeUpdate();
			sql="update rates set num=? where fname=?";
			pstat.close();
			pstat=conn.prepareStatement(sql);
			pstat.setString(2,fnam);
			pstat.setInt(1, currentnum);
			pstat.executeUpdate();
			rs.close();
			pstat.close();
			conn.close();
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writemessagetodb(String from,String to,String msg,String time){
		sql="insert into message(fromu,tou,mesg,stime) values(?,?,?,?)";
		conn=GetConnection.getConnection();
		try {
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, from);
			pstat.setString(2, to);
			pstat.setString(3, msg);
			pstat.setString(4, time);
			pstat.executeUpdate();
			pstat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<String> getmessage(String receiver){
		sql="select * from message where tou=?";
		conn=GetConnection.getConnection();
		List<String> result=new ArrayList<String>();
		try {
			pstat=conn.prepareStatement(sql);
			pstat.setString(1,receiver);
			ResultSet rs=pstat.executeQuery();
			while(rs.next()){
				String tmp="Time:"+rs.getString(5)+"\nFrom: "+rs.getString(2)+"\nMessage:\n"+rs.getString(4)+"\n";
				tmp.replaceAll("\n", "<br>");
				result.add(tmp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}

	
