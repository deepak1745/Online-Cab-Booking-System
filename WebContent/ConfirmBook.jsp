<!-- Copyright 2016 Deepak Kumar
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
This code is written by Deepak Kumar -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.*" import="bean.*" import="java.lang.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Book</title>
</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome <%=session.getAttribute("loginid") %></h1>
<h1 align="center">Welcome to Suhana Safar Travel Agency </h1>
</div>
<%
VehicleBean vehiclebean = (VehicleBean)request.getAttribute("vehicledetails");
SearchBean searchbean = (SearchBean)request.getAttribute("searchdetails");
ArrayList<Object[]> routedetails = (ArrayList<Object[]>) request.getAttribute("routedetails");

float distance=0;
String routeid="";
for (Iterator iterator=routedetails.iterator(); iterator.hasNext();)
{
	Object[] routedetail=(Object[])iterator.next();
	distance=Float.parseFloat(routedetail[0].toString());
	routeid=(String)routedetail[1];
}
%>
<table align="center" border="2">
<tr><td>Source </td><td><%=searchbean.getSource() %></td></tr>
<tr><td>Destination </td><td><%=searchbean.getDestination() %></td></tr>
<tr><td>Vehicle Type </td><td><%= vehiclebean.getVehicleType() %></td></tr>
<tr><td>Vehicle Name </td><td><%=vehiclebean.getVehicleName() %></td></tr>
<tr><td>Vehicle Number </td><td><%=vehiclebean.getVehicleNumber() %></td></tr>
<tr><td>Total Fare </td><td><%=distance*vehiclebean.getFarePerKM() %></td></tr>
<tr><td>Journey Date </td><td><%=searchbean.getJourneyDate() %></td></tr>
</table><br><br>
<div align="center">
<a href="FinalBook?vehicleNumber=<%=vehiclebean.getVehicleNumber() %>&&journeyDate=<%=searchbean.getJourneyDate() %>&&routeid=<%=routeid %>&&fare=<%=distance*vehiclebean.getFarePerKM() %>">Confirm Booking</a>
</div>
</body>
</html>
