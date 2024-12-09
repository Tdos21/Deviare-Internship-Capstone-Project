package com.medicalsupplies.medical.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;




@Entity
@Table(name = "Payment")
public class Payment {
	
	

		@GeneratedValue(strategy = GenerationType.AUTO)
	    @Id
	    protected int id;
		
		@Column(nullable = false)
		protected double totalPaySucess;
		
		@Column(nullable = false)
		protected LocalDate pay_Date;
		
		@Column(nullable = false)
		protected String payStatus;
		
		@ManyToOne
		@JoinColumn(name="custId", nullable=false)
		private Customer customer;
		
		@ManyToOne
		@JoinColumn(name="orderId", nullable=false)
		private Orders orders;
		
		@OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<Invoices> invoices;
		
		public Payment(Integer id, double totalPaySucess, LocalDate pay_Date, String payStatus, Customer customer, Orders orders) {
			super();
			this.id = id;
			this.totalPaySucess = totalPaySucess;
			this.pay_Date = pay_Date;
			this.payStatus = payStatus;
			this.customer = customer;
			this.orders = orders;
		}

			public Payment() {
			
		}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public double getTotalPaySucess() {
				return totalPaySucess;
			}

			public void setTotalPaySucess(double totalPaySucess) {
				this.totalPaySucess = totalPaySucess;
			}

			public LocalDate getPay_Date() {
				return pay_Date;
			}

			public void setPay_Date(LocalDate pay_Date) {
				this.pay_Date = pay_Date;
			}

			public String getPayStatus() {
				return payStatus;
			}

			public void setPayStatus(String payStatus) {
				this.payStatus = payStatus;
			}

			public Customer getCustomer() {
				return customer;
			}

			public void setCustomer(Customer customer) {
				this.customer = customer;
			}

			@Override
			public String toString() {
				return "Payment [id=" + id + ", totalPaySucess=" + totalPaySucess + ", pay_Date=" + pay_Date
						+ ", payStatus=" + payStatus + ", customer=" + customer + "]";
			}

			public Orders getOrders() {
				return orders;
			}

			public void setOrders(Orders orders) {
				this.orders = orders;
			}
			
			

}
