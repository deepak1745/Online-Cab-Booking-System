<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.wipro.ata.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
ul li {display: inline-block;width: 300px;}
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
body{background-image: url("");
}
</style>


</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome <%=session.getAttribute("loginid") %></h1>
<h1 align="center">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Welcome to Suhana Safar Travel Agency &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <a href="logout">Logout</a></h1>

</div>

<div>
  <ul>
    <li>
      <a href="#">Bookings</a>
      <ul>
        <li><a href="BookVehicleNow">Book Vehicle Now</a></li>
        <li><a href="Cancellation">Cancellation</a></li>
        <li><a href="PrintTicket">Print Ticket</a></li>
        <li><a href="BookingHistory">Booking History</a></li>
      </ul>
    </li>
    <li>
      <a href="#">Your Profile</a>
      <ul>
        <li><a href="#">View Profile</a></li>
        <li><a href="#">Edit Profile</a></li>
      </ul>
    </li>
  </ul>
</div>
 <h1>${Warning}</h1>
 <%-- <%PaymentHistoryBean history=(PaymentHistoryBean)session.getAttribute("history"); %>
 <h1> Your CreditCard <%=history.getCreditCardNumber()%> has been credited <%=history.getTotalFare() %> rupees </h1> --%>
</body>
</html>