package com.medicalsupplies.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalsupplies.medical.models.Admin;
import com.medicalsupplies.medical.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
