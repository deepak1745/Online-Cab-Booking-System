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
<title>Delete Route</title>
<style>

body{
margin-left: 0px;
margin-right: 0px;
margin-top: 0px;
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
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center" style="color: #fff; margin-top: 3%; margin-bottom:4%;">Welcome to Suhana Safar Travel Agency</h1>

</div>
<a id="home" href="home">Home</a>
<h2 align="center" style="color:maroon;">Please Give Route Id to be deleted</h2>
<div align="center">
<h3 align="center" style="color: red;">${warning}</h3>
<form action="deletemainroute">
<span id="vNumber"> Route Id </span><input type="text" name="route_id"></input>
<input type="submit" value="Submit" style="margin-left: .5%; background-color: #5cb85c; color:#fff; border-color: #4cae4c;">
</form>
</div>

</body>
</html>
