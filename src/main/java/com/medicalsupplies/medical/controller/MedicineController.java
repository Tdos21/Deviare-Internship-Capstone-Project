package com.medicalsupplies.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medicalsupplies.medical.models.Brand;
import com.medicalsupplies.medical.models.Category;
import com.medicalsupplies.medical.models.Customer;
import com.medicalsupplies.medical.models.Medicine;
import com.medicalsupplies.medical.models.Response;
import com.medicalsupplies.medical.repository.CustomerRepository;
import com.medicalsupplies.medical.repository.MedicineRepository;


@Controller
@RequestMapping(path = "/medicine")
public class MedicineController {
	
	 @Autowired
	   MedicineRepository repository;
	    
	    @PostMapping(path = "/add")
	    public ResponseEntity<Response> addUser(
	            @RequestParam String prodName,
	            @RequestParam Category category,
	            @RequestParam Brand brand,
	            @RequestParam double unitPrice,
	            @RequestParam int recommendAge,
	            @RequestParam boolean isActive,
	            @RequestParam String prodDescription
	            ) {
	        
	        Medicine user = new Medicine(null, prodName, brand, category, unitPrice,recommendAge,isActive, prodDescription);
	        System.out.println("Medicine: " + user);
	        
	        try {
	            repository.save(user);
	            Response response = new Response(101, "Medicine Saved Successfully");
	            return new ResponseEntity<Response>(response, HttpStatus.OK);
	            
	        } catch (Exception exception) {
	            Response response = new Response(701, "Medicine Not Saved Successfully. Exception: " + exception.getMessage());
	            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
