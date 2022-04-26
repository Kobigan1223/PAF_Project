<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="model.Customer" %>
<%

if (request.getParameter("bill_number") != null)
{
	if (request.getParameter("bill_number") != null)
	 {
	 Customer itemObj = new Customer();
	 String stsMsg = itemObj.insertbill(request.getParameter("bill_number"),
	 request.getParameter("prev_read"),
	 request.getParameter("cur_read"),
	 request.getParameter("bill_amount"),
	 request.getParameter("due_amount"),
	 request.getParameter("billing_date"),
	 request.getParameter("user_id")
	
			 );
	 session.setAttribute("statusMsg", stsMsg);
	 } 
}

//Delete item----------------------------------
if (request.getParameter("bill_id") != null)
{
	Customer itemObj = new Customer();
String stsMsg = itemObj.deletebill(request.getParameter("bill_id"));
session.setAttribute("statusMsg", stsMsg);
} 

%>

<html>
<head>
<link rel="stylesheet" href="views/bootstrap.min.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="View/bootstrap.min.css">

<title>Bill Management</title>
</head>

<body>

<h1> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;Customer management</h1>
<form method="post" action="Customer.jsp">
<div class="container">
 <div class="row">
 <div class="col">


 customer Name: <input name="bill_number" type="text"  class="form"><br>
 customer Phone: <input name="" type="text"  class="form"><br>
 customer Email: <input name="customerEmail" type="text"  class="form"><br>
  customer Password: <input name="customerPassword" type="password"  class="form"><br>
 <input name="btnSubmit" type="submit" value="Save"class="btn btn-primary"><br>

 </div>
 </div>
</div>
</form>
<div class="alert-success">
 <% out.print(session.getAttribute("statusMg"));%>
</div>
<br>
<%
Customer itemObj = new Customer();
 out.print(itemObj.readItems());
%>

</body>
</html>