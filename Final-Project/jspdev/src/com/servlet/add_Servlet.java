package com.servlet;

import java.io.*;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.*;
import javax.servlet.http.*;

import com.DAO.DAO;
import com.bean.User;

public class add_Servlet extends HttpServlet {
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		
		Calendar c  =Calendar.getInstance();
		request.setAttribute("join_time",c.getInstance().getTime().toLocaleString());
		
		String nam  = request.getParameter("nam");
		String sex = request.getParameter("sex");
		String bir = request.getParameter("bir");
		String class_ = request.getParameter("cla");
		String qq = request.getParameter("qq");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String join_time = (String) request.getAttribute("join_time");
		String lik = request.getParameter("lik");
		String info = request.getParameter("info");
		
		
		User user = new User();
		
		user.setNam(nam);
		user.setSex(sex);
		user.setBir(bir);
		user.setClass_(class_);
		user.setQq(qq);
		user.setEmail(email);
		user.setTel(tel);
		user.setAddress(address);
		user.setJoin_time(join_time);
		user.setLik(lik);
		user.setInfo(info);
		
		
	
		DAO dao = new DAO(); 
		
		
		
		
		try 
		{
			dao.add(user);
			
			request.setAttribute("info",new String("<br><br><center><h1><font color=red>Success add "+nam+"!Conrgatulation!!" +
					"</font></h1></center><br>"));
			request.setAttribute("id", true);
			request.setAttribute("lgin", "<br><br><center><h1><font color=red>Sorry, Please Log in first!" +
					"</font></h1></center><br>");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		request.getRequestDispatcher("/info.jsp").forward(request,response);
	} 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		doPost(request,response);
	}
}
