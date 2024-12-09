package com.medicalsupplies.medical.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medicalsupplies.medical.models.Customer;
import com.medicalsupplies.medical.models.Deliveries;
import com.medicalsupplies.medical.models.Orders;
import com.medicalsupplies.medical.models.Response;
import com.medicalsupplies.medical.repository.DeliveriesRepository;


@Controller
@RequestMapping(path = "/delivery")
public class DeliveriesController {

	 @Autowired
	   DeliveriesRepository repository;
	    
	    @PostMapping(path = "/add")
	    public ResponseEntity<Response> addUser(
	            @RequestParam String delAddress,
	            @RequestParam LocalDate del_Date,
	            @RequestParam Customer customer,
	            @RequestParam Orders orders
	           
	            ) {
	        
	        Deliveries user = new Deliveries(null, delAddress, del_Date, customer, orders);
	        System.out.println("User: " + user);
	        
	        try {
	            repository.save(user);
	            Response response = new Response(101, "Delivery" + delAddress + " Saved Successfully");
	            return new ResponseEntity<Response>(response, HttpStatus.OK);
	            
	        } catch (Exception exception) {
	            Response response = new Response(701, "User " + delAddress + " Not Saved Successfully. Exception: " + exception.getMessage());
	            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
