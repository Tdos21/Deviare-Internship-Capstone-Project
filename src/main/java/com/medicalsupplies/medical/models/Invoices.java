package com.medicalsupplies.medical.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "Invoices")
public class Invoices {
	
	public Invoices(int id, double invTotal, LocalDate inv_Date, String inv_Items, int inv_itemsQuantity,
			Customer customer, Orders orders, Payment payment) {
		super();
		this.id = id;
		this.invTotal = invTotal;
		this.inv_Date = inv_Date;
		this.inv_Items = inv_Items;
		this.inv_itemsQuantity = inv_itemsQuantity;
		this.customer = customer;
		this.orders = orders;
		this.payment = payment;
	}

	public Invoices() {
		super();
		// TODO Auto-generated constructor stub
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected int id;
	
	
	@Column(nullable = false)
	protected double invTotal;
	
	@Column(nullable = false)
	protected LocalDate inv_Date;
	
	@Column(nullable = false)
	protected String inv_Items;
	
	@Column(nullable = false)
	protected int inv_itemsQuantity;
	
	@ManyToOne
	@JoinColumn(name="custId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private Orders orders;
	
	@OneToOne
	@JoinColumn(name="payId")
	private Payment payment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getInvTotal() {
		return invTotal;
	}

	public void setInvTotal(double invTotal) {
		this.invTotal = invTotal;
	}

	public LocalDate getInv_Date() {
		return inv_Date;
	}

	public void setInv_Date(LocalDate inv_Date) {
		this.inv_Date = inv_Date;
	}

	public String getInv_Items() {
		return inv_Items;
	}

	public void setInv_Items(String inv_Items) {
		this.inv_Items = inv_Items;
	}

	public int getInv_itemsQuantity() {
		return inv_itemsQuantity;
	}

	public void setInv_itemsQuantity(int inv_itemsQuantity) {
		this.inv_itemsQuantity = inv_itemsQuantity;
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
		return "Invoices [id=" + id + ", invTotal=" + invTotal + ", inv_Date=" + inv_Date + ", inv_Items=" + inv_Items
				+ ", inv_itemsQuantity=" + inv_itemsQuantity + ", customer=" + customer + ", orders=" + orders + "]";
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
