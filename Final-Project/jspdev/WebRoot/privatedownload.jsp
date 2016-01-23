<%@ page language="java"  pageEncoding="gbk"%>
<html>
  <head>
  <title>downloadpage</title> 
  <style type="text/css"> 
body{background-image:url(img/whitebg.jpg);background-repeat:repeat;width:100%;} 
body h1{text-align:center;} 
</style> 
  </head>
  <script>
  function checkForm(i){
	  var downloadloc="loading"+i;
	  document.getElementById(downloadloc).style.display="block";
	  alert("Downloading will start soon, please wait.");
  }
  
  
  </script>
  <%
  String[] a=(String[])session.getAttribute("names");
  int b=a.length;
  String myip=request.getLocalAddr();
  for(int i=0;i<b;i++){
	  String filetype=a[i].substring(a[i].lastIndexOf('.')+1,a[i].length());
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
    <a href="http://<%=myip %>:8080/jspDev/Files/<%=a[i] %>"><font color=red><%=a[i] %></font> </a>
    <a>&nbsp;</a> 
    <img src="img/download.png" width="20" hright="20">
    <a  href="/jspDev/servlet/download_Servlet?name=<%=a[i] %>" target="frm" class="style2 " onclick="return checkForm(<%=i %>)"><font color=red>Download</font> </a>
    <a>&nbsp;</a>  
    </tr><br>
    <div id="loading<%=i%>" style="display:none">
  	<div clas="loading-indicator">Start Downloading...</div>
  	</div>
    <%
  }
    %>
     </body>
  </html>