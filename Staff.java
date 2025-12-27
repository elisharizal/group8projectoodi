/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.first;

/**
 *
 * @author Nasuha
 */
import java.util.Scanner;
public class Staff extends User {

    public Staff(String u, String p){
        super(u,p);
    }
    
     @Override
    public double getDiscountRate() {
        return 0.30;
    }
    
    public void manageMovie() {
        System.out.println("Staff managing movie listings...");
    }
}

