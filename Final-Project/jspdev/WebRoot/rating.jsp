<%@ page language="java" contentType="text/html;charset=gb2312" pageEncoding="gbk"%>
<html>
  <head>
  <title>ratingPage</title>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<style type="text/css">
	</style>
	</head>
	<body>
	<%
	response.setContentType("text/html;charset=gbk");
	request.setCharacterEncoding("gbk");
	String a=request.getParameter("fnam");
	%>
	<a href="/jspDev/servlet/rating_Servlet?value=1&fnam=<%=a %>" target="frm" class="style2 ">1</a>
	<img src="img/star.jpg"><br>
	<a href="/jspDev/servlet/rating_Servlet?value=2&fnam=<%=a %>" target="frm" class="style2 ">2</a>
	<img src="img/star.jpg">
	<img src="img/star.jpg"><br>
	<a href="/jspDev/servlet/rating_Servlet?value=3&fnam=<%=a %>" target="frm" class="style2 ">3</a>
	<img src="img/star.jpg">
	<img src="img/star.jpg">
	<img src="img/star.jpg"><br>
	<a href="/jspDev/servlet/rating_Servlet?value=4&fnam=<%=a %>" target="frm" class="style2 ">4</a>
	<img src="img/star.jpg">
	<img src="img/star.jpg">
	<img src="img/star.jpg">
	<img src="img/star.jpg"><br>
	<a href="/jspDev/servlet/rating_Servlet?value=5&fnam=<%=a %>" target="frm" class="style2 ">5</a>
	<img src="img/star.jpg">
	<img src="img/star.jpg">
	<img src="img/star.jpg">
	<img src="img/star.jpg">
	<img src="img/star.jpg"><br>
	</body>
	</html>