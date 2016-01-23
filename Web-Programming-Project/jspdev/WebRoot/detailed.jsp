
<%@ page language="java"  contentType="text/html;charset=gbk"%>
<%@ page import="com.bean.*,java.util.*"%>
<html>
  <head>
    
    
<script type="text/javascript">
function Juge(form1)
{
   if(form1.bir.value =="")
   	{
   		window.alert("Please enter your birthday");
   		form1.bir.focus();
   		return (false);
   	}
  if(form1.class_.value=="")
   {
    window.alert("Please enter your class！"); 
    form1.cla.focus(); 
    return (false); 
   }
   if(isNaN(form1.qq.value))
	{
		alert("qq cannot be a char!");
    	return false;
	}
   if(form1.email.value=="")
   {
    window.alert("Please enter your email address"); 
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
             alert("Incorrect email format！");
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
			alert("Phone number cannot be a char!");
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
    <title>Student Information</title>
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
	request.setCharacterEncoding("gbk");
  	response.setContentType("text/html;charset=gbk"); 
  	pageBean pagebean = (pageBean) request.getAttribute("pageBean");
  	
  	int nowPage , perPage , endPage ;
  	
  	nowPage = pagebean.getNowPage();  //当前页数
  	perPage = pagebean.getPerPageRows();  //每页显示多少条数
  	endPage = pagebean.getAllPages();    // 最后一页
  	 
  	List list = pagebean.getResult();
  %>
  
 <!-- <body background="../img/R6C.GIF"  bgproperties="fixed" >-->
  			<%
				 java.util.Iterator it = list.iterator();
					while (it.hasNext()) 
					{
						User vo = (User) it.next();
						int id = vo.getIdx();
					    String name = vo.getNam();
					    String sex = vo.getSex();
					    String bir = vo.getBir();
						String class_ =vo.getClass_();
						String QQ = vo.getQq();
						String email = vo.getEmail();
						String join_time = vo.getJoin_time();
						String like = vo.getLik();
						String address = vo.getAddress();
						String info = vo.getInfo();
						String tel = vo.getTel();
			%>
  <form method=post name=form1 action=/jspDev/servlet/modi_Servlet  onsubmit="return Juge(form1);"> 
    <table width="441" height="426" border="1" align="center">
      <tr>
        <td width="102" bgcolor="＃336699"><div align="center" class="style10">ID</div></td>
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= id %>
        <input type = hidden name= id value =<%= id %> > </td>
        
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center" class="style10">Name</div></td>
        <td colspan="2">&nbsp;&nbsp;<%= name %></td>
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center" class="style10">Sex</div></td>
        <td colspan="2"> 
        <%
        	if(sex.equals("male")){ %>
        	&nbsp;
        	<input type = radio name= sex value="male" checked>male&nbsp;&nbsp;&nbsp;
        	<input type = radio name= sex value="female">female
        <%
        } if(sex.equals("female"))  {  %>
        	&nbsp;
        	<input type = radio name= sex value="male" >male&nbsp;&nbsp;&nbsp;
        	<input type = radio name= sex value="female" checked>female
        <%}
        %></td>
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center" class="style10">birthday</div></td>
        <td colspan="2">&nbsp;&nbsp;<input type = "text" name=bir value = <%= bir %> ></td>
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center"  class="style10">class</div></td>
        <td colspan="2">&nbsp;&nbsp;<input type = "text" name=class_ value = <%= class_ %> ></td>
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center" class="style10">QQ</div></td>
        <td colspan="2">&nbsp;&nbsp;<input type = "text" name=qq value = <%= QQ %>></td>
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center"  class="style10">email</div></td>
        <td colspan="2">&nbsp;&nbsp;<input type = "text"  name=email value = <%= email %>></td>
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center"  class="style10">phone</div></td>
        <td colspan="2">&nbsp;&nbsp;<input type = "text" name=tel value = <%= tel %> ></td>
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center" class="style10">address</div></td>
        <td colspan="2">&nbsp;&nbsp;<input type = "text" name=address value = <%= address %>></td>
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center"  class="style10">join_time</div></td>
        <td colspan="2">&nbsp;&nbsp;<%= join_time %></td>
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center" class="style10">hobby</div></td>
        <td colspan="2">&nbsp;&nbsp;<input type = "text" name=like value = <%= like %> ></td>
      </tr>
      <tr>
        <td bgcolor="＃336699"><div align="center" class="style10">description</div></td>
        <td colspan="2">&nbsp;&nbsp;<textarea name="info" rows="6" cols="35"> <%= info %></textarea>  </td>
      </tr>
      <tr>
        <td height="38" bgcolor="＃336699"><div align="center" class="style10">operation</div></td>
		<td align="center"  valign="middle">
		<!--<input name="image" type="image" src="/jspDev/img/baocun.gif"></td>-->
		<input name="submit1" type="button" value = "Save"></td>
		 
      </tr>
      <%
		}
	  %>
    </table>
  </form>
  <center><a href="javascript:window.close()">Close window</a></center><br>
  
  </body>
</html>
