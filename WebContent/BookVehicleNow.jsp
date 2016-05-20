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
    pageEncoding="ISO-8859-1"  import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Vehicle</title>

</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome <%=session.getAttribute("loginid") %></h1>
<h1 align="center">Welcome to Suhana Safar Travel Agency </h1>
</div>
<h2>${warning }</h2>
<form action="search" METHOD=POST>
<%
ArrayList<ArrayList<String>> sourceDestination = (ArrayList<ArrayList<String>>)request.getAttribute("sourceDestination");
ArrayList<String> sources =  sourceDestination.get(0);

ArrayList<String> destinations =  sourceDestination.get(1);

%>
<table align="center">
<tr><td>Source</td>
<td><select name="source">
<%	for (Iterator iterator=sources.iterator(); iterator.hasNext();){
	String temp=(String)iterator.next();
	System.out.println(temp);
	%>

			<option value=<%=temp %>><%=temp %></option>

<%	}
%></select>
</td>
</tr>
<tr><td>Destination</td>
<td><select name="destination">
	<%	for (Iterator iterator=destinations.iterator(); iterator.hasNext();){
	String temp=(String)iterator.next();
	%>

			<option value=<%=temp %>><%=temp %></option>

<%	}%></select>
</td>
</tr>
<tr><td>Vehicle Name</td><td><input type="text" name=vehicleName></td></tr>
<tr><td>Vehicle Type</td><td><input type="text" name=vehicleType></td></tr>
<tr><td>Journey Date</td><td><input type="text" name=journeyDate></td><td>${message }</td></tr>
<tr><td></td><td><input type="submit" value="Search"></td></tr>
</table>
</form>
</body>
</html>
