/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.hotelManagement.Entities;



import javax.persistence.*;


import java.util.Objects;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "room")
public class Room extends AbstractEntity{
    
  @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

  @Override
    public Long getId() {
        return id;
    }

  @Override
    public void setId(Long id) {
        this.id = id;
    }
  
    @Column(name="number")
    private int number;
    
    @Column(name="nbBeds")
    private int nbBeds;
    
    @Column(name="price")
    private float price;
    
     @Column(name="occupied")
    private Boolean occupied;
     
    @ManyToOne 
    private Hotel hotel;
    
    
    public Room() {
        
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public Room(int number, int nbBeds, float price, Boolean occupied, Hotel hotel) {
        this.number = number;
        this.nbBeds = nbBeds;
        this.price = price;
        this.occupied = occupied;
        this.hotel = hotel;
    }
    
   

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the nbBeds
     */
    public int getNbBeds() {
        return nbBeds;
    }

    /**
     * @param nbBeds the nbBeds to set
     */
    public void setNbBeds(int nbBeds) {
        this.nbBeds = nbBeds;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * @param hotel the hotel to set
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
     public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ((Object) this).getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(number, room.number) &&
                Objects.equals(nbBeds, room.nbBeds) &&
                Objects.equals(price, room.price) &&
                Objects.equals(hotel, room.hotel);
        
    }
      public int hashCode() {
        return Objects.hash(number, nbBeds, price, hotel);
    }
    
    public String toString() {
        return "Room{" +
                "number='" + number + '\'' +
                ", nbBeds='" + nbBeds + '\'' +
                ", price='" + price + '\'' +
                ", hotel='" + hotel  +
                '}';
    }
   
    
    
    
    
}
