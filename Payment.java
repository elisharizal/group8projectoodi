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

public class Payment {

    public boolean pay(double amount) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select Payment Method:");
        System.out.println("1. Card");
        System.out.println("2. E-Wallet");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.println("Card Payment Selected");
        } else if (choice == 2) {
            System.out.println("E-Wallet Payment Selected");
        } else {
            System.out.println("Invalid payment method.");
            return false;
        }
        
        System.out.println("Amount to pay: RM " + amount);
        System.out.print("Confirm payment? (yes/no): ");
        return sc.nextLine().equalsIgnoreCase("yes");
    }
}

