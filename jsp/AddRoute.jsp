<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome Admin</h1>
<h1 align="center">Welcome to Suhana Safar Travel Agency </h1>
</div>
<h1>${Warning}</h1>
<h1 align="center"> Route details </h1>
<form  action="routemain" METHOD=POST>
<table align="center">
<tr><td> source</td><td><input type="text" name="source" ></td></tr>
<tr><td>destination</td><td><input type="text" name="destination"></td></tr>
<tr><td>distance</td><td><input type="text" name="distance" value=0></td></tr>
<tr><td>duration</td><td><input type="text" name="duration" value=0></td></tr>

<tr><td></td><td><input type="submit" value="Add Route"></td></tr>
</table>
</form>
<a href="home">GO to home</a>
</body>
</html>