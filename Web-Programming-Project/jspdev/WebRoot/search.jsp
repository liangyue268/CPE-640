
<%@ page language="java" contentType="text/html;charset=gbk"%>

<html>
  <head>
  
    <title>查找学生信息</title>
    
    <style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
    </style>
  </head>
  
    <% 
  		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
   %>
  
  <!--<body background="img/R6C.GIF"  bgproperties="fixed">-->
  <center>
   <!-- <p><img border="0" src="img/serach_info.gif"></p>-->
    <form name="form2" method="get" action="/jspDev/servlet/search_Servlet">
      <table width="274" height="239" border="1" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="66" height="37" bgcolor="#336699"><div align="center" class="style1">ID</div></td>
          <td width="202">&nbsp;&nbsp;<input name="id" type="text" size="5"></td>
        </tr>
        <tr>
          <td height="40" bgcolor="#336699"><div align="center" class="style1">Name</div></td>
          <td>
            &nbsp;&nbsp;<input name="name" type="text" size="10">  
            <input type = hidden name = perPage value = 1>
          </td>
        </tr>
        <tr>
          <td height="35" bgcolor="#336699"><div align="center" class="style1">Sex</div></td>
          <td>
		  &nbsp;&nbsp;<input name="sex" type="radio" value="male">
            male
              <input type="radio" name="sex" value="female">
            female</td>
        </tr>
        <tr>
          <td height="37" bgcolor="#336699"><div align="center" class="style1">Class</div></td>
          <td>&nbsp;&nbsp;<input name="class_" type="text" size="10"></td>
        </tr>
        <tr>
          <td height="39" bgcolor="#336699"><div align="center" class="style1">Address</div></td>
          <td>&nbsp;&nbsp;<input type="text" name="address"></td>
        </tr>
        <tr>
          <td colspan="2">
          	<div align="center">
           <!-- <input type="image" src="img/searchto.gif" value="submit">&nbsp;&nbsp;
            <input type="reset"  src="img/reset.gif" value="redo">-->
            <P>
  <INPUT type="submit" value="Submit">&nbsp;&nbsp;
  <INPUT type="reset" value="Redo">
           
          	</div>
          </td>
        </tr>
      </table>
    </form>
    <p><br>
      <br>
        </p>
  </center>
      <br>
  </body>
</html>
