package com.medicalsupplies.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalsupplies.medical.models.Admin;
import com.medicalsupplies.medical.models.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer>{

}
