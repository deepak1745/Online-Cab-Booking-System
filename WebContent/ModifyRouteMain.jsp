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
   import="bean.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Route Main</title>
</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome to Travel Agency</h1>
<h2 align="center">please modify route details</h2>
</div>
<h3 align="center" style="color: red;">${Warning}</h3>
<form  action="FinalModifyRoute" METHOD=POST>
<%RouteBean route=(RouteBean)request.getAttribute("route");
%>
<table align="center">
<tr><td> Route id</td><td><input type="text" name=Route_id value=<%=route.getRoute_id() %> readonly="readonly"></td></tr>
<tr><td>source </td><td><input type="text" name=source value=<%=route.getSource() %> readonly="readonly"></td></tr>
<tr><td>destination</td><td><input type="text" name=destination value=<%=route.getDestination() %> readonly="readonly"></td></tr>
<tr><td>distance</td><td><input type="text" name="distance"  value=<%=route.getDistance() %>>

<tr><td>duration</td><td><input type="text" name=duration value=<%=route.getDuration() %>></td></tr>
<tr><td></td><td><input type="submit" value="Modify Route"></td></tr>
</table>
</form>
<a href="home">GO to home</a>
</body>
</html>
