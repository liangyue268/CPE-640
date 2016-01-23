package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.DAO.DAO;

public class delete_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String id = request.getParameter("id");
		String nowPage = request.getParameter("perPage");
		if (id!=null)
		{
			int idx = Integer.parseInt(id);
			DAO dao = new DAO();
			dao.delete(idx);
		}
		request.getRequestDispatcher("/servlet/look_Servlet").forward(request, response);
	}

}
