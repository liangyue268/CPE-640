
<%@ page language="java"  contentType="text/html;charset=gbk"%>

<html>
  <head>
   <title>My JSP 'info.jsp' starting page</title>
  </head>
  
  <% 
  		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
  %>
  
 <body background="../img/background.jpg">
  <%=
  	request.getAttribute("info")
  %>
  
  <br>
  <%
  	String idx = (String)request.getAttribute("id");
  	if (idx.equals("l"))
  	{
  %>
  
  <br>
 
  <center><a href="/jspDev/add.jsp"> <h2>Continue add</h2></a><br><br><br><br>
  <%} else {%> <%= request.getAttribute("denglu")%><%} %>
  
 <center> <a href="/jspDev/servlet/look_Servlet" target="frm">Show all the information</a></center><br>
  </center>
  </body>
</html>
