<%@ page language="java"  pageEncoding="gbk"%>
<%@ page import="com.S3conn.S3CheckFile"%>
<%@ page import="java.util.List"%>
<html>
  <head>
  </head>
  <body background="img/whitebg.jpg">
  <P></P>
  <%
  String myip=request.getLocalAddr();
  int me=(Integer)session.getAttribute("user");
  String loc=request.getParameter("loc");
  S3CheckFile scheck=new S3CheckFile();
  List<String> list;
  if(loc.equals("1")){
	list=scheck.list(0);}
  else
  {list=scheck.list(me);}
  for(int i=0;i<list.size();i++){
	  String a=list.get(i);
	  String filetype=a.substring(a.lastIndexOf('.')+1,a.length());
	  String filepic="img/";
	  if(filetype.equals("txt")){
		  filepic+="txt.gif";
	  }
	  else if(filetype.equals("url")){
		  filepic+="url.gif";
	  }
	  else if(filetype.equals("wmv")){
		  filepic+="wmv.gif";
	  }
	  else if(filetype.equals("wps")){
		  filepic+="wps.gif";
	  }
	  else if(filetype.equals("zip")){
		  filepic+="zip.gif";
	  }
	  else if(filetype.equals("xls")){
		  filepic+="xls.gif";
	  }
	  else if(filetype.equals("ppt")){
		  filepic+="ppt.gif";
	  }
	  else if(filetype.equals("png")){
		  filepic+="pdf.gif";
	  }
	  else if(filetype.equals("mp4")){
		  filepic+="mp4.gif";
	  }
	  else if(filetype.equals("mp3")){
		  filepic+="mp3.gif";
	  }
	  else if(filetype.equals("rar")){
		  filepic+="rar.gif";
	  }
	  else if(filetype.equals("pdf")){
		  filepic+="pdf.gif";
	  }
	  else if(filetype.equals("mov")){
		  filepic+="mov.gif";
	  }
	  else if(filetype.equals("js")){
		  filepic+="js.gif";
	  }
	  else if(filetype.equals("jpg")){
		  filepic+="jpg.gif";
	  }
	  else if(filetype.equals("img")){
		  filepic+="img.gif";
	  }
	  else if(filetype.equals("html")){
		  filepic+="html.gif";
	  }
	  else if(filetype.equals("gif")){
		  filepic+="gif.gif";
	  }
	  else if(filetype.equals("exe")){
		  filepic+="exe.gif";
	  }
	  else if(filetype.equals("doc")||filetype.equals("docx")){
		  filepic+="doc.gif";
	  }
	  else{
		  filepic+="default.png";
		  }
  %>
    <tr>
    <img src="<%=filepic %>" width="20" hright="20">
    <a href="http://<%=myip %>:8080/jspDev/Files/<%=a %>"><font color=red><%=a %></font> </a>
    <a>&nbsp;</a> 
    <img src="img/download.png" width="20" hright="20">
    <%
    if(loc.equals("1")){
    %>
    <a  href="/jspDev/servlet/download_Servlet?name=<%=a %>&req=0" target="frm" class="style2 " onclick="return checkForm(<%=i %>)"><font color=red>Download</font> </a>
        <a>&nbsp;</a> 
    <img src="img/star.jpg" width="20" hright="20">
    <a href="/jspDev/rating.jsp?fnam=<%=a %>" target="frm" class="style2 "><font color=red>Rate</font> </a><br>
    <%}
    else{%>
    <a  href="/jspDev/servlet/download_Servlet?name=<%=a %>&req=<%=me %>" target="frm" class="style2 " onclick="return checkForm(<%=i %>)"><font color=red>Download</font> </a>
    <a>&nbsp;</a> 
    <img src="img/delete.png" width="20" hright="20">
    <a  href="/jspDev/servlet/deletef_Servlet?name=<%=a %>&req=<%=me %>" target="frm" class="style2 " onclick="return checkForm(<%=i %>)"><font color=red>Delete</font> </a><br>
    
    <%} %>

    </tr>
  <%} %>
  </body>
  </html>