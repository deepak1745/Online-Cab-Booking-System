<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Modify Route </title>
</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome to Suhana Safar Travel Agency</h1>
<h2 align="center">Please give route id</h2>
</div>
<div align="center">
<h3 align="center" style="color: red;">${warning}</h3>
<form action="modifymainroute">
Route Id <input type="text" name="route_id"></input>
<input type="submit" value="submit">
</form>
</div>
<a href="home">GO to home</a>
</body>
</html>