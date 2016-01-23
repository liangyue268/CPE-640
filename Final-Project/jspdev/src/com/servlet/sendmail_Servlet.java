package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DAO;

public class sendmail_Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gbk");
		req.setCharacterEncoding("gbk");
		Calendar c  =Calendar.getInstance();
		req.setAttribute("join_time",c.getInstance().getTime().toLocaleString());
		String join_time = (String) req.getAttribute("join_time");
		String me=req.getParameter("me");
		String name = req.getParameter("name");
		String msg = req.getParameter("msg");
		DAO dao=new DAO();
		PrintWriter out = resp.getWriter();	
		if(dao.userinuse(name)){
			dao.writemessagetodb(me,name,msg,join_time);
			out.println(" Mail sending success!\r\n"); 
		}
		else{
		out.println(" Sorry the person you are mailing to dose not exist.\r\n");  
		}
	}

}
