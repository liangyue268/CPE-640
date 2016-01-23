
<%@ page language="java" contentType="text/html;charset=gb2312"%>
<html>
  <head>
   <title>homePage</title>
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
	background-image: url(img/background.jpg);
}
.style2 {font-family: "Arial" }
.style4 {font-family: "Arial"; color: #FFFFFF; }

-->
    </style>
	
  </head>
  <jsp:include page="top.jsp" />
  <body>
   
  	<table width="801" height="198" border="0" align="center">
	<tr >
		<td width="60" height="22" background="img/top1_12.gif">&nbsp;</td> 
		<td width="110" background="img/top1_12.gif" align="center"><a href="add.jsp" target="frm" class="style2 ">ADD</a></td>
		<td width="110"  background="img/top1_12.gif" align="center"><a href="/jspDev/servlet/look_Servlet" target="frm" class="style2">INFO</a></td>
		<td width="110"  background="img/top1_12.gif" align="center"><a href="search.jsp" target="frm" class="style2">SEARCH</a></td>
		<td width="110"  background="img/top1_12.gif" align="center">
	    <a href="addUser.jsp" target="frm" class="style2"/>AddUser</td>
		<td width="110"  background="img/top1_12.gif" align="center"><a href="help.jsp" target="frm" class="style2">HELP</a></td>
		<td width="74"  background="img/top1_12.gif" align="center"><a href="/" onClick="javascript:window.close();return false;" class="style2">EXIT</a></td>
  	    <td width="45"  background="img/top1_12.gif" align="center">&nbsp;</td>
	</tr>
  <tr>
    <td height="168" colspan="9"  >
		<iframe align="top" src="view.jsp" name="frm" scrolling="yes"  width="801" height="500" frameborder="0">
		</iframe>
	</td>
  </tr>
</table>
<br>
  </body>
  <jsp:include page="foot.jsp" />
  
</html>



  