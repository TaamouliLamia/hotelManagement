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
public class CustomerDto {
    private Long id;
    private String name;
    private int age;
    private Boolean isMarried;
    private String phone;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, int age, Boolean isMarried, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
        this.phone = phone;
    }

   
}
