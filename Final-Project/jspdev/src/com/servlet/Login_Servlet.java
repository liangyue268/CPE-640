package com.servlet;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.DAO.DAO;
import com.bean.User;

public class Login_Servlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		String from=request.getParameter("me");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		HttpSession session =request.getSession();
		session.setAttribute("name",name);
	
	
        User user = new User();
		
		user.setNam(name);
		user.setPwd(pwd);
		
		DAO dao = new DAO();
		int isLogin;
		try
		{
			isLogin = dao.login(user);
			
			if(isLogin>0)
			{
				request.setAttribute("aut", isLogin);
				request.getRequestDispatcher("/fram.jsp").forward(request, response);
			}else{	
				response.sendRedirect("/jspDev/index.jsp");
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		doPost(request,response);
	}
}
