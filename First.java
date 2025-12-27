/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.first;

/**
 *
 * @author Nasuha
 */


import java.util.ArrayList;
import java.util.Scanner;

public class First {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===================== USER DECLARATION =====================
        User user;

        // ===================== SIGN UP =====================
        System.out.println("=== SIGN UP ===");
        System.out.print("Create username: ");
        String su = sc.nextLine();
        System.out.print("Create password: ");
        String sp = sc.nextLine();

        System.out.println("Select user type:");
        System.out.println("1. Normal Customer");
        System.out.println("2. Student");
        System.out.println("3. Staff");
        int type = sc.nextInt();
        sc.nextLine();

        if (type == 1) {
            user = new Customer(su, sp);
        } else if (type == 2) {
            user = new Student(su, sp);
        } else {
            user = new Staff(su, sp);
        }

        System.out.println("Account created successfully.\n");

        // ===================== LOGIN =====================
        System.out.println("=== LOGIN ===");
        System.out.print("Username: ");
        String lu = sc.nextLine();
        System.out.print("Password: ");
        String lp = sc.nextLine();

        if (!user.authenticate(lu, lp)) {
            System.out.println("Invalid username or password.");
            return;
        }

        System.out.println("Login successful.\n");
        
        boolean staffManageMovie = false;

        if (user instanceof Staff) {
            System.out.println("Select action:");
            System.out.println("1. Manage Movie");
            System.out.println("2. Book Ticket");
            System.out.print("Enter choice: ");
            int staffChoice = sc.nextInt();
            sc.nextLine();

            if (staffChoice == 1) {
                staffManageMovie = true;          
    }
            else if (staffChoice == 2) {
                staffManageMovie = false; // explicit booking
    }
}


        // ===================== MOVIE LIST =====================
        ArrayList<Movie> movies = new ArrayList<>();

        Movie movie1 = new Movie("Avengers");
        movie1.addShowtime("14:00");
        movie1.addShowtime("18:00");

        Movie movie2 = new Movie("Avatar");
        movie2.addShowtime("16:00");

        movies.add(movie1);
        movies.add(movie2);

        // ===================== STAFF MANAGE MOVIE =====================
        if (user instanceof Staff && staffManageMovie) {

            int choice;
            do {
                System.out.println("\n=== MANAGE MOVIE ===");
                System.out.println("1. Add Movie");
                System.out.println("2. Edit Movie");
                System.out.println("3. Delete Movie");
                System.out.println("4. View All Movies");
                System.out.println("5. End");
                System.out.print("Select option: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter movie title: ");
                        Movie newMovie = new Movie(sc.nextLine());
                        System.out.print("Enter showtime: ");
                        newMovie.addShowtime(sc.nextLine());
                        movies.add(newMovie);
                        System.out.println("Movie added.");
                        break;

                    case 2:
                        displayMovies(movies);
                        System.out.print("Select movie to edit: ");
                        int edit = sc.nextInt() - 1;
                        sc.nextLine();
                        if (edit >= 0 && edit < movies.size()) {
                            System.out.print("New title: ");
                            movies.get(edit).setTitle(sc.nextLine());
                        }
                        break;

                    case 3:
                        displayMovies(movies);
                        System.out.print("Select movie to delete: ");
                        int del = sc.nextInt() - 1;
                        sc.nextLine();
                        if (del >= 0 && del < movies.size()) {
                            movies.remove(del);
                        }
                        break;

                    case 4:
                        displayMovies(movies);
                        break;

                    case 5:
                        System.out.println("\nFinal Movie List:");
                        displayMovies(movies);
                        sc.close();
                        return; // 🔴 END PROGRAM

                    default:
                        System.out.println("Invalid option.");
                }

            } while (choice != 5);
        }

        // ===================== BOOKING (CUSTOMER / STUDENT) =====================
        System.out.println("=== AVAILABLE MOVIES ===");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getTitle());
        }

        System.out.print("Select movie: ");
        int movieChoice = sc.nextInt();
        sc.nextLine();
        Movie selectedMovie = movies.get(movieChoice - 1);

        // ===================== SHOWTIME =====================
        System.out.println("\nAvailable Showtimes:");
        for (int i = 0; i < selectedMovie.getShowtimes().size(); i++) {
            System.out.println((i + 1) + ". " + selectedMovie.getShowtimes().get(i));
        }

        System.out.print("Select showtime: ");
        int stChoice = sc.nextInt();
        sc.nextLine();
        String selectedShowtime = selectedMovie.getShowtimes().get(stChoice - 1);

        // ===================== SEAT =====================
        Seat[] seats = new Seat[5];
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat(i + 1);
        }

        Seat selectedSeat = null;
        while (true) {
            System.out.print("\nAvailable seats: ");
            for (Seat s : seats) {
                if (s.isAvailable()) {
                    System.out.print(s.getSeatNo() + " ");
                }
            }
            System.out.println();

            System.out.print("Select seat number: ");
            int seatNo = sc.nextInt();
            sc.nextLine();

            if (seatNo < 1 || seatNo > seats.length || !seats[seatNo - 1].isAvailable()) {
                System.out.println("Seat not available. Please choose again.");
            } else {
                selectedSeat = seats[seatNo - 1];
                break;
            }
        }

        // ===================== PRICE & DISCOUNT =====================
        double basePrice = 15.00;
        double discount = basePrice * user.getDiscountRate();
        double finalPrice = basePrice - discount;

        System.out.println("\nBase Price: RM " + basePrice);
        System.out.println("Discount: RM " + discount);
        System.out.println("Final Price: RM " + finalPrice);

        // ===================== PAYMENT =====================
        Payment payment = new Payment();
        while (!payment.pay(finalPrice)) {
            System.out.println("Payment failed. Please try again.");
        }

        // ===================== CONFIRM BOOKING =====================
        Booking booking = new Booking(selectedMovie, selectedShowtime, selectedSeat);
        booking.confirm();

        Ticket ticket = new Ticket();
        ticket.generate();

        System.out.println("\nBooking completed successfully.");
        System.out.println("\n===== RECEIPT =====");
        System.out.println("Movie      : " + selectedMovie.getTitle());
        System.out.println("Showtime   : " + selectedShowtime);
        System.out.println("Seat No    : " + selectedSeat.getSeatNo());
        System.out.println("User Type  : " + user.getClass().getSimpleName());
        System.out.println("Discount   : -RM " + discount);
        System.out.println("Amount Paid: RM " + finalPrice);
        System.out.println("===================");

        sc.close();
    }

    // ===================== HELPER METHOD =====================
    public static void displayMovies(ArrayList<Movie> movies) {
        System.out.println("\n=== MOVIE LIST ===");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getTitle());
        }
    }
}


