
<%@ page language="java"  contentType="text/html;charset=gbk"%>

<html>
  <head>
    
    <title>ҳü</title>
    
<style>
.time { font-size: 16pt; line-height: 20pt; color:red;}
</style>


<SCRIPT language=JavaScript>
<!-- Hiding
var ctimer;

function init(){
if (document.all){
tim2.style.left=tim1.style.posLeft;
tim2.style.top=tim1.style.posTop+tim1.offsetHeight-6;
settimes();
}
}

function settimes(){
var time= new Date();
hours= time.getHours();
mins= time.getMinutes();
secs= time.getSeconds();
if (hours<10)
hours="0"+hours;
if(mins<10)
mins="0"+mins;
if (secs<10)
secs="0"+secs;
tim1.innerHTML=hours+":"+mins+":"+secs
tim2.innerHTML=hours+":"+mins+":"+secs
ctimer=setTimeout('settimes()',960);
}
// Done hiding -->
</SCRIPT>
	
    <style type="text/css">
<!--
.style6 {font-size: 24px}
-->
    </style>
  </head>
  <% 
  		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
  %>

   <body onload="init()">
   <table width="950" height="150" border="0" align="center" cellpadding="0" cellspacing="0"  background ="/jspDev/img/top.jpg" ><tr>
       <td width="608" rowspan="2" > <p class="style5"><br>
       </td>
       <td height="15" ></td>
      
     </tr>
     <tr>
       <td width="200" height="50" ><SCRIPT language=javascript>
calendar = new Date();
day = calendar.getDay();
month = calendar.getMonth();
date = calendar.getDate();
year = "2015";
if (year< 100) year = 1900 + year;
cent = parseInt(year/100);
g = year % 19;
k = parseInt((cent - 17)/25);
i = (cent - parseInt(cent/4) - parseInt((cent - k)/3) + 19*g + 15) % 30;
i = i - parseInt(i/28)*(1 - parseInt(i/28)*parseInt(29/(i+1))*parseInt((21-g)/11));
j = (year + parseInt(year/4) + i + 2 - cent + parseInt(cent/4)) % 7;
l = i - j;
emonth = 3 + parseInt((l + 40)/44);
edate = l + 28 - 31*parseInt((emonth/4));
emonth--;
var dayname = new Array ("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
var monthname = 
new Array ("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec" );
document.write("<font color=white>"+year +"/");
document.write(monthname[month]+"/");
document.write(date + " ");
document.write(dayname[day]+" "+"</font>");
</SCRIPT>
	  </td>
     </tr>
     <tr >
   
	<%
     int id = (Integer)request.getAttribute("aut");
     if(id!=1){
    %>
       
       <td width="608" ><span class="style6">Welcome <font color=red>${sessionScope.name}</font></td>
       <td height="35"  ></td>
        
	<%
     }
     else{
     %>
       <td width="608" ><span class="style6">Welcome <font color=red>Administrator</font> Enter Student Management System</span></td>
       <td height="35"  ></td>  
      

       	<%
     } 
     %>
     </tr>
  </table>
  <DIV class=time id=tim1 
    style="HEIGHT: 20px; LEFT: 763px; POSITION: absolute; TOP: 60px; WIDTH: 5px">
  </DIV>
  <DIV class=time id=tim2 
    style="FILTER: flipv() alpha(opacity=20); FONT-STYLE: italic; POSITION: absolute; left: 654px; top: 19px;">
  </DIV>
  </body>
</html>                 
