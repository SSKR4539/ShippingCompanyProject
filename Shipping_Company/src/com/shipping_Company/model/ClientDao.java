package com.shipping_Company.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ClientDao {
	

	//get Connection method
		public Connection getConnection() throws SQLException{

			//mysql database connection details
			String url = "jdbc:mysql://127.0.0.1:3306/shippingcompany";
			String user = "root";
			String pwd = "sumanthRAJU1998";

			Connection con = null ;

			//database connectivity code
			try {

				Class. forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url,user,pwd);
				System.out.println("connection sucessfull !!!");

				}

				catch(ClassNotFoundException e){

				e.printStackTrace();

				}

			return con;

		}
		


		public int insertRec(Client cl) throws SQLException {

			Connection con = getConnection();

			//sql insert statement
			String sql = "insert into clients (clientID,name,contact, itemShipped, dateShipped ,dateReceived) values(?,?,?,?,?,?)";

			int status = 0;

			try {
				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);

				pstmt.setInt(1, cl.getClientID());

				pstmt.setString(2, cl.getName());

				pstmt.setString(3, cl.getContact());

				pstmt.setString(4, cl.getItemShipped());

				pstmt.setString(5, cl.getDateShipped());

				pstmt.setString(6, cl.getDateReceived());

				status = pstmt.executeUpdate();

				if (status > 0) {

					System.out.println("Record Inserted Successfully!!!");
				}

				else {

					System.out.println("Try Again!");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;

		}

		public List<Client> showAllRec() throws SQLException  {

			//store all records in cls of list type
			List<Client> c = new ArrayList<>();

			String sql = "select * from clients";

			Connection con = getConnection();

			try {

				Statement stmt = (Statement) con.createStatement();

				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {

					Client cl = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6));

					c.add(cl);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;

		}

		public int delRecById(int clientId) throws SQLException {

			String sql = "delete from clients where clientID=?";

			int status = 0 ;

			Connection con = getConnection();

			try {

				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);

			    pstmt.setInt(1, clientId);

			    status = pstmt.executeUpdate();

			    if(status>0) {

			    	System.out.println("Record Deleted!");
			    }
			    else {

			    	System.out.println("Please Try Again!");
			    }


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;

		}

		public Client getRecById(int curr_id) throws SQLException {

			String sql = "select * from clients where clientID=?";

			Connection con = getConnection();

			Client cl = null ;

			try {

				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);

			    pstmt.setInt(1,curr_id);

			    ResultSet rs = pstmt.executeQuery();

			    if(rs.next()) {

			    	cl = new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));

			    }

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cl;
		}

		public int updateRec(Client updated_clnt,int old_id) throws SQLException {

			//update sql statement based on clientID
			String sql = "update clients set clientID=?,name=?,contact=?,itemShipped=?,dateShipped=?,dateReceived=? where clientID=?";

			int status = 0 ;

			Connection con = getConnection();

			try {

				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);

				pstmt.setInt(1, updated_clnt.getClientID());

				pstmt.setString(2, updated_clnt.getName());

				pstmt.setString(3, updated_clnt.getContact());

				pstmt.setString(4, updated_clnt.getItemShipped());

				pstmt.setString(5, updated_clnt.getDateShipped());

				pstmt.setString(6, updated_clnt.getDateReceived());

				pstmt.setInt(7,old_id);

			    status = pstmt.executeUpdate();

			    if(status>0) {

			    	System.out.println("Record Updated Successfully!");
			    }
			    else {

			    	System.out.println("Please Try Again!");
			    }

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		}
		

		public int checkRecExist(int id) throws SQLException {
			int status = 0;

			//select query to get record based on clientID
			String sql = "select * from clients where clientID = "+id;

			Connection con = getConnection();

			try {

				Statement stmt = (Statement) con.createStatement();

				ResultSet rs = stmt.executeQuery(sql);

				if(!rs.isBeforeFirst()) {
					status = 1;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		}

	}

