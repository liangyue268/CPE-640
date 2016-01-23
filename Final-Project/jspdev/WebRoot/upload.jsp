<%@ page language="java"  pageEncoding="gbk"%>
<html>
  <head>
  <style>
  form,form input{
  font-size :30px;
  color:red;
  }
  
  </style>
  </head>
  <body background="img/whitebg.jpg">
  <P></P>
  <form name="form" method="post" action="/jspDev/servlet/upload_Servlet?priv=0" enctype="multipart/form-data">Select the file to upload:<input type="file" name="upload" size="100"><br>
  <input type="submit" value="Submit" />
  <input type="reset" value="undo" />
  </form>
  </body>
  </html>
