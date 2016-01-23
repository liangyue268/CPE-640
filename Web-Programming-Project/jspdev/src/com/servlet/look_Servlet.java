package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.*;
import com.bean.pageBean;

public class look_Servlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		
		DAO dao = new DAO();
		

		List list = null;
		list = dao.info(1);
		String show ="" ;
		for(int i = 0;i<list.size();i++){
			show += list.get(i);
			show += "  ";
		}
		
		request.setAttribute("info",new String("<br><br><center><h1><font color=red>" +
				"</font></h1></center><br>"));
		request.setAttribute("info",new String("<br><br><center><h1><font color=black>" +show+
				"</font></h1></center><br>"));
		request.setAttribute("id", new String("l"));
		request.getRequestDispatcher("/info.jsp").forward(request,response);
	} 
	
}
