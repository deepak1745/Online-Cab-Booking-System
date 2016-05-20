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