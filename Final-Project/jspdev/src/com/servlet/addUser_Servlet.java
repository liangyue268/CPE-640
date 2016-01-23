package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DAO;
import com.bean.addUserBean;

public class addUser_Servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		
		String name = request.getParameter("name");
		
		String pwd = request.getParameter("pwd");
		
		String age1 = request.getParameter("age");
		
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		DAO dao  = new DAO();
		boolean nvalid=dao.userinuse(name);
		boolean cond=false;
		if(!nvalid){
		addUserBean  user = new addUserBean();
		user.setName(name);
		user.setPwd(pwd);
		user.setSex(sex);
		int age;
		if(age1!=null)
		{
			age = Integer.parseInt(age1);
			user.setAge(age);
		}
		user.setAddress(address);
		cond=dao.addUser(user);
		request.setAttribute("info",new String("<br><br><center><h1><font color=red>Success!!Congratulation!!" +
		"</font></h1></center><br>"));
		request.setAttribute("id", cond);
		}
		else{
		request.setAttribute("info",new String("<br><br><center><h1><font color=red>This username already in used!" +
				"</font></h1></center><br>"));
		request.setAttribute("id", !cond);
		}
		request.setAttribute("lgin",new String("<br><br><center><a href = /jspDev/index.jsp target =_parent>"
				+ "Login</href></center><br>"));
		request.getRequestDispatcher("/info.jsp").forward(request,response);
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		doPost(request,response);
	}
}
