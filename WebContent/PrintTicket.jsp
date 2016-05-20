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
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Print Ticket</title>
<style>

body{
margin-left: 0px;
margin-right: 0px;
margin-top: 0px;
}
#main{
color: #fff;
}
#vNumber{
color:#fff;
margin-right: .7%;
margin-left: .2%;
font-size: 18px;
}
form{
margin-top: 2%;
}
#home{
text-decoration : none;
font-weight: 500;
font-size: 20px;
margin: 2.5%;
margin-bottom: 4%;
}
</style>
</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center" style="color: #fff;">Welcome Customer<!--%=session.getAttribute("loginid") %  --></h1>
<h1 align="center" style="color: #fff;">Welcome to Suhana Safar Travel Agency </h1>
</div>
<h1> ${message }</h1>
<h2 align="center" style="color: maroon; margin-top: 5%;">Please Give Booking Id to generate ticket</h2>
<form action="PrintTicketMain" align="center">
<span id="vNumber"> Booking Id </span><input type="text" name="bookingID">
<input type="submit" value="Print" style="margin-left: .5%; background-color: #5cb85c; color:#fff; border-color: #4cae4c;">
</form>
</body>
</html>
