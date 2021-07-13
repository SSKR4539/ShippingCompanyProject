<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.shipping_Company.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body>

<%
	List<Client> clients = (List) session.getAttribute("clientList");
	

%>

   
   <table class="table table-striped" border= "5px solid" >
   
   <tr><th>Client Id</th>  <th> Name</th>  <th>Contact</th> <th>Item Shippes</th> <th>Date Shipped</th> <th>Date Received</th> <th>Update</th> <th>Delete</th></tr>
   
   <%
   
   
   for(Client cl: clients){
	   
	   //print html and dynamic data from session variable
   out.print("<tr><td>"+cl.getClientID()+"</td> <td>"+cl.getName()+"</td> <td>"+cl.getContact()+"</td> <td>"+cl.getItemShipped()+"</td>  <td>"+cl.getDateShipped()+"</td> <td>"+cl.getDateReceived()+"</td>  <td><a class='btn btn-primary' href='edit?cl_id="+cl.getClientID()+"' role='button'>Update</a></td> <td><a class='btn btn-primary' href='delete?cl_id="+cl.getClientID()+"' role='button'>Delete</a></td>  </tr>");
   
   }
   %>   
   
   </table>
   
   <a href='insert.jsp'>ADD NEW Client here</a><br><br>
   
</body>
</html>