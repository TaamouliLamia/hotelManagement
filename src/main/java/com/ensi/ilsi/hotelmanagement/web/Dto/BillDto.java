/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.hotelmanagement.web.Dto;

import com.ensi.ilsi.hotelManagement.Entities.Customer;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author asys
 */
public class BillDto {
  private Long id;
  private Date entry;
  private Date exit;
  private float total;
  private Set<RoomDto> rooms ;
  private CustomerDto customer;

    public BillDto() {
    }

    public BillDto(Long id, Date entry, Date exit, float total, Set<RoomDto> rooms, CustomerDto customer) {
        this.id = id;
        this.entry = entry;
        this.exit = exit;
        this.total = total;
        this.rooms = rooms;
        this.customer = customer;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    
    public Set<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(Set<RoomDto> rooms) {
        this.rooms = rooms;
    }

   
    public Long getId() {
        return id;
    }

    public Date getEntry() {
        return entry;
    }

    public Date getExit() {
        return exit;
    }

    public float getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public void setExit(Date exit) {
        this.exit = exit;
    }

    public void setTotal(float total) {
        this.total = total;
    }
   
    
}
