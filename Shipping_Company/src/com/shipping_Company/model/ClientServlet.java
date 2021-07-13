package com.shipping_Company.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String url = request.getServletPath();
		
		switch(url){
		

		case "/display":{
			
			   display(request, response);
			
			break ;
			   }
		case "/insert":{
			
			insert(request, response);
			break;
		}
		
		case "/edit":{
			
			editRec(request, response);
			break;
		}
		
		case "/delete":{
			
			delete(request, response);
			break;
		}
		
		case "/update":{
			
			update(request, response);
			break;
		}
		default:{
			
			out.print("Please enter a valid Url!!!!!");
		}
			
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int upd_id = Integer.parseInt(request.getParameter("upd_id"));		
		String upd_name = request.getParameter("upd_name");		
		String upd_contact = request.getParameter("upd_contact");		
		String upd_getShippedItem = request.getParameter("upd_getShippedItem");		
		String upd_getDateShipped = request.getParameter("upd_getDateShipped");		
		String upd_getDateReceived = request.getParameter("upd_getDateReceived");		
		HttpSession session = request.getSession();		
		int old_id = (int) session.getAttribute("old_id");		
		Client updated_emp = new Client(upd_id,upd_name,upd_contact,upd_getShippedItem, upd_getDateShipped, upd_getDateReceived);	
		ClientDao obj = new ClientDao();
		
		int status = 0;		
		if(upd_id != old_id) {
			try {
				status = obj.checkRecExist(upd_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			status = 1;
		}
		
		if(status == 1) {
			try {
				status = obj.updateRec(updated_emp, old_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			display(request, response);
		}else {
			
			PrintWriter out = response.getWriter(); 
			out.println("Client Id already exist");  
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		ClientDao obj = new ClientDao();
		int cl_id = Integer.parseInt(request.getParameter("cl_id"));
		
		try {
			obj.delRecById(cl_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		display(request, response);
		
		
	}

	private void editRec(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
				int cl_curr_id  = Integer.parseInt(request.getParameter("cl_id"));
				
				ClientDao obj = new ClientDao();
				
				//get info of client to be edited in cl by calling getRwcById method of ClientDao
				Client cl = null;
				try {
					cl = obj.getRecById(cl_curr_id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				HttpSession  session = request.getSession();
				
				//set clntToBeUpdated which stores client record to be updated
				session.setAttribute("clntToBeUpdated",cl );
				
				//previous id of client
				session.setAttribute("old_id",cl_curr_id );
				
				response.sendRedirect("update.jsp");
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.setContentType("text/html");
		
		//get parameters coming from form 
		int id = Integer.parseInt(request.getParameter("cl_id"));
		
		String name = request.getParameter("cl_name");
		
		String contact = request.getParameter("cl_contact");
		
		String item_shipped = request.getParameter("item_shipped");		
		
		String date_shipped = request.getParameter("date_shipped");
		
		String date_received = request.getParameter("date_received");
		
		//set client obj with data
		Client e = new Client(id,name,contact,item_shipped, date_shipped,date_received);
		
		ClientDao obj = new ClientDao();
		
		//checking id exist or not
		int status = 0;
		try {
			status = obj.checkRecExist(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(status == 1) {
			//if id does not exist call insertRec
			try {
				status = obj.insertRec(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			display(request, response);
		}else {
			PrintWriter out = response.getWriter(); 
			out.println("Client Id already exist");  
		}
	}

	private void display(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		ClientDao obj = new ClientDao();
		
		List<Client> clientList = null;
		try {
			clientList = obj.showAllRec();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("clientList", clientList);
		
		response.sendRedirect("display.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
