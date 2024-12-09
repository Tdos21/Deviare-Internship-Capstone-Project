package com.medicalsupplies.medical.models;

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

	@Entity
	public class CartItem {
	    public CartItem(int id, String prodName, double unitPrice, boolean isActive, int recommendAge,
				List<Quotations> quotes, Cart cart) {
			super();
			this.id = id;
			this.prodName = prodName;
			this.unitPrice = unitPrice;
			this.isActive = isActive;
			this.recommendAge = recommendAge;
			this.quotes = quotes;
			this.cart = cart;
		}


		public CartItem() {
			super();
			// TODO Auto-generated constructor stub
		}


		@GeneratedValue(strategy = GenerationType.AUTO)
	    @Id
	    protected int id;
	    
	    @Column(nullable = false)
	    protected String prodName;
	   
	    @Column(nullable = true)
	    protected double unitPrice;
	    
	    @Column(nullable = false)
	    protected boolean isActive;
	    
	    @Column(nullable = false)
	    protected int recommendAge;

	    // Constructors
	    @OneToMany(mappedBy = "cartitems", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Quotations> quotes;
	    
	    
	    @ManyToOne
	    @JoinColumn(name="cartId")
	    private Cart cart;
	    
	    @ManyToOne
	    @JoinColumn(name="orderId")
	    private Orders orders;


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getProdName() {
			return prodName;
		}


		public void setProdName(String prodName) {
			this.prodName = prodName;
		}


		public double getUnitPrice() {
			return unitPrice;
		}


		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}


		public boolean isActive() {
			return isActive;
		}


		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}


		public int getRecommendAge() {
			return recommendAge;
		}


		public void setRecommendAge(int recommendAge) {
			this.recommendAge = recommendAge;
		}


		public List<Quotations> getQuotes() {
			return quotes;
		}


		public void setQuotes(List<Quotations> quotes) {
			this.quotes = quotes;
		}


		public Cart getCart() {
			return cart;
		}


		public void setCart(Cart cart) {
			this.cart = cart;
		}


		@Override
		public String toString() {
			return "CartItem [id=" + id + ", prodName=" + prodName + ", unitPrice=" + unitPrice + ", isActive="
					+ isActive + ", recommendAge=" + recommendAge + ", quotes=" + quotes + ", cart=" + cart + "]";
		}


		public Orders getOrders() {
			return orders;
		}


		public void setOrders(Orders orders) {
			this.orders = orders;
		}
	}



