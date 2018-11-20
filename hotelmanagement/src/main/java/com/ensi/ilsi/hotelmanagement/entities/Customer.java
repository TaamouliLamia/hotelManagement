/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.hotelManagement.Entities;
import com.ensi.ilsi.hotelManagement.Entities.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author USER
 */
@Entity
@Table(name = "customer")
public class Customer extends AbstractEntity {
    
    
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
  
    
    @Column(name="name")
    private String name;
    
    @Column(name="age")
    private int age;
    
    @Column (name="isMarried")
    private Boolean isMarried;
    
    @Column (name="phone")
    private String phone;
    
    
    public Customer() {
        
    }
    
    public Customer(String name, int age, Boolean isMarried, String phone) {
        
        this.name=name;
        this.age=age;
        this.isMarried=isMarried;
        this.phone=phone;
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
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the isMarried
     */
    public Boolean getIsMarried() {
        return isMarried;
    }

    /**
     * @param isMarried the isMarried to set
     */
    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ((Object) this).getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(age, customer.age) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(isMarried, customer.isMarried);
        
    }
    
    public int hashCode() {
        return Objects.hash(name, age, phone, isMarried);
    }
    
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", isMarried='" + isMarried  +
                '}';
    }

 
}
