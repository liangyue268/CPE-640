
<%@ page language="java" contentType="text/html;charset=gb2312"%>
<%@ page import="java.io.File"%>
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
	background-image: url(/jspDev/img/white.jpg);
}
.style2 {font-family: "Arial" }
.style4 {font-family: "Arial"; color: #FFFFFF; }

-->
    </style>
	
  </head>
  <jsp:include page="top.jsp" />
  <body>
   
  	<table width="900" height="198" border="0" align="center" >
	<tr >
	<%
	response.setContentType("text/html;charset=gbk");
	request.setCharacterEncoding("gbk");
	int a=(Integer)request.getAttribute("aut"); 
	String name=(String)session.getAttribute("name");
	%>
	    <td width="20" height="50" background="/jspDev/img/red.jpg">&nbsp;</td>
		<td width="110" bgcolor="#CD0000" align="center"><a href="/jspDev/drawboard.xhtml" target="frm" class="style2 ">DRAWBOARD</a></td>
		<td width="110" bgcolor="#CD0000" align="center"><a href="/jspDev/chat.xhtml" target="frm" class="style2 ">CHAT</a></td>
		<td width="110"   bgcolor="#CD0000" align="center"><a href="/jspDev/servlet/look_Servlet?name=<%=a %>" target="frm" class="style2">INFO</a></td>

		<%
		session.setAttribute("user",a);
		if(a==1){
		%>
		<td width="110"  background="/jspDev/img/red.jpg" align="center"><a href="/jspDev/search.jsp" target="frm" class="style2">SEARCH</a></td>
		<td width="110"  background="/jspDev/img/red.jpg" align="center"><a href="/jspDev/addUser.jsp" target="frm" class="style2">AddUser</a></td>
		<%} %>
		<%
		File file=new File("C:/Users/Xuefan/Desktop/640 HW4/jspdev2/jspdev/WebRoot/Files");
		File[] files=file.listFiles();
		int n=files.length;
		String[] aa=new String[n];
		for(File f:files){
			aa[n-1]=f.getName();
			n--;
		}
		session.setAttribute("names", aa);
		request.setAttribute("names", aa);
		%>
		<td width="110"  bgcolor="#CD0000" align="center"><a href="/jspDev/mail.jsp?aut=<%=name%>" target="frm" class="style2">MAILBOX</a></td>
		<td width="110" bgcolor="#CD0000" align="center"><a href="/jspDev/wup.jsp?aut=<%=a%>" target="frm" class="style2">UPLOAD</a></td>
		<td width="110" bgcolor="#CD0000" align="center"><a href="/jspDev/wrap.jsp?aut=<%=a%>" target="frm" class="style2">DOWNLOAD</a></td>
		<td width="110" bgcolor="#CD0000" align="center"><a href="/jspDev/help.jsp" target="frm" class="style2">HELP</a></td>
		<td width="74"  bgcolor="#CD0000" align="center"><a href="/jspDev/" class="style2">EXIT</a></td>
  	    <td width="45" bgcolor="#CD0000" align="center">&nbsp;</td>
	</tr>
  <tr>
    <td height="168" colspan="9"  >	
		<iframe align="top" src="/jspDev/view.jsp" name="frm" scrolling="yes"  width="1200" height="800" frameborder="0">
		</iframe>

	</td>
  </tr>
</table>
<br>
  </body>
  <jsp:include page="foot.jsp" />
  
</html>



  