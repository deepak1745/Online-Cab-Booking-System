<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display All Drivers</title>
</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome to Suhana Safar Travel Agency</h1>
<h2 align="center">All Vehicles details</h2>
</div>
<h3 align="center" style="color: red;">${Warning}</h3>
<table align="center" bgcolor="white" border="2">
<tr><td>DriverID</td>
	<td>Vehicle NO</td>
	<td>First Name</td>
	<td>Second Name</td>
	<td>Contact NO</td>
	<td>License NO</td>
	<td>House NO</td>
	<td>Address1</td>
	<td>Address2</td>
	<td>City</td>
	<td>State</td>
	<td>PinCode</td>
</tr>
<%
ArrayList<Object[]> arraydriver= (ArrayList<Object[]>)request.getAttribute("drivers"); 
Iterator it = arraydriver.iterator();
while(it.hasNext()){
	 Object[] arraydriverinfo = (Object[]) it.next();
%>

<tr><td><%=arraydriverinfo[0] %></td>
	<td><%=arraydriverinfo[1] %></td>
	<td><%=arraydriverinfo[2] %></td>
	<td><%=arraydriverinfo[3] %></td>
	<td><%=arraydriverinfo[4] %></td>
	<td><%=arraydriverinfo[5] %></td>
	<td><%=arraydriverinfo[6] %></td>
	<td><%=arraydriverinfo[7] %></td>
	<td><%=arraydriverinfo[8] %></td>
	<td><%=arraydriverinfo[9] %></td>
	<td><%=arraydriverinfo[10] %></td>
	<td><%=arraydriverinfo[11] %></td>
</tr>
	
<%
}
%>
</table>
<a href="home">GO to home</a>
</body>
</html>