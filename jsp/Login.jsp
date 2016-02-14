<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <style>
body
{
background-image: url("http://www.carhirebangalore.com/images/car1.jpg");
}
</style>

</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h3 align="center" style="color:660033;">${message}</h3>
<h1 align="center">Welcome to Suhana Safar Travel Agency</h1>
</div>
<div>
<div style="width: 50%;height:300px; background-color:CadetBlue ; float: left;"> prem kumar</div>
<div style="width: 50%;height: 300px; text-align:center; background-color:CadetBlue ; color:red; float: right;">
<form action="login" METHOD=POST>
<table align="center">
<tr><td>LoginID</td><td><input type="text" name=login_id></td></tr>
<tr><td>Password</td><td><input type="text" name=password></td></tr>
<tr><td></td><td><input type="submit" value="submit"></td></tr>
</table>
</form>
 <b><a href="register">New user? Register here</a></b>
</div>
</div>
</body>
</html>