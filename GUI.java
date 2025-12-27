package com.mycompany.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FirstGUI extends JFrame {

    // Swing components
    private JLabel titleLabel;
    private JLabel imageLabel;
    private JTextField nameField;
    private JTextArea outputArea;
    private JButton bookButton;

    // Your existing data
    private ArrayList<Movie> movies;

    public FirstGUI() {

        // ================== FRAME ==================
        setTitle("Movie Ticket Booking System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ================== MOVIE DATA (from your project) ==================
        movies = new ArrayList<>();
        movies.add(new Movie("Avengers"));
        movies.add(new Movie("Fast & Furious"));
        movies.add(new Movie("Frozen"));

        // ================== TOP PANEL ==================
        JPanel topPanel = new JPanel(new FlowLayout());

        titleLabel = new JLabel("Movie Booking System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        ImageIcon icon = new ImageIcon("movie.png"); // add image to project folder
        imageLabel = new JLabel(icon);

        topPanel.add(titleLabel);
        topPanel.add(imageLabel);

        // ================== CENTER PANEL ==================
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));

        nameField = new JTextField();
        nameField.setBorder(BorderFactory.createTitledBorder("Enter Customer Name"));

        bookButton = new JButton("Book Ticket");

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createTitledBorder("Booking Details"));

        centerPanel.add(nameField);
        centerPanel.add(bookButton);
        centerPanel.add(new JScrollPane(outputArea));

        // ================== BUTTON ACTION ==================
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String customerName = nameField.getText();

                if (customerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your name");
                    return;
                }

                // Use your existing classes
                Customer customer = new Customer(customerName);
                Movie selectedMovie = movies.get(0); // sample selection
                Ticket ticket = new Ticket(selectedMovie);

                outputArea.setText(
                        "Customer Name: " + customer.getName() +
                        "\nMovie: " + selectedMovie.getTitle() +
                        "\nTicket booked successfully!"
                );
            }
        });

        // ================== ADD TO FRAME ==================
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // ================== MAIN ==================
    public static void main(String[] args) {
        new FirstGUI();
    }
}
