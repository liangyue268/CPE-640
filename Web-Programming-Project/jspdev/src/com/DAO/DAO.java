package com.DAO;

import java.beans.Statement;
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
    	sql="Select * from stu_info where idx = "+idx;
		conn= GetConnection.getConnection();
		try {
		pstat=conn.prepareStatement(sql);
		ResultSet rs =pstat.executeQuery();
		
		users = new ArrayList();
		
		while (rs.next())
		{
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String sex = rs.getString(3);
			String bir = rs.getString(4);
			String class_ = rs.getString(5);
			String qq = rs.getString(6);
			String email = rs.getString(7);
			String tel = rs.getString(8);
			String address = rs.getString(9);
			String join_time = rs.getString(10);
			String lik = rs.getString(11);
			String info = rs.getString(12);
			
			users.add(id);
			users.add(name);
			users.add(sex);
			users.add(bir);
			users.add(class_);
			users.add(qq);
			users.add(email);
			users.add(tel);
			users.add(address);
			users.add(lik);
			
			
			
			
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
	
	public boolean login(User user) throws SQLException 
	{
		conn= GetConnection.getConnection();
		
		boolean i = false ;
		
	
		sql = "select nam from admin where nam=? and pwd=?";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, user.getNam());
		pstat.setString(2, user.getPwd());
		
		ResultSet rs1 = pstat.executeQuery();
		if (rs1.next())
		{
			i = true;
			rs1.close();
			pstat.close();
		}
		else 
		{
			i = false ;
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
			sql = "select top "+maxResults+" * from stu_info  where " +
					"idx not in (select top "+start+" idx from stu_info) order by idx";
		}
		else 
		{
			sql ="select top "+maxResults+" * from stu_info  order by idx";
		}
		try {
			pstat=conn.prepareStatement(sql);
			ResultSet rs =pstat.executeQuery();
			
			users = new ArrayList();
			
			while (rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String bir = rs.getString(4);
				String class_ = rs.getString(5);
				String qq = rs.getString(6);
				String email = rs.getString(7);
				String tel = rs.getString(8);
				String address = rs.getString(9);
				String join_time = rs.getString(10);
				String lik = rs.getString(11);
				String info = rs.getString(12);
				
				User user = new User();    
				
				user.setIdx(id);
				user.setNam(name);
				user.setSex(sex);
				user.setBir(bir);
				user.setClass_(class_);
				user.setQq(qq);
				user.setEmail(email);
				user.setTel(tel);
				user.setJoin_time(join_time);
				user.setLik(lik);
				user.setInfo(info);
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
		sql = "delete from stu_info where idx = "+idx;
		conn = GetConnection.getConnection();
		try 
		{
			pstat = conn.prepareStatement(sql);
			int rs = pstat.executeUpdate(); 
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
			String sex = rs.getString(3);
			String bir = rs.getString(4);
			String class_ = rs.getString(5);
			String qq = rs.getString(6);
			String email = rs.getString(7);
			String tel = rs.getString(8);
			String address = rs.getString(9);
			String join_time = rs.getString(10);
			String lik = rs.getString(11);
			String info = rs.getString(12);
			
			User user = new User();    
			
			user.setIdx(id);
			user.setNam(name);
			user.setSex(sex);
			user.setBir(bir);
			user.setClass_(class_);
			user.setQq(qq);
			user.setEmail(email);
			user.setTel(tel);
			user.setJoin_time(join_time);
			user.setLik(lik);
			user.setInfo(info);
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
	
	public void modi(User user)  
	{
		sql ="update stu_info set sex=?,bir=?,class=?,qq=?,email=?,tel=?,address=?,lik=?,info=? where idx =?";
		conn = GetConnection.getConnection();
		try 
		{
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getSex());
			pstat.setString(2, user.getBir());
			pstat.setString(3, user.getClass_());
			pstat.setString(4, user.getQq());
			pstat.setString(5, user.getEmail());
			pstat.setString(6, user.getTel());
			pstat.setString(7, user.getAddress());
			pstat.setString(8, user.getLik());
			pstat.setString(9, user.getInfo());
			pstat.setInt(10, user.getIdx());
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
				String sex = rs.getString(3);
				String bir = rs.getString(4);
				String class_ = rs.getString(5);
				String qq = rs.getString(6);
				String email = rs.getString(7);
				String tel = rs.getString(8);
				String address = rs.getString(9);
				String join_time = rs.getString(10);
				String lik = rs.getString(11);
				String info = rs.getString(12);
				
				User user = new User();  
				user.setIdx(id);
				user.setNam(name);
				user.setSex(sex);
				user.setBir(bir);
				user.setClass_(class_);
				user.setQq(qq);
				user.setEmail(email);
				user.setTel(tel);
				user.setJoin_time(join_time);
				user.setLik(lik);
				user.setInfo(info);
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
	public void addUser(addUserBean user) 
	{int id = 0;
		sql ="insert into admin values (?,?,?,?,?,?)";
		conn = GetConnection.getConnection();
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
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}

	
