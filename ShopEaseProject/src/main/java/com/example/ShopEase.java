package com.example;

import java.util.Scanner;

// Enum for Membership Status
enum MembershipStatus {
    REGULAR, SILVER, GOLD
}

// ShopEase System
public class ShopEase {

    // Method to calculate discount
    public static double calculateDiscount(MembershipStatus status, double orderValue) {
        if (orderValue < 0) {
            throw new IllegalArgumentException("Order value cannot be negative.");
        }
        double discount = 0.0;

        switch (status) {
            case REGULAR:
                discount = (orderValue >= 100) ? 0.05 : 0.0;
                break;
            case SILVER:
                discount = (orderValue >= 100) ? 0.15 : 0.10;
                break;
            case GOLD:
                discount = (orderValue >= 100) ? 0.20 : 0.15;
                break;
        }
        return orderValue * discount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Getting user input
            System.out.println("Enter membership status (REGULAR, SILVER, GOLD): ");
            MembershipStatus status = MembershipStatus.valueOf(scanner.next().toUpperCase());

            System.out.println("Enter order value: ");
            if (!scanner.hasNextDouble()) {
                throw new IllegalArgumentException();
            }
            double orderValue = scanner.nextDouble();

            // Calculate discount
            double discount = calculateDiscount(status, orderValue);

            // Display results
            System.out.println("Discount Applied: $" + discount);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input provided. Please enter a valid membership status and numeric order value.");
        } finally {
            scanner.close();
        }
    }
}