/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.hotelmanagement.repository;

import com.ensi.ilsi.hotelManagement.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author asys
 */
public interface BillRepository extends JpaRepository<Customer, Long>{
    
}
