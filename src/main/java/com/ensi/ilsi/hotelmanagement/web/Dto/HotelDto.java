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
public class HotelDto {
    private Long id;
    private String name;
private String address;
private int stars;
private int nbRoom;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setNbRoom(int nbRoom) {
        this.nbRoom = nbRoom;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getStars() {
        return stars;
    }

    public int getNbRoom() {
        return nbRoom;
    }

    public HotelDto(Long id, String name, String address, int stars, int nbRoom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.nbRoom = nbRoom;
    }

    public HotelDto() {
    }

    
}
