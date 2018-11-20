/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.hotelmanagement.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author asys
 */
@Entity
@Table(name = "bill")
public class Bill extends AbstractEntity {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
  private Date entry;
  private Date exit;
   private float total;
   
   @OneToMany 
   private List<Room> rooms;
   
   @OneToOne
   private Customer customer;

    public Bill(Date entry, Date exit, float total, List<Room> rooms, Customer customer) {
        this.entry = entry;
        this.exit = exit;
        this.total = total;
        this.rooms = rooms;
        this.customer = customer;
    }

    public Bill() {
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

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public Customer getCustomer() {
        return customer;
    }

 
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

  
    public String toString() {
        return "com.ensi.ilsi.hotelmanagement.entities.Bill[ id=" + id + " ]";
    }
    
}
