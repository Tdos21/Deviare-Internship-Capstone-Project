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
import com.medicalsupplies.medical.models.Orders;
import com.medicalsupplies.medical.models.Payment;
import com.medicalsupplies.medical.models.Response;

import com.medicalsupplies.medical.repository.PaymentRepository;


@Controller
@RequestMapping(path = "/payments")
public class PaymentsController {
	
	 @Autowired
	   PaymentRepository repository;
	    
	    @PostMapping(path = "/add")
	    public ResponseEntity<Response> addPayment(
	            @RequestParam double totalPaySuccess,
	            @RequestParam LocalDate pay_Date,
	            @RequestParam String payStatus,
	            @RequestParam Customer customer,
	            @RequestParam Orders orders
	            
	            ) {
	        
	        Payment user = new Payment(null, totalPaySuccess, pay_Date, payStatus, customer,orders);
	        System.out.println("Medicine: " + user);
	        
	        try {
	            repository.save(user);
	            Response response = new Response(101, "Payment created Successfully");
	            return new ResponseEntity<Response>(response, HttpStatus.OK);
	            
	        } catch (Exception exception) {
	            Response response = new Response(701, "Medicine Not Successfully. Exception: " + exception.getMessage());
	            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
