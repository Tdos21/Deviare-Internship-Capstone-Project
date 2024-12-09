package com.medicalsupplies.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalsupplies.medical.models.CartItem;



public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

}
