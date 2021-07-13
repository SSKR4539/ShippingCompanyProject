package com.shipping_Company.model;

import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ClientDao c = new ClientDao();
//		System.out.println(c.showAllRec());
		
		Client c1 = new Client(5,"Shawn Mendes","000000","Piano","2020-12-09","2020-12-22");
		System.out.println(c.insertRec(c1));
		
//		System.out.println(c.delRecById(6));
		
//		System.out.println(c.getRecById(5));
		
//		System.out.println(c.updateRec(c1, 5));

	}

}
