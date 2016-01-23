
<%@ page language="java"  contentType="text/html;charset=gbk"%>
<%@ page import="com.bean.*,java.util.*"%>

<html>
  <head>
    
    <title>察看学生信息</title>
    
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
  
  <script language="javascript">
    function xiangxi(id)
    {               
    	window.open("/jspDev/servlet/deta_Servlet?id="+id,"","height=500,width=470,left=280,top=150,status=no,location=no,toolbar=no,directories=no,menubar=no")
   	}
  </script>
  
  <!--body background="../img/R6C.GIF"  bgproperties="fixed">-->
    <center><!--<img border="0" src="../img/look_info.gif"> </center>-->
    <table width="704" height="45" border="0" align="center">
      <tr>
       <!-- <td height="41" background="../img/ti_shi.gif">-->
          
          <table width="699" height="45" border="0">
            <tr>
              <td width="121">&nbsp;</td>
              <td width="568"><font color =red><br>   <!--修改后的信息刷新后才能正确反映 删除的信息将不能复原，请慎重考虑-->
              <marquee direction=left scrollamount="4"><b>Hello!!</b></marquee> </td>
            </tr>
          </table>        
          </td>
      </tr>
  </table>
    <table width="685" height="45" cellspacing="0" cellpadding="0" border="1" align="center">
		<tbody>
			<tr bgcolor="#336699">
				<td width="40" height="30" align="center"><span class="style10">ID</span></td>
				<td width="79" align="center"><span class="style10">Name</span></td>
				<td width="50" align="center"><span class="style10">Sex</span></td>
				<td width="105" align="center"><span class="style10">Class</span></td>
				<td width="198" align="center"><span class="style10">Address</span></td>
				<td colspan="3" align="center"><span class="style10">Operation</span></td>
			</tr>
			
			<%
				 java.util.Iterator it = list.iterator();
					while (it.hasNext()) 
					{
						User vo = (User) it.next();
						int id = vo.getIdx();
					    String name = vo.getNam();
					    String sex = vo.getSex();
						String class_ =vo.getClass_();
						String address = vo.getAddress();
			%>
		  <tr>
		 		 <td height="30" align="center"><%= id %></td>
				 <td align="center"><%= name %></td>
				 <td align="center"><%= sex %></td>
				 <td width="105" align="center"><%= class_ %></td>
				 <td align="center"><%= address %></td>                    
				 <td width="70" align="center">                                <!--详细按钮-->
				 	<input TYPE="image" src="/jspDev/img/detailed.gif" align=bottom onClick="xiangxi(<%=id%>)" />
				 </td>
				 <td width="70" align="center">                                 <!--修改按钮-->
				 	<input TYPE="image"  src="/jspDev/img/modi.gif" align=bottom onClick="xiangxi(<%=id%>)" />
				 </td>
				 <td width="70"align="center" valign=middle>
				 	<a href = "/jspDev/servlet/delete_Servlet?id=<%= id %>&nowPage=<%=nowPage%>">     <!--删除按钮-->
				 	<img border="0" src="/jspDev/img/delete.gif"></a>
				 </td>
		  </tr>
			<%
				}
			%>
			<TR>
			  <TD height="37" colspan="8" >
			  &nbsp;&nbsp;&nbsp;&nbsp;
			    <%if(nowPage-1==0)
				 { 
				  %>
				  已是首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		        <% }else 
			     {  
			      %>
			      <a href="/jspDev/servlet/look_Servlet?nowPage=1">首页</a> &nbsp;&nbsp;
			      <a href="/jspDev/servlet/look_Servlet?nowPage=<%= nowPage-1 %>">上一页 </a>
			     &nbsp;&nbsp;
			       <% } %>
			       
			     <% 
			     if(nowPage+1>endPage)
			    	{ 
			     %> 
			     &nbsp;&nbsp; 
			     已是最后一页
			 	 <%
			      } else
			      { 
			     %>
			     <a href="/jspDev/servlet/look_Servlet?nowPage=<%= nowPage+1 %>">  &nbsp;&nbsp;下一页 </a>
			     &nbsp;&nbsp;
			     <a href="/jspDev/servlet/look_Servlet?nowPage=<%= endPage %>"> 尾页</a>
			     <% } %>
			     &nbsp;&nbsp; 
			      页次  &nbsp;&nbsp; <%= nowPage %>/<%= endPage  %> 页		  
			    &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;   
				<a href="/jspDev/servlet/look_Servlet?nowPage=<%=nowPage  %>">刷新</a>
   	      </TD>
	      </TR>	
		</tbody>
  </table>
    <p>&nbsp;</p>
  </body>
</html>
