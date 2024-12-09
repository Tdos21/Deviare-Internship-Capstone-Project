package com.medicalsupplies.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.medicalsupplies.medical.models.Admin;
import com.medicalsupplies.medical.models.Response;
import com.medicalsupplies.medical.repository.AdminRepository;


public class AdminController {
	
    @Autowired
   AdminRepository repository;
    
    @PostMapping(path = "/add")
    public ResponseEntity<Response> addAdmin(
            @RequestParam String adminName,
            @RequestParam String password
            ) {
        
        Admin add = new Admin(null, adminName, password);
        System.out.println("User: " + add);
        
        try {
            repository.save(add);
            Response response = new Response(101, "User " + adminName + " Saved Successfully");
            return new ResponseEntity<Response>(response, HttpStatus.OK);
            
        } catch (Exception exception) {
            Response response = new Response(701, "User " + adminName + " Not Saved Successfully. Exception: " + exception.getMessage());
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
