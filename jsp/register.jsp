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
<h3 align="center" style="color: red;">${message}</h3>
<h1 align="center">Welcome to Travel Agency</h1>
</div>
<form action="registerMain" METHOD=POST>
<table align="center">
<tr><td> choose LoginID</td><td><input type="text" name=login_id ></td>
<td>${login_id_message}</td></tr>
<tr><td>Password</td><td><input type="text" name=password></td>
<td>${warning}</td></tr>
<tr><td>Confirm Password</td><td><input type="text" name=con_password></td></tr>
<tr><td>First Name</td><td><input type="text" name=firstName></td></tr>
<tr><td>Last Name</td><td><input type="text" name=lastName></td></tr>
<tr><td>Date of Birth</td><td><input type="text" name=dateOfBirth placeholder="DD/MM/YYYY" size="10" maxlength="10"></td>
<td>${message}</td></tr>
<tr><td>Gender</td><td><input type="radio" name="gender" value="male">Male<br>
                       <input type="radio" name="gender" value="female">Female</td></tr>
<tr><td>Mobile Number</td><td><input type="text" name=mobileNumber></td></tr>
<tr><td><input type="hidden" name="userType" value="C"></input></td></tr>
<tr><td></td><td><input type="submit" value="submit"></td></tr>
</table>
</form>
</body>
</html>