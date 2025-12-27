/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.first;

/**
 *
 * @author Nasuha
 */
public class Customer extends User { //inheritance
//private int age;

    public Customer(String u, String p) {
        super(u,p);
    }
    
    @Override
    public double getDiscountRate() {
        return 0.0;
    }
}

