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
@Table(name = "Product")
public class Medicine {



	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected int id;
	
	
	@Column(nullable = false)
	 protected String prodName;
	 
	 @ManyToOne
	 @JoinColumn(name="brandId", nullable=false)
	 private Brand brand;
	 
	 @ManyToOne
	 @JoinColumn(name="catId", nullable=false)
	 private Category category;
	 
	 @Column(nullable = false)
	 protected double unitPrice;
	 
	 @Column(nullable = false)
	 protected boolean isActive = false;
	 
	 @Column(nullable = false)
	 protected int recommendAge;
	 
	 @Column(nullable = false)
	 protected String prodDescription;
	 
	 
		public Medicine(Integer id, String prodName, Brand category, Category brand, double unitPrice, int recommendAge,
				boolean isActive, String prodDescription) {
			super();
			this.id = id;
			this.prodName = prodName;
			this.brand = category;
			this.category = brand;
			this.unitPrice = unitPrice;
			this.isActive = isActive;
			this.recommendAge = recommendAge;
			this.prodDescription = prodDescription;
		}

		public Medicine() {
			
		}

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

		public Brand getBrand() {
			return brand;
		}

		public void setBrand(Brand brand) {
			this.brand = brand;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
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

		public String getProdDescription() {
			return prodDescription;
		}

		public void setProdDescription(String prodDescription) {
			this.prodDescription = prodDescription;
		}

		@Override
		public String toString() {
			return "Medicine [id=" + id + ", prodName=" + prodName + ", brand=" + brand + ", category=" + category
					+ ", unitPrice=" + unitPrice + ", isActive=" + isActive + ", recommendAge=" + recommendAge
					+ ", prodDescription=" + prodDescription + "]";
		}
		
		
		
	 
	 
}
