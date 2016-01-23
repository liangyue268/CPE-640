
<%@ page language="java" contentType="text/html;charset=gbk"%>

<html>
  <head>
<script type="text/javascript">
function Juge(form1)
{
   if(form1.nam.value=="")
   {
    window.alert("Please enter name!"); 
    form1.nam.focus(); 
    return (false); 
   }
   if(form1.bir.value =="")
   	{
   		window.alert("Please enter your birthday!");
   		form1.bir.focus();
   		return (false);
   	}
  if(form1.cla.value=="")
   {
    window.alert("Please enter your class!"); 
    form1.cla.focus(); 
    return (false); 
   }
  // if(isNaN(form1.qq.value))
	//{
		//alert("QQ cannot be a char!");
    	//return false;
	//}
   if(form1.email.value=="")
   {
    window.alert("Please enter your e-mail!"); 
    form1.email.focus(); 
    return (false); 
   }
    if(form1.email.value.length!=0)
    {
       if (form1.email.value.charAt(0)=="." ||        
         form1.email.value.charAt(0)=="@"||       
         form1.email.value.indexOf('@', 0) == -1 || 
         form1.email.value.indexOf('.', 0) == -1 || 
         form1.email.value.lastIndexOf("@")==form1.email.value.length-1 || 
         form1.email.value.lastIndexOf(".")==form1.email.value.length-1)
          {
             alert("Incorrect e-mail format");
             form1.email.focus();
             return false;
          }
    }
   if(form1.tel.value=="")
   {
    window.alert("Please enter your phone number"); 
    form1.tel.focus(); 
    return (false); 
   }
   if(form1.tel.value!="")
   {
   	if(isNaN(form1.tel.value))
		{
			alert("Phone number cannot be a char");
    		return false;
		}
	}
   if(form1.tel.value.length!=11)
   {
    window.alert("Put a zip code before your number"); 
    form1.tel.focus();  
    return (false); 
   }
   if(form1.address.value=="")
   {
    window.alert("Please enter your address"); 
    form1.address.focus(); 
    return (false); 
   }
   
  
}

</script>
    <title>Registration page</title>
  </head>
  
  <% 
  		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
  %>
  
  
  <!-- <body background="img/R6C.GIF"  bgproperties="fixed">-->
 
  
  <center>
  
   
  <form name="form1" action="/jspDev/servlet/add_Servlet"  onsubmit="return Juge(form1);" method="post">
<!--<p><img border="0" src="img/add_info.gif"> <br></p>-->
<table width="407" height="519" border="0">
  <tr>
    <td width="102">Name£º <font color="#ff0000">*</font></td>
    <td width="295"><input name="nam" type="text" size="20"><font color="#ff0000" size="-1">£¨Please use a real name!£©</font></td>
  </tr>
  <tr>
    <td>Sex£º</td>
    <td><input type="radio" name="sex" value="male" checked>
      male  &nbsp;
      <input type="radio" name="sex" value="female"> 
      female</td>
  </tr>
  <tr>
    <td>Birthday£º <font color="#ff0000"> *</font></td>
    <td><input name="bir" type="text" size="20"><font color="#ff0000" size="-1">£¨Format as Month/Day/Year£©</font></td>
  </tr>
  <tr>
    <td>Major£º <font color="#ff0000">*</font></td>
    <td><input name="cla" type="text" size="15"></td>
  </tr>
  <tr>
    <td>QQ£º</td>
    <td><input name="qq" type="text" size="11"></td>
  </tr>
  <tr>
    <td>Email£º <font color="#ff0000">*</font></td>
    <td><input name="email" type="text" size="27"><font color="#ff0000" size="-1">£¨Must be a correct format£©</font></td>
  </tr>
  <tr>
    <td>Tel£º <font color="#ff0000">*</font></td>
    <td><input name="tel" type="text" size="15" >
      <font color="#ff0000" size="-1" >£¨Please enter a correct phone number£©</font></td>
  </tr>
  <tr>
    <td>Address£º <font color="#ff0000">*</font></td>
    <td><input name="address" type="text" size="35"></td>
  </tr>
  <tr>
    <td>Hobby£º </td>
    <td><input type="text" name="lik"></td>
  </tr>
  <tr>
    <td><p>Personal statement: </p>
      <p>&nbsp;</p></td>
    <td><textarea name="info" rows="6" cols="35"></textarea></td>
  </tr>
</table>
<P>
  <INPUT type="submit" value="Add">&nbsp;&nbsp;
  <INPUT type="reset" value="Redo">
     <BR>
    </P>
    </form></center>
  </body>
</html>
