/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomcoferenceBooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConferenceRoomBooking bookingSystem = new ConferenceRoomBooking();
        bookingSystem.addConferenceRoom(new ConferenceRoom("Room A"));
        bookingSystem.addConferenceRoom(new ConferenceRoom("Room B"));
        bookingSystem.addConferenceRoom(new ConferenceRoom("Room C"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to the Conference Room Booking System!");
            System.out.println("1. User Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> userMenu(bookingSystem, scanner);
                case 2 -> adminMenu(bookingSystem, scanner);
                case 3 -> {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void userMenu(ConferenceRoomBooking bookingSystem, Scanner scanner) {
    System.out.println("\nUser Login");
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: "); // You can add password handling logic here
    String password = scanner.nextLine();

    // Assuming successful login
    while (true) {
        // Display available rooms
        System.out.println("\nAvailable Rooms:");
        bookingSystem.displayAvailableRooms();

        System.out.println("\nUser Menu:");
        System.out.println("1. Book a Room");
        System.out.println("2. Cancel Booking");
        System.out.println("3. Logout");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> {
                System.out.print("Enter room name to book: ");
                String bookRoomName = scanner.nextLine();
                if (bookingSystem.bookRoom(bookRoomName)) {
                    System.out.println("Room booked successfully.");
                } else {
                    System.out.println("Room is either not available or does not exist.");
                }
            }
            case 2 -> {
                System.out.print("Enter room name to cancel booking: ");
                String cancelRoomName = scanner.nextLine();
                if (bookingSystem.cancelBooking(cancelRoomName)) {
                    System.out.println("Booking canceled successfully.");
                } else {
                    System.out.println("Room is either not booked or does not exist.");
                }
            }
            case 3 -> {
                System.out.println("Logging out...");
                return;
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }
}


    public static void adminMenu(ConferenceRoomBooking bookingSystem, Scanner scanner) {
    System.out.println("\nAdmin Login");
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: "); // You can add password handling logic here
    String password = scanner.nextLine();

    // Assuming successful login
    while (true) {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Display All Rooms");
        System.out.println("2. Add a Room");
        System.out.println("3. Remove a Room");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> bookingSystem.displayAllRooms();
            case 2 -> {
                System.out.print("Enter room name to add: ");
                String roomName = scanner.nextLine();
                bookingSystem.addConferenceRoom(new ConferenceRoom(roomName));
                System.out.println("Room added successfully.");
                System.out.println("\nAvailable Rooms:");
                bookingSystem.displayAvailableRooms(); // Display available rooms after adding
            }
            case 3 -> {
                System.out.print("Enter room name to remove: ");
                String roomName = scanner.nextLine();
                if (bookingSystem.removeConferenceRoom(roomName)) {
                    System.out.println("Room removed successfully.");
                    System.out.println("\nAvailable Rooms:");
                    bookingSystem.displayAvailableRooms(); // Display available rooms after removing
                } else {
                    System.out.println("Room does not exist.");
                }
            }
            case 4 -> {
                System.out.println("Logging out...");
                return;
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }
}
}