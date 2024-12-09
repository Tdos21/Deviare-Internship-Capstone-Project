package com.medicalsupplies.medical.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Cart")
public class Cart {
	
	public Cart(Integer id, LocalDate dateCreated, double cartTotal, List<CartItem> cartitems) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.cartTotal = cartTotal;
		this.cartitems = cartitems;
	}


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(nullable = false)
	private LocalDate dateCreated;
	
	@Column(nullable = false)
	private double cartTotal;
	
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartitems;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}


	public double getCartTotal() {
		return cartTotal;
	}


	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}


	public List<CartItem> getCartitems() {
		return cartitems;
	}


	public void setCartitems(List<CartItem> cartitems) {
		this.cartitems = cartitems;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", dateCreated=" + dateCreated + ", cartTotal=" + cartTotal + ", cartitems="
				+ cartitems + "]";
	}
	
	
	
}
