/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.hotelmanagement.web.Dto;

import java.util.Date;

/**
 *
 * @author asys
 */
public class BillDto {
    private Long id;
     private Date entry;
  private Date exit;
   private float total;

    public BillDto() {
    }

    public BillDto(Long id, Date entry, Date exit, float total) {
        this.id = id;
        this.entry = entry;
        this.exit = exit;
        this.total = total;
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
