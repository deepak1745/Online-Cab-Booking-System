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
<h2 align="center">Detais of All Vehicle Present</h2>
</div>
<% List<VehicleBean> list=(List<VehicleBean>)request.getAttribute("dlist"); %>


<table align="center" bgcolor="white" border="2">
<tr><td><b>Vehicle name</b></td><td><b>Vehicle Number</b></td><td><b>Seating Capacity</b></td>
<td><b>Vehicle Type</b></td><td><b>Fare Per KM</b></td></tr>
<%
for (Iterator iterator=list.iterator(); iterator.hasNext();)
{
	VehicleBean vehicle=(VehicleBean)iterator.next();%>
<tr><td><%=vehicle.getVehicleName() %></td><td><%=vehicle.getVehicleNumber() %></td><td><%=vehicle.getSeatingCapacity() %></td>
<td><%=vehicle.getVehicleType() %></td><td><%=vehicle.getFarePerKM() %></td></tr>		
<% } %>
</table>

<a href="home">GO to home</a>
</body>
</html>