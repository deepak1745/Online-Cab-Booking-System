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
<title>Register</title>
<style type="text/css">
#main{
color: #fff;
}
body{
margin-left: 0px;
margin-right: 0px;
margin-top: 0px;
}
#home{
text-decoration : none;
font-weight: 500;
font-size: 20px;
margin: 2.5%;
margin-bottom: 4%;
}
table{
 padding-top: 2%;
}
td{
color: #fff;
}
</style>
</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h3 align="center" style="color: red;">${message}</h3>
<h1 align="center" style="color: #fff; margin-top: 2%; margin-bottom: 2%;">Welcome to Suhana Safar Travel Agency </h1>
</div>
<form action="registerMain" METHOD=POST>
<table align="center" cellspacing="10">
<tr><td> Enter LoginID</td><td><input type="text" name=login_id autofocus ></td>
<td>${login_id_message}</td></tr>
<tr><td>Password</td><td><input type="text" name=password></td>
<td>${warning}</td></tr>
<tr><td>Confirm Password</td><td><input type="text" name=con_password></td></tr>
<tr><td>First Name</td><td><input type="text" name=firstName></td></tr>
<tr><td>Last Name</td><td><input type="text" name=lastName></td></tr>
<tr><td>Date of Birth</td><td><input type="text" name=dateOfBirth placeholder="DD/MM/YYYY" size="10" maxlength="10"" style="padding: 2px;"></td>
<td>${message}</td></tr>
<tr><td>Gender</td><td><input type="radio" name="gender" value="male">Male
                       <input type="radio" name="gender" value="female">Female</td></tr>
<tr><td>Mobile Number</td><td><input type="text" name=mobileNumber></td></tr>
<tr><td><input type="hidden" name="userType" value="C"></input></td></tr>
<tr><td></td><td><input type="submit" value="Submit" style="margin: 6%; margin-left: 33%; background-color: #5cb85c; color:#fff; border-color: #4cae4c; padding:3%; font-size:15px;"></td></tr>
</table>
</form>
</body>
</html>
