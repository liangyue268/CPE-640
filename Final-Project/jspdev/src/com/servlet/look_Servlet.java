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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		
		int me=Integer.parseInt(request.getParameter("name"));
		DAO dao = new DAO();

		List list = null;
		String sql = "select count(*) from admin";
		int totalRows=(int) dao.getTotalRows(sql) ;
		String show ="" ;
		list = dao.info(me);
		String[] tex={"Name: ","Age: ","Sex: ","Address: "};
		for(int i = 1;i<list.size();i++){
			show += tex[i-1]+list.get(i);
			show += "\n<br>";
		}
		//request.setAttribute("info",new String("<br><br><center><h1><font color=red>" + "</font></h1></center><br>"));
		request.setAttribute("info",new String("<br><br><center><h1><font color=black>" +show+
				"</font></h1></center><br>"));
		request.setAttribute("id", false);
		request.getRequestDispatcher("/info.jsp").forward(request,response);
	
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
doPost(request,response);}
}
