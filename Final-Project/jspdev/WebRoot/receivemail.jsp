
<%@ page language="java"  contentType="text/html;charset=gbk"%>
<%@ page import="com.DAO.DAO"%>
<%@ page import="java.util.List"%>
<html>
  <head>
   <title>Receive Mail</title>
   <style type="text/css">
<!--
a:link {
	color: #FF0000;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #FF0000;
}
a:hover {
	text-decoration: none;
	color: #6600CC;
}
a:active {
	text-decoration: none;
	color: #33FF00;
}
.style10 {color: #FFFFFF}
--> 

    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk">
  </head>

  <% 
  		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		String me=request.getParameter("from");
		DAO dao=new DAO();
		List<String> result=dao.getmessage(me);
		for(String a:result){
  %>
  <br><textarea name="msg" rows="5" cols="200"><%=a %></textarea><br>
  <%} %>

	</body>
	

</html>
