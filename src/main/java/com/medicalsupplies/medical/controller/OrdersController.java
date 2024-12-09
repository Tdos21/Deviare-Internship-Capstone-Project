package com.medicalsupplies.medical.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medicalsupplies.medical.models.CartItem;
import com.medicalsupplies.medical.models.Customer;
import com.medicalsupplies.medical.models.Orders;
import com.medicalsupplies.medical.models.Response;
import com.medicalsupplies.medical.repository.OrdersRepository;


@Controller
@RequestMapping(path = "/orders")
public class OrdersController {
	
	@Autowired
	   OrdersRepository repository;
	    
	    @PostMapping(path = "/add")
	    public ResponseEntity<Response> addOrders(
	            @RequestParam double orderTotal,
	            @RequestParam LocalDate pay_Date,
	            @RequestParam int itemsQuantity,
	            @RequestParam Customer customer,
	            @RequestParam Orders orders,
	            @RequestParam List<CartItem> items
	            
	            ) {
	        
	        Orders user = new Orders(null, orderTotal, pay_Date, itemsQuantity, customer,orders,items);
	        System.out.println("Orders: " + user);
	        
	        try {
	            repository.save(user);
	            Response response = new Response(101, "Order created Successfully");
	            return new ResponseEntity<Response>(response, HttpStatus.OK);
	            
	        } catch (Exception exception) {
	            Response response = new Response(701, "Order Not Successfully. Exception: " + exception.getMessage());
	            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
