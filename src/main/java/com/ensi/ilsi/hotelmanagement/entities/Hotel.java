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
@Table(name= "hotel")
public class Hotel extends AbstractEntity {

@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

@Override
    public void setId(Long id) {
        this.id = id;
    }

@Override
    public Long getId() {
        return id;
    }

	@Column(name="name")
	private String name;

	@Column(name="address")
	private String address;

	@Column(name="stars")
	private int stars;

	@Column(name="nbRoom")
	private int nbRoom;

	public Hotel() {

	}

	public Hotel(String name, String address, int stars, int nbRoom) {

	this.name=name;
	this.address=address;
	this.stars=stars;
	this.nbRoom=nbRoom;
}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
}

	/**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

		/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
}

	/**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

		/**
	 * @return the stars
	 */
	public int getStars() {
		return stars;
}

	/**
     * @param stars the stars to set
     */
    public void setStars(int stars) {
        this.stars = stars;
    }		
 
		/**
	 * @return the nbRoom
	 */
	public int getNbRoom() {
		return nbRoom;
}

	/**
     * @param nbRoom the nbRoom to set
     */
    public void setNbRoom(int nbRoom) {
        this.nbRoom = nbRoom;
    }   

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ((Object) this).getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(name, hotel.name) &&
                Objects.equals(address, hotel.address) &&
                Objects.equals(stars, hotel.stars) &&
                Objects.equals(nbRoom, hotel.nbRoom);
        
    }

	public int hashCode() {
        return Objects.hash(name, address, stars, nbRoom);
    }
    
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", stars='" + stars + '\'' +
                ", nbRoom='" + nbRoom  +
                '}';
    }
}
