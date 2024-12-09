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
@Table(name = "Prescription")
public class Prescription {

	

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected int id;
	 
	
	@Column(nullable = false)
	 protected String presImageUploaded;
	
	@Column(nullable = false)
	 protected LocalDate dateUploaded;
	
	@ManyToOne
	@JoinColumn(name="custId")
	private Customer customer;
	
	public Prescription(int id, String presImageUploaded, LocalDate dateUploaded, Customer customer) {
		super();
		this.id = id;
		this.presImageUploaded = presImageUploaded;
		this.dateUploaded = dateUploaded;
		this.customer = customer;
	}

	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPresImageUploaded() {
		return presImageUploaded;
	}

	public void setPresImageUploaded(String presImageUploaded) {
		this.presImageUploaded = presImageUploaded;
	}

	public LocalDate getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(LocalDate dateUploaded) {
		this.dateUploaded = dateUploaded;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Prescription [id=" + id + ", presImageUploaded=" + presImageUploaded + ", dateUploaded=" + dateUploaded
				+ ", customer=" + customer + "]";
	}
	
	
}
