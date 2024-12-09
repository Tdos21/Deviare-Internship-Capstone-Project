package com.medicalsupplies.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalsupplies.medical.models.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    
}