package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DAO;
import com.bean.User;

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
		String sex = request.getParameter("sex");
		String bir = request.getParameter("bir");
		String class_ = request.getParameter("class_");
		String qq = request.getParameter("qq");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String like = request.getParameter("like");
		String info = request.getParameter("info");
		
		User user = new  User();
		
		user.setIdx(idx);
		user.setSex(sex);
		user.setBir(bir);
		user.setClass_(class_);
		user.setQq(qq);
		user.setEmail(email);
		user.setTel(tel);
		user.setAddress(address);
		user.setLik(like);
		user.setInfo(info);
		
		DAO dao = new DAO();
		
		dao.modi(user);
		
		response.sendRedirect("/jspDev/info1.jsp");
		
	}
	

}
