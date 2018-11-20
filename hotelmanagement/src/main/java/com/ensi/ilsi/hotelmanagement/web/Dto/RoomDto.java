/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.hotelmanagement.web.Dto;

/**
 *
 * @author asys
 */
public class RoomDto {
    private Long id;
    private int number;
    private int nbBeds;
    private float price;

    public RoomDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNbBeds(int nbBeds) {
        this.nbBeds = nbBeds;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public RoomDto(Long id, int number, int nbBeds, float price) {
        this.id = id;
        this.number = number;
        this.nbBeds = nbBeds;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getNbBeds() {
        return nbBeds;
    }

    public float getPrice() {
        return price;
    }
    
    
}
