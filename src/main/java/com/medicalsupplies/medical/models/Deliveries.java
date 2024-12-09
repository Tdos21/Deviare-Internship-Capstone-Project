package com.medicalsupplies.medical.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "Deliveries")
public class Deliveries {
	
	public Deliveries(Integer id, String delAddress, LocalDate del_Date, Customer customer, Orders orders) {
		super();
		this.id = id;
		this.delAddress = delAddress;
		this.del_Date = del_Date;
		this.customer = customer;
		this.orders = orders;
	}

	public Deliveries() {
		super();
		// TODO Auto-generated constructor stub
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected int id;
	
	@Column(nullable = false)
	protected String delAddress;
	
	@Column(nullable = false)
	protected LocalDate del_Date;
	
	@ManyToOne
	@JoinColumn(name="custId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private Orders orders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDelAddress() {
		return delAddress;
	}

	public void setDelAddress(String delAddress) {
		this.delAddress = delAddress;
	}

	public LocalDate getDel_Date() {
		return del_Date;
	}

	public void setDel_Date(LocalDate del_Date) {
		this.del_Date = del_Date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Deliveries [id=" + id + ", delAddress=" + delAddress + ", del_Date=" + del_Date + ", customer="
				+ customer + ", orders=" + orders + "]";
	}
	
	

}
