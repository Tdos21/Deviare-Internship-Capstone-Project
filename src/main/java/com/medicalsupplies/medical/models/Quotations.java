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
@Table(name = "Quotations")
public class Quotations {
	
		@GeneratedValue(strategy = GenerationType.AUTO)
	    @Id
	    protected int id;
		
		@Column(nullable = false)
		protected double quoTotal;
		
		@Column(nullable = false)
		protected LocalDate quo_Date;
		
		@Column(nullable = false)
		protected String quo_Items;
		
		@Column(nullable = false)
		protected int quo_itemsQuantity;
		
		@ManyToOne
		@JoinColumn(name="cart_itemsId")
		private CartItem cartitems;
		
		public Quotations(int id, double quoTotal, LocalDate quo_Date, String quo_Items, int quo_itemsQuantity,
				CartItem cartitems) {
			super();
			this.id = id;
			this.quoTotal = quoTotal;
			this.quo_Date = quo_Date;
			this.quo_Items = quo_Items;
			this.quo_itemsQuantity = quo_itemsQuantity;
			this.cartitems = cartitems;
		}

			public Quotations() {
			super();
			// TODO Auto-generated constructor stub
		}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public double getQuoTotal() {
				return quoTotal;
			}

			public void setQuoTotal(double quoTotal) {
				this.quoTotal = quoTotal;
			}

			public LocalDate getQuo_Date() {
				return quo_Date;
			}

			public void setQuo_Date(LocalDate quo_Date) {
				this.quo_Date = quo_Date;
			}

			public String getQuo_Items() {
				return quo_Items;
			}

			public void setQuo_Items(String quo_Items) {
				this.quo_Items = quo_Items;
			}

			public int getQuo_itemsQuantity() {
				return quo_itemsQuantity;
			}

			public void setQuo_itemsQuantity(int quo_itemsQuantity) {
				this.quo_itemsQuantity = quo_itemsQuantity;
			}

			public CartItem getCartitems() {
				return cartitems;
			}

			public void setCartitems(CartItem cartitems) {
				this.cartitems = cartitems;
			}

			@Override
			public String toString() {
				return "Quotations [id=" + id + ", quoTotal=" + quoTotal + ", quo_Date=" + quo_Date + ", quo_Items="
						+ quo_Items + ", quo_itemsQuantity=" + quo_itemsQuantity + ", cartitems=" + cartitems + "]";
			}
     
			
			
	

}
