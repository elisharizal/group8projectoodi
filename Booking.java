/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.first;

/**
 *
 * @author Nasuha
 */
public class Booking {
    private Movie movie;
    private String showtime;
    private Seat seat;

    public Booking(Movie movie, String showtime, Seat seat) { //composition
        this.movie = movie;
        this.showtime = showtime;
        this.seat = seat;
    }

    public void confirm() {
        seat.book();
        System.out.println("Booking confirmed.");
    }
}


