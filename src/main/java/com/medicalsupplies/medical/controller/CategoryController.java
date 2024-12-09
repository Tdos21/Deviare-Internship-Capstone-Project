package com.medicalsupplies.medical.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.medicalsupplies.medical.models.Category;
import com.medicalsupplies.medical.models.Response;
import com.medicalsupplies.medical.repository.CategoryRepository;

public class CategoryController {
	
	 @Autowired
	   CategoryRepository repository;
	    
	    @PostMapping(path = "/add")
	    public ResponseEntity<Response> addUser(
	            @RequestParam String categoryName,
	            @RequestParam LocalDate dateCreated
	    		) {
	        
	        Category user = new Category(null, categoryName, dateCreated);
	        System.out.println("User: " + user);
	        
	        try {
	            repository.save(user);
	            Response response = new Response(101, "Category " + categoryName + " Saved Successfully");
	            return new ResponseEntity<Response>(response, HttpStatus.OK);
	            
	        } catch (Exception exception) {
	            Response response = new Response(701, "Category " + categoryName + " Not Saved Successfully. Exception: " + exception.getMessage());
	            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
