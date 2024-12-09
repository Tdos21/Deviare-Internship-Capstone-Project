package com.medicalsupplies.medical.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	

	public Admin(Integer id, String adminName, String password) {
		
		this.id = id;
		this.adminName = adminName;
		this.password = password;
	}


	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected int id;
    
    @Column(nullable = false)
    protected String adminName;
    
    @Column(nullable = false)
    protected String password;
    
    
    public Admin() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", password=" + password + "]";
	}
    
    
    
}
