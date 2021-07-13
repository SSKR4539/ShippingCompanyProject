<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Client Info</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<form action="insert" >
  <div class="form-group col-sm-5">
    <label for="cl_id">Client ID</label>    
    <input type="text" class="form-control" id="cl_id" name="cl_id" placeholder="Enter Client Id">   
  </div>
 
 <div class="form-group col-sm-5">
    <label for="cl_name">Client Name</label>
    <input type="text" class="form-control" id="cl_name" name="cl_name" placeholder="Enter Client Name">   
  </div>
  
  <div class="form-group col-sm-5">
    <label for="cl_contact">Client Contact</label>
    <input type="text" class="form-control" id="cl_contact" name="cl_contact" placeholder="Enter Client Contact">   
  </div>
  
  <div class="form-group col-sm-5">
    <label for="item_shipped">Item Shipped</label>
    <input type="text" class="form-control" id="item_shipped" name="item_shipped" placeholder="Enter Item Shipped">   
  </div>
  
  <div class="form-group col-sm-5">
    <label for="date_shipped">Date Shipped</label>
    <input type="date" class="form-control" id="date_shipped" name="date_shipped" placeholder="Enter Date Shipped">   
  </div>
  
  <div class="form-group col-sm-5">
    <label for="date_received">Date Received</label>
    <input type="date" class="form-control" id="date_received" name="date_received" placeholder="Enter Date Received">   
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<br><br>
     
     <a href="display.jsp">Go to display Page</a>
</body>
</html>