package com.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.S3conn.S3delete;

public class deletef_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException
			{
		   doPost(request,response);
			}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		int dstloca=Integer.parseInt(request.getParameter("req"));
        String filename = request.getParameter("name");
        S3delete deletes3=new S3delete();
        deletes3.delete(filename, dstloca);
			}
}
