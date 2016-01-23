
<%@ page language="java"  contentType="text/html;charset=gbk"%>

<html>
  <head>
   <title>My JSP 'info.jsp' starting page</title>
  </head>
  
  <% 
  		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
  %>
  
 <body background="../img/white.jpg">
  <%=
  	request.getAttribute("info")
  %>
  <br>
  <%
  	boolean idx = (Boolean)request.getAttribute("id");
  	if (idx)
  	{
  %>
  
  <br>
 
  <center><a href="/jspDev/addUser.jsp"> <h2>Continue add</h2></a><br><br><br><br>
  <a href="/jspDev/index.jsp"> <h2>Back to Login</h2></a><br><br><br><br>
  <%} else {
  if(request.getAttribute("lgin")!=null){%>
  <a>Fail to process.</a>
   <%=request.getAttribute("lgin")%>
   <%} }%>
  

  </center>
  </body>
</html>
