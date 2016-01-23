package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DAO;
import com.bean.User;
import com.bean.addUserBean;

public class modi_Servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		
		String id =  request.getParameter("id");
		int idx = 0;
		if(id!=null)
		{
			idx = Integer.parseInt(id);
		}
		String name=request.getParameter("name");
		String sex = request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		addUserBean user = new addUserBean();
		
		user.setId(idx);
		user.setSex(sex);
		user.setAddress(address);
		user.setName(name);
		user.setAge(age);
		
		DAO dao = new DAO();
		
		dao.modi(user);
		
		response.sendRedirect("/jspDev/info1.jsp");
		
	}
	

}
