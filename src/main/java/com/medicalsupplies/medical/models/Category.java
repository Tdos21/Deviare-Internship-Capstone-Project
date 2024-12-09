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
@Table(name = "Category")
public class Category {
	
	public Category(Integer id, String catName, LocalDate dateCreated ) {
		
		this.id = id;
		this.catName = catName;
		this.dateCreated = dateCreated;
		
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected int id;
	
	@Column(nullable = false)
	protected String catName;
	
	@Column(nullable = false)
	protected LocalDate dateCreated;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medicine> brands;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<Medicine> getBrands() {
		return brands;
	}

	public void setBrands(List<Medicine> brands) {
		this.brands = brands;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", catName=" + catName + ", dateCreated=" + dateCreated + ", brands=" + brands
				+ "]";
	}


}
