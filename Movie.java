/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.first;

/**
 *
 * @author Nasuha
 */
import java.util.ArrayList;

public class Movie {
    private String title;
    private ArrayList<String> showtimes = new ArrayList<>();

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addShowtime(String time) {
        showtimes.add(time);
    }

    public ArrayList<String> getShowtimes() {
        return showtimes;
    }
    
    public void setTitle(String title) {
    this.title = title;
}

}

