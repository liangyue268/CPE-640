package com.test;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.servlet.upload_Servlet;
public class uploadtest {
	public static void main(String args[]){
	upload_Servlet a=new upload_Servlet();
	try {
		a.init(new ServletConfig(){

			@Override
			public String getInitParameter(String arg0) {
				return null;
			}

			@Override
			public Enumeration<String> getInitParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getServletName() {
				// TODO Auto-generated method stub
				return null;
			}});
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
