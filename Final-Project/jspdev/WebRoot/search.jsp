
<%@ page language="java" contentType="text/html;charset=gbk"%>

<html>
  <head>
  
    <title>Search User Information</title>
    
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
      <table width="500" height="239" border="1" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="500" height="60" bgcolor="#CD0000"><div align="center" class="style1"> <font color=white><font size = "5">ID</font></div></td>
          <td width="500">&nbsp;&nbsp;<input name="id" type="text" size="5"></td>
        </tr>
        <tr>
          <td height="60" bgcolor="#CD0000"><div align="center" class="style1"><font color=white><font size = "5">Name</font></div></td>
          <td>
            &nbsp;&nbsp;<input name="name" type="text" size="10">  
            <input type = hidden name = perPage value = 1>
          </td>
        </tr>
        <tr>
          <td height="60" bgcolor="#CD0000"><div align="center" class="style1"><font color=white><font size = "5">Sex</font></div></td>
          <td>
		  &nbsp;&nbsp;<input name="sex" type="radio" value="male">
            <font color=red><font size = "5">Male</font>
              <input type="radio" name="sex" value="female">
           <font color=red><font size = "5">Female</font></td>
        </tr>
        <tr>
          <td height="60" bgcolor="#CD0000"><div align="center" class="style1"><font color=white><font size = "5">Age</font></div></td>
          <td>&nbsp;&nbsp;<input name="age" type="text" size="20"></td>
        </tr>
        <tr>
          <td height="60" bgcolor="#CD0000"><div align="center" class="style1"><font color=white><font size = "5">Address</font></div></td>
          <td>&nbsp;&nbsp;<input type="text" name="address"></td>
        </tr>
        <tr>
          <td colspan="2">
          	<div align="center">
           <!-- <input type="image" src="img/searchto.gif" value="submit">&nbsp;&nbsp;
            <input type="reset"  src="img/reset.gif" value="redo">-->
            <P>
            <INPUT type="submit" value="Submit" style="font-size:30">&nbsp;&nbsp;
            <INPUT type="reset" value="Redo"style="font-size:30">
           
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
