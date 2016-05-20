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
<title>Gateway</title>
</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome <%=session.getAttribute("loginid") %></h1>
<h1 align="center">Welcome to Suhana Safar Travel Agency </h1>
</div>
<%
BookingBean bookingbean=(BookingBean)session.getAttribute("bookingbean");
%>
<h1 align="center">Please pay <%=bookingbean.getFare() %> to confirm booking</h1>
<h2 align="center" >${message}</h2>
<form action="BookCheck" >
<table align="center">
<tr>
<td>creditcard number</td><td><input type="text" name="creditCardNumber" ></td></tr>
<tr><td>valid from</td><td><input type="text" name="validFrom" ></tr>
<tr><td>valid to</td><td><input type="text" name="validTo" ></td></tr>
<!-- <tr><td>creditcard balance</td><td><input type="text" name="creditBalance" ></td></tr> -->
<tr><td></td><td> <input type="submit" name=submit value=pay></td></tr>
</table>
</form>

</body>
</html>
