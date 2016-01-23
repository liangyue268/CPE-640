
<%@ page language="java"  contentType="text/html;charset=gbk"%>
<%@ page import="com.bean.*,java.util.*"%>

<html>
  <head>
    
    <title>Search</title>
    
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
  	pageBean pagebean = (pageBean) request.getAttribute("pagebean");
  	
  	int nowPage , perPage , endPage ;
  	float allRows;
  	
  	nowPage = pagebean.getNowPage();
  	perPage = pagebean.getPerPageRows();
  	endPage = pagebean.getAllPages();
  	allRows = pagebean.getTotalRows();
  	List list = pagebean.getResult();
  %>
  
  <script language="javascript">
    function showdetail(id)
    {               
    	window.open("/jspDev/servlet/deta_Servlet?id="+id,"","height=500,width=470,left=280,top=150,status=no,location=no,toolbar=no,directories=no,menubar=no")
   	}
  </script>
  
    <center><font color=red><font size = "5">All the information based on search</font></center>
    <table width="704" height="100" border="0" align="center">
      <tr>
       <td height="41" background="#CD0000">
          
          <table width="699" height="100" border="0">
            <tr>
              <td width="121">&nbsp;</td>
              <td width="568"><font color =red><br> 
              <marquee direction=left scrollamount="4"><b>Users Information...</b></marquee> </font></td>
            </tr>
          </table>        
          </td>
      </tr>
  </table>
    <table width="685" height="60" cellspacing="0" cellpadding="0" border="1" align="center">
		<tbody>
			<tr bgcolor="#CD0000">
				<td width="40" height="50" align="center"><span class="style10">ID</span></td>
				<td width="79" align="center"><span class="style10">Name </span></td>
				<td width="50" align="center"><span class="style10">Sex </span></td>
				<td width="105" align="center"><span class="style10">Age</span></td>
				<td width="198" align="center"><span class="style10">Address</span></td>
				<td colspan="3" align="center"><span class="style10">Operation</span></td>
			</tr>
			
			<%
				 java.util.Iterator it = list.iterator();
					while (it.hasNext()) 
					{
						addUserBean vo = (addUserBean) it.next();
						int id = vo.getId();
					    String name = vo.getName();
					    String sex = vo.getSex();
						int age =vo.getAge();
						String address = vo.getAddress();
			%>
		  <tr>
		 		 <td height="60" align="center"><%= id %></td>
				 <td align="center"><%= name %></td>
				 <td align="center"><%= sex %></td>
				 <td width="105" align="center"><%= age %></td>
				 <td align="center"><%= address %></td>                    
				 <td width="70" align="center">                                
				 	<!--<input TYPE="image" src="/jspDev/img/detailed.gif" align=bottom onClick="xiangxi(<%=id%>)" />-->
				 	<input type="submit" name="submit1"  value = "Detail" align=bottom onClick="showdetail(<%=id%>)" />
				 </td>
				 <td width="70" align="center">                                
				 	<!--<input TYPE="image"  src="/jspDev/img/modi.gif" align=bottom onClick="xiangxi(<%=id%>)" />-->
				 	<input type="submit" name="submit"  value = "Modify" align=bottom onClick="showdetail(<%=id%>)" /> 
				 </td>
				 <td width="70"align="center" valign=middle>
				 	<a href = "/jspDev/servlet/delete_Servlet?id=<%= id %>& nowpage=<%=nowPage  %>"> 
				 	<!--<img border="0" src="/jspDev/img/delete.gif"></a>-->
				 	<input type="button" name="submit2"  value = "Delete"></a>
				 </td>
		  </tr>
			<%
				}
			%>
			<TR>
			  <TD height="37" colspan="8" >
			  &nbsp;&nbsp;&nbsp;&nbsp;
		      &nbsp;&nbsp;   We get <%=(int)allRows%> users which accords the serch
			  &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; 	
			      <a href="/jspDev/servlet/search_Servlet">SHOW ALL</a>
			    
   	      </TD>
	      </TR>	
		</tbody>
  </table>
    <p>&nbsp;</p>
  </body>
</html>
