
<%@ page language="java"  contentType="text/html;charset=gbk"%>

<html>
  <head>
   <title>Send Mail</title>
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
  %>
<script type="text/javascript">
     function J(f)
{
  	   if(f.name.value=="")
	   {
	    window.alert("Please enter receiver!"); 
	    f.name.focus(); 
	    return (false); 
	   }
	   if(f.msg.value=="")
	   {
	    window.alert("Please enter your message!"); 
	    f.pwd.focus(); 
	    return (false); 
	   }
	   if(f.name.value.equals(me)){
		   window.alert("Can't send to yourself!");
		   return (false);
	   }
    	   return (false);
 }
     </script>
<FORM name="f" action="/jspDev/servlet/sendmail_Servlet?me=<%=me %>" method="post" onsubmit="return J(f)">
   <P align="left"><br><br>
   To: <br>  <INPUT type="text" name="name"><BR><BR>
   Message: <br><textarea name="msg" rows="20" cols="200"></textarea><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   </P><br>
		  <input type="submit" name="submit"  value = "Send" style="width:100px; height:50px;"> 
          <a>&nbsp;</a>
          <INPUT type="reset" value="Redo" style="width:100px; height:50px;">
          <tr>
        <td height="73">&nbsp;</td>
        <td width="192">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
</FORM>
	</body>
	

</html>
