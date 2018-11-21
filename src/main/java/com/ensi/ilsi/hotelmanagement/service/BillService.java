/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.hotelmanagement.service;

import com.ensi.ilsi.hotelManagement.Entities.Customer;
import com.ensi.ilsi.hotelmanagement.entities.Bill;
import com.ensi.ilsi.hotelmanagement.repository.BillRepository;
import com.ensi.ilsi.hotelmanagement.repository.CustomerRepository;
import com.ensi.ilsi.hotelmanagement.repository.RoomRepository;
import com.ensi.ilsi.hotelmanagement.web.Dto.BillDto;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asys
 */
public class BillService {
    
    private final Logger log = LoggerFactory.getLogger(BillService.class);

    private final BillRepository billRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    public BillService(BillRepository billRepository, CustomerRepository customerRepository,
            RoomRepository roomRepository) {
        this.billRepository = billRepository;
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
    }

    public BillDto create(Long customerId, BillDto billDto) {
       Customer  customer = this.customerRepository.findById(customerId)
                    .orElseThrow(() -> new IllegalStateException("The Customer does not exist!"));

            log.debug("Request to create Bill : {}", billDto);
        return mapToDto(
                this.billRepository.save(
                       
                       new Bill(
                                billDto.getEntry(),
                                billDto.getExit(),
                                billDto.getTotal(), 
                               Collections.emptySet(),
                               customer)
                )
        );
       
    }

    public List<BillDto> findAll() {
        log.debug("Request to get all Bills");
        return this.billRepository.findAll()
                .stream()
                .map(BillService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BillDto findById(Long id) {
        log.debug("Request to get Bill : {}", id);
        return this.billRepository.findById(id).map(BillService::mapToDto).orElse(null);
    }

   

    public void delete(Long id) {
        log.debug("Request to delete Bill : {}", id);
        this.billRepository.deleteById(id);
    }

    public static BillDto mapToDto(Bill bill) {
        if (bill != null) {
            return new BillDto(
                 
            		bill.getId(),
            		bill.getEntry(),
            		bill.getExit(),
                    bill.getTotal(),
                    bill.getRooms().stream().map(RoomService::mapToDto).collect(Collectors.toSet()),
                    CustomerService.mapToDto(bill.getCustomer())
            );
        }
        return null;
    }

    
}
