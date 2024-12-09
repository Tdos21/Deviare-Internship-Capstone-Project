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
@Table(name = "Orders")
public class Orders {
	
	

	public Orders(Integer id, double orderTotal, LocalDate order_Date, int itemsQuantity, Customer customer,
			Orders orders, List<CartItem> items) {
		super();
		this.id = id;
		this.orderTotal = orderTotal;
		this.order_Date = order_Date;
		this.itemsQuantity = itemsQuantity;
		this.customer = customer;
		this.items = items;
	}

	public Orders() {
		
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected int id;
	
	@Column(nullable = false)
	protected double orderTotal;
	
	@Column(nullable = false)
	protected LocalDate order_Date;
	
	
	@Column(nullable = false)
	protected int itemsQuantity;
	
	@ManyToOne
	@JoinColumn(name="custId")
	private Customer customer;
	
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public LocalDate getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(LocalDate order_Date) {
		this.order_Date = order_Date;
	}

	public int getItemsQuantity() {
		return itemsQuantity;
	}

	public void setItemsQuantity(int itemsQuantity) {
		this.itemsQuantity = itemsQuantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderTotal=" + orderTotal + ", order_Date=" + order_Date + ", itemsQuantity="
				+ itemsQuantity + ", customer=" + customer + ", items=" + items + "]";
	}

	
}
