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
<title>Admin</title>
<style type="text/css">
ul li {display: inline-block;width: 245px;}
ul li ul li:hover {background: maroon;}
ul li ul li a {display:block !important;}
ul li ul li {
  background: #555;
  display: block;
}
ul li:hover ul {display: block;}
ul li ul {
  position: absolute;
  width: 100px;
  display: none;
}
ul {
  display: inline;
  margin: 0;
  padding: 0;
}
div a {
    text-decoration: none;
    color: white;
    font-size: 20px;
    padding: 15px;
    display:inline-block;
}
div{
background-color: green;}
body{background-image: url("http://www.haripriyacarrentals.com/car-rent-kolhapur/haripriya-travels-car-rental-kolhapur_08.jpg");
}
#main{
color: #fff;
}
body{
margin-left: 0px;
margin-right: 0px;
}
.menu li{
margin-left: 4%;
}
</style>


</head>
<body bgcolor=CadetBlue >
<div id ="main" style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center" style="margin-top:2%;">Welcome Admin</h1>
<h1 align="center" style="margin-left:21%;"> Welcome to Suhana Safar Travel Agency<a href="logout" style="color: #cc0000;font-size:22px; margin-left:18%;">Logout</a></h1>

</div>

<div>
  <ul class="menu">
    <li>
      <a href="#">Vehicle</a>
      <ul>
        <li><a href="AddVehicle">Add Vehicle</a></li>
        <li><a href="Delete">Delete Vehicle</a></li>
        <li><a href="ModifyVehicle">Modify Vehicle</a></li>
        <li><a href="ViewAll">View Vehicle</a></li>
      </ul>
    </li>
    <li>
      <a href="#">Driver</a>
      <ul>
        <li><a href="AddDriver">Add Driver</a></li>
        <li><a href="DeleteDriver">Delete Driver</a></li>
        <li><a href="ModifyDriver">Modify Driver</a></li>
        <li><a href="ViewAllDriver">View Driver</a></li>
      </ul>
    </li>
     <li>
      <a href="#">Route</a>
      <ul>
        <li><a href="AddRoute">Add Route</a></li>
        <li><a href="DeleteRoute">Delete Route</a></li>
        <li><a href="ModifyRoute">Modify Route</a></li>
        <li><a href="ViewAllRoute">View Route</a></li>
      </ul>
    </li>

     <li>
      <a href="#">Customer</a>
      <ul>
        <li><a href="BookedTicketsAll">Booked Tickets</a></li>
      </ul>
    </li>

  </ul>
</div>
 <h1>${Warning}</h1>
</body>
</html>
