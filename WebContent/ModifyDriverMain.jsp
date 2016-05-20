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

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "bean.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Driver Main</title>
</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome to Travel Agency</h1>
<h2 align="center">please add Driver details</h2>
</div>
<h3 align="center" style="color: red;">${warning}</h3>

<% Object array[] = new Object[2];
	array = (Object[])request.getAttribute("returning_array");
	DriverBean driverbean = (DriverBean) array[0];
	DriverAddressBean dabean = (DriverAddressBean) array[1];

%>

<form  action="finalmodifydriver" METHOD=POST>
<table align="center">

<tr><td>Vehicle Number</td><td><input type="text" name=vehicleNumber readonly="readonly" value=<%=driverbean.getVehicleNumber() %>></td></tr>
<tr><td>First Name</td><td><input type="text" name=firstName readonly="readonly" value=<%=driverbean.getFirstName() %> ></td></tr>
<tr><td>Last Name</td><td><input type="text" name="lastName" readonly="readonly" value=<%=driverbean.getLastName() %>></tr>
<tr><td>License Number</td><td><input type="text" name=licenseNumber readonly="readonly" value=<%=driverbean.getLicenseNumber() %>></td></tr>
<tr><td>Contact Number</td><td><input type="text" name=contactNumber value=<%=driverbean.getContactNumber() %>></td></tr>

<tr><td></td><td><input type="hidden" name=driverid readonly="readonly" value=<%=dabean.getDriverid() %>></td></tr>
<tr><td>House Number</td><td><input type="text" name=houseNumber value=<%=dabean.getHouseNumber() %>></td></tr>
<tr><td>First Line Of Address</td><td><input type="text" name="firstLineOfAddress" value=<%=dabean.getFirstLineOfAddress() %>></tr>
<tr><td>Second Line Of Address</td><td><input type="text" name=secondLineOfAddress value=<%=dabean.getSecondLineOfAddress() %> ></td></tr>
<tr><td>City</td><td><input type="text" name=city value=<%=dabean.getCity() %>></td></tr>
<tr><td>State</td><td><input type="text" name=state value=<%=dabean.getState() %>></td></tr>
<tr><td>Pin Code</td><td><input type="text" name=pinCode value=<%=dabean.getPinCode() %>></td></tr>
<tr><td></td><td><input type="submit" value="Modify Driver"></td></tr>
</table>
</form>
<a href="home">GO to home</a>
</body>
</html>
