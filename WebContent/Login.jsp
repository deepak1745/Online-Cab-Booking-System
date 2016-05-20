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
<title>Login</title>

 <style>
body
{
background-image: url("http://www.carhirebangalore.com/images/car1.jpg");
}
table{
   padding-top: 4%;

}
td{
color: #cc0000;
}
#link{
padding-left: 11%;
margin-top: 4%;
text-decoration: none;
}
#submit{
margin-top: 5%;
margin-bottom: 3%;
}
body{
margin-left: 0px;
margin-right:0px;
}
#heading{
font-weight: 600;
color: #fff;
}
</style>

</head>
<body bgcolor=CadetBlue>
<div class="main" style="text-align:center; padding:5px;background-color: Teal;">
<h3 align="center" style="color:660033;">${message}</h3>
<h1 id="heading" align="center">Welcome to Suhana Safar Travel Agency</h1>
</div>
<div>
<div style="width: 46%; height:246px; font-size: 20px; background-color:CadetBlue ; color:#fff; float: left; padding: 2%"> Deepak Kumar</div>
<div style="width: 46%; height: 246px; text-align:center; background-color:CadetBlue ; color:red; float: right; padding: 2%;">
<form action="login" METHOD=POST>
<table align="center" cellspacing="5">
<tr><td>LoginID</td><td><input type="text" name=login_id></td></tr>
<tr><td>Password</td><td><input type="text" name=password></td></tr>
<tr><td></td><td><input type="submit" id="submit" value="submit"></td></tr>
</table>
</form>
 <b><a id="link" href="register">New user? Register here</a></b>
</div>
</div>
</body>
</html>
