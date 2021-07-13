<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.shipping_Company.model.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Client Info</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<!-- get session attribute to get client info to be updated -->
<%
   Client client = (Client)session.getAttribute("accounttobeupdated");

%>


<form action="update">
	<div class="form-group col-sm-5">
	    <label for="upd_id">Client ID</label>	    
	    <input type="text" class="form-control" id="cl_id" name="upd_id"  placeholder="Enter Client Id" value="<%=client.getClientID()  %>">
	</div>
	
	<div class="form-group col-sm-5">
	    <label for="upd_name">Client Name</label>	    
	    <input type="text" class="form-control" id="upd_name" placeholder="Enter Client Name" name="upd_name" value="<%=client.getName() %>" >

	</div>
	
	<div class="form-group col-sm-5">
	    <label for="upd_contact">Client Contact</label>	    
	    <input type="text" class="form-control" id="upd_contact" placeholder="Enter Client Contact" name="upd_contact" value="<%=client.getContact() %>" >

	</div>
	
	<div class="form-group col-sm-5">	    <label for="upd_getShippedItem">Item Shipped</label>	    
	    <input type="text" class="form-control" id="upd_getShippedItem" placeholder="Enter Item Shipped" name="upd_getShippedItem" value="<%=client.getItemShipped() %>" >

	</div>
	
	<div class="form-group col-sm-5">
	    <label for="upd_getDateShipped">Date Shipped</label>	    
	    <input type="date" class="form-control" id="upd_getDateShipped" placeholder="Enter Date Shipped" name="upd_getDateShipped" value="<%=client.getDateShipped() %>">
	</div>
	
	<div class="form-group col-sm-5">
	    <label for="upd_getDateReceived">Date Received</label>	    
	    <input type="date" class="form-control" id="upd_getDateReceived" placeholder="Enter Date Received" name="upd_getDateReceived" value="<%=client.getDateReceived() %>">

	</div>
	<input type="submit" class="btn btn-primary" value="Submit">

</form>

</body>
</html>