package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.*;
import com.bean.pageBean;

public class deta_Servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
			
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();	
		
		DAO dao = new DAO();
		pageBean page = new pageBean();
	
		String sql = "select count(*) from admin";
		int totalRows=(int) dao.getTotalRows(sql) ;
		page.setTotalRows(totalRows);
		
		int perPage = page.getPerPageRows();
		
		 
		int allPages ;
		
		if(totalRows%5==0)
		{
			allPages =(int) (totalRows/perPage); 
		}
		else
			allPages=(int) (totalRows/perPage+1);
		page.setAllPages(allPages);
	
		String per= request.getParameter("perPage");
		if(per==null)
		{
			int i = 1;
			page.setNowPage(i);
		}
		else
		page.setNowPage( Integer.parseInt(per));
		
		List results;
		String id = request.getParameter("id");
		int idx;
		if(id!=null)
		{
			idx = Integer.parseInt(id);
		    sql = "select * from admin where id= "+idx;
			results = dao.getInfo(sql);
			page.setResult(results);
			request.setAttribute("pageBean",page);
		
			request.getRequestDispatcher("/detailed.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		doGet(request,response);
	}

}
