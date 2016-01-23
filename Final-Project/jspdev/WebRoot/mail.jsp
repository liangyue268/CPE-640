
<%@ page language="java"  contentType="text/html;charset=gbk"%>

<html>
  <head>
   <title>Mail Box</title>
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
		String me=request.getParameter("aut");
  %>
  <body>
	<table width="300" height="50" border="0" align="center">
	
	<td width="110" background="/jspDev/img/red.jpg" align="center"><a href="/jspDev/sendmail.jsp?from=<%=me %>" target="frm" class="style10 "><font color=white>SEND</font></a></td>
	<td width="110" background="/jspDev/img/red.jpg" align="center"><a href="/jspDev/receivemail.jsp?from=<%=me %>" target="frm" class="style10 "><font color=white>INBOX</font></a></td>

	</table>
	</body>

</html>
