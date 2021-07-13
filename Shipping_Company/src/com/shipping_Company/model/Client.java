package com.shipping_Company.model;

public class Client {
	//client variables 
		private int clientID;
		private String name;
		private String contact;
		private String itemShipped;
		private String dateShipped;
		private String dateReceived;
		
		
		
		//constructor 
		public Client(int clientID, String name, String contact, String itemShipped, String dateShipped, String dateReceived) {
			super();
			this.clientID = clientID;
			this.name = name;
			this.contact = contact;
			this.itemShipped = itemShipped;
			this.dateShipped = dateShipped;
			this.dateReceived = dateReceived;
			
		}

		//getters and setters 
		public int getClientID() {
			return clientID;
		}

		public void setClientID(int clientID) {
			this.clientID = clientID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getItemShipped() {
			return itemShipped;
		}

		public void setItemShipped(String itemShipped) {
			this.itemShipped = itemShipped;
		}

		public String getDateReceived() {
			return dateReceived;
		}

		public void setDateReceived(String dateReceived) {
			this.dateReceived = dateReceived;
		}

		public String getDateShipped() {
			return dateShipped;
		}

		public void setDateShipped(String dateShipped) {
			this.dateShipped = dateShipped;
		}
		
		public Client() {
			super();
			// TODO Auto-generated constructor stub
		}
		//toString method 
		@Override
		public String toString() {
			return "Client [clientID=" + clientID + ", name=" + name + ", contact=" + contact + ", itemShipped="
					+ itemShipped + ", dateReceived=" + dateReceived + ", dateShipped=" + dateShipped + "]";
		}
		
		
		
	}
