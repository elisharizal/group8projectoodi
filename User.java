/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.first;

/**
 *
 * @author Nasuha
 */
public abstract class User implements Discountable {
    protected String username;
    protected String password;

    public User(String u, String p) {
        username = u;
        password = p;
    }
    
    public boolean authenticate(String u, String p) {
        return username.equals(u) && password.equals(p);
    }
   public double getDiscountRate() {
        return 0.0; // default no discount
    } 
}

