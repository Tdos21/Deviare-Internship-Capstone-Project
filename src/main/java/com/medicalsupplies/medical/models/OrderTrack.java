package com.medicalsupplies.medical.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "OrderTrack")
	public class OrderTrack {
		
		

		@GeneratedValue(strategy = GenerationType.AUTO)
	    @Id
	    protected int id;
		
		
		@Column(nullable = false)
		 protected String tractStatus;
		 protected boolean isActive;
		 
		 @ManyToOne
		 @JoinColumn(name="custId")
		 private Customer customer;
		 
		 @ManyToOne
		 @JoinColumn(name="delId")
		 private Deliveries deliveries;
		 
		 public OrderTrack(int id, String tractStatus, boolean isActive, Customer customer, Deliveries deliveries) {
				super();
				this.id = id;
				this.tractStatus = tractStatus;
				this.isActive = isActive;
				this.customer = customer;
				this.deliveries = deliveries;
			}

			public OrderTrack() {
				super();
				// TODO Auto-generated constructor stub
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getTractStatus() {
				return tractStatus;
			}

			public void setTractStatus(String tractStatus) {
				this.tractStatus = tractStatus;
			}

			public boolean isActive() {
				return isActive;
			}

			public void setActive(boolean isActive) {
				this.isActive = isActive;
			}

			public Customer getCustomer() {
				return customer;
			}

			public void setCustomer(Customer customer) {
				this.customer = customer;
			}

			public Deliveries getDeliveries() {
				return deliveries;
			}

			public void setDeliveries(Deliveries deliveries) {
				this.deliveries = deliveries;
			}

			@Override
			public String toString() {
				return "OrderTrack [id=" + id + ", tractStatus=" + tractStatus + ", isActive=" + isActive
						+ ", customer=" + customer + ", deliveries=" + deliveries + "]";
			}
			
			
			
}
