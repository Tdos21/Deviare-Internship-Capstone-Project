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
@Table(name = "Brand")
public class Brand {
	
	public Brand(Integer id, String brandName, LocalDate dateCreated) {
		
		this.id = id;
		this.brandName = brandName;
		this.dateCreated = dateCreated;
		
	}

	public Brand() {
		
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected int id;
	
	@Column(nullable = false)
	protected String brandName;
	
	@Column(nullable = false)
	protected LocalDate dateCreated;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medicine> meds;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	

	@Override
	public String toString() {
		return "Brand [id=" + id + ", brandName=" + brandName + ", dateCreated=" + dateCreated + ", meds=" + meds + "]";
	}

	
	
}
