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
<h2 align="center">please give vehicle details</h2>
</div>
<h3 align="center" style="color: red;">${Warning}</h3>
<form  action="vehiclemain" METHOD=POST>
<table align="center">
<tr><td> Vehicle Number</td><td><input type="text" name=vehicleNumber ></td></tr>
<tr><td>Vehicle Name</td><td><input type="text" name=vehicleName></td></tr>
<tr><td>Seating Capacity</td><td><input type="text" name=seatingCapacity value=0></td></tr>
<tr><td>Vehicle Type</td><td><input type="radio" name="vehicleType" value="AC">AC<br>
                       <input type="radio" name="vehicleType" value="Non-AC">Non-AC</td></tr>
<tr><td>Fare Per KM</td><td><input type="text" name=farePerKM value=0></td></tr>
<tr><td></td><td><input type="submit" value="Add Vehicle"></td></tr>
</table>
</form>
<a href="home">GO to home</a>
</body>
</html>