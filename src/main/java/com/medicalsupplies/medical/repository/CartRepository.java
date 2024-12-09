package com.medicalsupplies.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalsupplies.medical.models.Cart;



public interface CartRepository extends JpaRepository<Cart, Integer>{

}
