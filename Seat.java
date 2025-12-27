/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.first;

/**
 *
 * @author Nasuha
 */
public class Seat {
    private int seatNo;
    private boolean available = true;

    public Seat(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getSeatNo(){
        return seatNo;
    }
    public boolean isAvailable() {
        return available;
    }

    public void book() {
        available = false;
   
    }
}


