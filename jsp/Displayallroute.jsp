<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 import="com.wipro.ata.bean.*" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome to Suhana Safar Travel Agency</h1>
<h2 align="center">Details of All Routes Present</h2>
</div>
<% List<RouteBean> list=(List<RouteBean>)request.getAttribute("dlist"); %>


<table align="center" bgcolor="white" border="2" style="width:100%">
<tr><td><b>Route id</b></td><td><b>Source</b></td><td><b>Destination</b></td>
<td><b>Distance</b></td><td><b>Duration</b></td></tr>
<%
for (Iterator iterator=list.iterator(); iterator.hasNext();)
{
	RouteBean route=(RouteBean)iterator.next();%>
<tr><td><%=route.getRoute_id() %></td><td><%=route.getSource() %></td><td><%=route.getDestination() %></td>
<td><%=route.getDistance() %></td><td><%=route.getDuration() %></td></tr>		
<% } %>
</table>

<a href="home">GO to home</a>
</body>
</html>