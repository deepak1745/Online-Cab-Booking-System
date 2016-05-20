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
    pageEncoding="ISO-8859-1" import="bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Ticket </title>
</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome <%=session.getAttribute("loginid") %></h1>
<h1 align="center">Welcome to Suhana Safar Travel Agency </h1>
</div>
<%BookingBean bookingbean=(BookingBean)request.getAttribute("ticket"); %>
<table align="center" border="2">
<tr><td>Booking id</td><td><%=bookingbean.getBookingid() %></td></tr>
<tr><td>Vehicle Number</td><td><%=bookingbean.getVehicleNumber() %></td></tr>
<tr><td>Booking date</td><td><%=bookingbean.getBookingDate() %></td></tr>
<tr><td>Journey date</td><td><%=bookingbean.getJourneyDate() %></td></tr>
<tr><td>Fare</td><td><%=bookingbean.getFare() %></td></tr>
<tr><td><a href="customerhome">Print Ticket</a></td></tr>
</table>
</body>
</html>
