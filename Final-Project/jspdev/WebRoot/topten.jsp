<%@ page language="java"  pageEncoding="gbk"%>
<%@ page import="com.DAO.DAO"%>
<%@ page import="java.util.List"%>
<html>
  <head>
  </head>
  <body background="img/whitebg.jpg">
  <P></P>
  <%
  String myip=request.getLocalAddr();
  DAO scheck=new DAO();
  List<String> list;
  list=scheck.gettopten();
  for(int i=0;i<list.size();i+=2){
	  String b=list.get(i);
	  String a=list.get(i+1);
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
    <a  href="/jspDev/servlet/download_Servlet?name=<%=a %>&req=0" target="frm" class="style2 " onclick="return checkForm(<%=i %>)"><font color=red>Download</font> </a>
    <a>&nbsp;</a> 
    <img src="img/star.jpg" width="20" hright="20">
    <a href="/jspDev/rating.jsp?fnam=<%=a %>" target="frm" class="style2 "><font color=red>Rate</font> </a>
    <a>Currentrate:<%=b %></a><br>
    </tr>
  <%} %>
  </body>
  </html>