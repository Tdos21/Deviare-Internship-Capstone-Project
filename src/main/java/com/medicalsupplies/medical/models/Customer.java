package com.medicalsupplies.medical.models;

import java.time.LocalDate;
import java.util.Date;
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
@Table(name = "Customer")
public class Customer {
	


	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected int id;
	
	@Column(nullable = false)
	protected String custFullName;
	
	@Column(nullable = false)
	protected String custAge;
	
	@Column(nullable = false)
	protected String custAddress;
	
	@Column(nullable = false)
	protected String custEmail;
	
	@Column(nullable = false)
	protected String custPassword;
	
	@Column(nullable = false)
	protected String custPhone;
	
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Deliveries> deliveries;
    
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderTrack> track;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prescription> prescription;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Invoices> invoices;

	
	
	public Customer(Integer id, String custFullName, String custAge, String custAddress, String custEmail, String custPassword,
			String custPhone) {
		super();
		this.id = id;
		this.custFullName = custFullName;
		this.custAge = custAge;
		this.custAddress = custAddress;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.custPhone = custPhone;
		
		
	}

	public Customer() {
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustFullName() {
		return custFullName;
	}

	public void setCustFullName(String custFullName) {
		this.custFullName = custFullName;
	}

	

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustAge() {
		return custAge;
	}

	public void setCustAge(String custAge) {
		this.custAge = custAge;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custFullName=" + custFullName + ", custAge=" + custAge + ", custAddress="
				+ custAddress + ", custEmail=" + custEmail + ", custPassword=" + custPassword + ", custPhone="
				+ custPhone + "]";
	}

	

	
}
