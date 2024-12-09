package com.medicalsupplies.medical.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.medicalsupplies.medical.models.Cart;
import com.medicalsupplies.medical.models.Response;
import com.medicalsupplies.medical.repository.CartRepository;

public class CartController {
	
	 @Autowired
	   CartRepository repository;
	    
	    @PostMapping(path = "/add")
	    public ResponseEntity<Response> addUser(
	            @RequestParam LocalDate dateCreated,
	            @RequestParam double cartTotal,
	            @RequestParam List cartItems
	    		) {
	        
	        Cart user = new Cart(null, dateCreated, cartTotal, cartItems);
	        System.out.println("User: " + user);
	        
	      
	        try {
	            repository.save(user);
	            Response response = new Response(101, "Cart ADDED Successfully");
	            return new ResponseEntity<Response>(response, HttpStatus.OK);
	            
	        } catch (Exception exception) {
	            Response response = new Response(701, "Cart Not Saved Successfully. Exception: " + exception.getMessage());
	            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        
	        
	    }

}
