<%@ page language="java"  pageEncoding="gbk"%>
<html>
  <head>
  </head>
  <body background="img/whitebg.jpg">
  <P></P>
  <%
  int me=(Integer)session.getAttribute("user");
  %>
  <form name="form" method="post" action="/jspDev/servlet/upload_Servlet?priv=<%=me%>" enctype="multipart/form-data"><font color=red>Select the file to upload:</font><input type="file" name="upload" size="50"><br>
  <input type="submit" value="Submit">
  <input type="reset" value="undo">
  </form>
  </body>
  </html>
