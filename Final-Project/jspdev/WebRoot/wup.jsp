<%@ page language="java" contentType="text/html;charset=gb2312"%>
<%@ page import="java.io.File"%>
<html>
  <head>
   <title>showfilesPage</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<style type="text/css">
	<!--
a:link {
	color: #FFFFFF;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #FFFFFF;
}
a:hover {
	text-decoration: none;
	color: #FFFFFF;
}
a:active {
	text-decoration: none;
	color: #FFFFFF;
}
body {
	background-image: url(/jspDev/img/white.jpg);
}
.style2 {font-family: "Arial" }
.style4 {font-family: "Arial"; color: #FFFFFF; }

-->
	</style>
	</head>
	<body>
  <%
  int me=(Integer)session.getAttribute("user");
  %>
	<table width="300" height="50" border="0" align="center">
	<td width="110"  background="/jspDev/img/red.jpg" align="center"><a href="/jspDev/upload.jsp" target="frm" class="style2">PUBLIC</a></td>
	<td width="110"  background="/jspDev/img/red.jpg" align="center"><a href="/jspDev/pupload.jsp?user=<%=me %>>" target="frm" class="style2">PRIVATE</a></td>
	</table>
	</body>
	</html>