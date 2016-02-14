<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<h2 align="center">please add Driver details</h2>
</div>
<h3 align="center" style="color: red;">${warning}</h3>

<form  action="drivermain" METHOD=POST>
<table align="center">
<tr><td>Vehicle Number</td><td><input type="text" name=vehicleNumber></td></tr>
<tr><td>First Name</td><td><input type="text" name=firstName ></td></tr>
<tr><td>Last Name</td><td><input type="text" name="lastName" ></tr>
<tr><td>License Number</td><td><input type="text" name=licenseNumber></td></tr>
<tr><td>Contact Number</td><td><input type="text" name=contactNumber></td></tr>

<tr><td>House Number</td><td><input type="text" name=houseNumber ></td></tr>
<tr><td>First Line Of Address</td><td><input type="text" name="firstLineOfAddress" ></tr>
<tr><td>Second Line Of Address</td><td><input type="text" name=secondLineOfAddress></td></tr>
<tr><td>City</td><td><input type="text" name=city></td></tr>
<tr><td>State</td><td><input type="text" name=state></td></tr>
<tr><td>Pin Code</td><td><input type="text" name=pinCode></td></tr>
<tr><td></td><td><input type="submit" value="Add Driver"></td></tr>
</table>
</form>
<a href="home">GO to home</a>
</body>
</html>