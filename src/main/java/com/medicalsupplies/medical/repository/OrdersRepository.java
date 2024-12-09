package com.medicalsupplies.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalsupplies.medical.models.Admin;
import com.medicalsupplies.medical.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
