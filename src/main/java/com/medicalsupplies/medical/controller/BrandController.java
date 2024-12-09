package com.medicalsupplies.medical.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.medicalsupplies.medical.models.Brand;
import com.medicalsupplies.medical.models.Response;
import com.medicalsupplies.medical.repository.BrandRepository;


public class BrandController {
	
    @Autowired
   BrandRepository repository;
    
    @PostMapping(path = "/add")
    public ResponseEntity<Response> addUser(
            @RequestParam String brandName,
            @RequestParam LocalDate dateCreated
    		) {
        
        Brand user = new Brand(null, brandName, dateCreated);
        System.out.println("User: " + user);
        
        try {
            repository.save(user);
            Response response = new Response(101, "User " + brandName + " Saved Successfully");
            return new ResponseEntity<Response>(response, HttpStatus.OK);
            
        } catch (Exception exception) {
            Response response = new Response(701, "User " + brandName + " Not Saved Successfully. Exception: " + exception.getMessage());
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
