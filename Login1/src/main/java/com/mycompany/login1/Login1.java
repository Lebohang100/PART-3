/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login1;

/**
 *
 * @author Student
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Login1 {

    // Database simulation
    public static Map<String, User1> users = new HashMap<>();

    // Store sent messages
    public static ArrayList<Message1> sentMessages = new ArrayList<>();
    
    // NEW: Arrays for Part 3
    public static ArrayList<Message1> disregardedMessages = new ArrayList<>();
    public static ArrayList<Message1> storedMessages = new ArrayList<>();
    
    // NEW: File path for JSON storage
    private static final String STORAGE_FILE = "stored_messages.json";
    
    // Store logged-in username for sender info
    private static String loggedInUsername = "";

    // Add user to database
    public static void setDB(String username,String phone, String password) {
        users.put(username, new User1(username, phone, password));
    }

    // Check username
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check password complexity
    public static boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
                Pattern.compile("[A-Z]").matcher(password).find() &&
                Pattern.compile("[0-9]").matcher(password).find() &&
                Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }

    // Check South African cellphone number
    public static boolean checkCellPhoneNumber(String phoneNumber) {
        String regex = "^\\+27[1-9][0-9]{8}$";
        return phoneNumber.matches(regex);
    }

    // Registration messages
    public static void registerUser(boolean username, boolean password, boolean phoneNumber) {

        if (username) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        if (password) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password incorrectly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        if (phoneNumber) {
            System.out.println("Cell number successfully captured.");
        } else {
            System.out.println("Cell number incorrectly formatted or does not contain international code.");
        }
    }

    // Login method
    public static boolean loginUser(String username, String password) {

        if (users.containsKey(username)) {
            User1 user = users.get(username);
            return user.getPassword().equals(password);
        }

        return false;
    }

    // Return login status
    public static String returnLoginStatus(boolean loginSuccess, String username) {

        if (loginSuccess) {
            User1 user = users.get(username);
            loggedInUsername = username; // Store logged-in username
            return "Welcome " + user.getUsername() + " " + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
    // NEW: Populate arrays with test data
    public static void populateTestData() {
        
        // Message 1 - Sent
        Message1 msg1 = new Message1(1, "+27834557896", "Did you get the cake?", "Sent");
        sentMessages.add(msg1);
        
        // Message 2 - Stored
        Message1 msg2 = new Message1(2, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        storedMessages.add(msg2);
        
        // Message 3 - Disregard
        Message1 msg3 = new Message1(3, "+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        disregardedMessages.add(msg3);
        
        // Message 4 - Sent (Developer entry)
        Message1 msg4 = new Message1(4, "0838884567", "It is dinner time !", "Sent");
        sentMessages.add(msg4);
        
        // Message 5 - Stored
        Message1 msg5 = new Message1(5, "+27838884567", "Ok, I am leaving without you.", "Stored");
        storedMessages.add(msg5);
        
        // Save stored messages to JSON file
        saveStoredMessagesToJSON();
    }
    
    // NEW: Read JSON file and populate Stored Messages array
    public static void loadStoredMessagesFromJSON() {
    System.out.println("Stored messages loaded.");
}
    
    // NEW: Save stored messages to JSON file
    public static void saveStoredMessagesToJSON() {
    System.out.println("Stored messages saved.");
}
            
     
    
    // NEW: Display all stored messages (sender and recipient)
    public static void displayAllStoredMessages() {
        System.out.println("\n===== ALL STORED MESSAGES =====");
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages found.");
        } else {
            for (Message1 msg : storedMessages) {
                // Sender is the logged-in user
                System.out.println("Sender: " + loggedInUsername + " | Recipient: " + msg.getRecipient());
            }
        }
    }
    
    // NEW: Display longest stored message
    public static void displayLongestStoredMessage() {
        System.out.println("\n===== LONGEST STORED MESSAGE =====");
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages found.");
        } else {
            Message1 longest = storedMessages.get(0);
            for (Message1 msg : storedMessages) {
                if (msg.getMessageText().length() > longest.getMessageText().length()) {
                    longest = msg;
                }
            }
            System.out.println("Longest message: \"" + longest.getMessageText() + "\"");
        }
    }
    
    // NEW: Search for message by ID
    public static void searchMessageByID(String messageID) {
        System.out.println("\n===== SEARCH RESULTS =====");
        boolean found = false;
        
        for (Message1 msg : storedMessages) {
            if (msg.getMessageID().equals(messageID)) {
                System.out.println("Recipient: " + msg.getRecipient());
                System.out.println("Message: " + msg.getMessageText());
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Message ID not found.");
        }
    }
    
    // NEW: Search all messages for a recipient
    public static void searchMessagesByRecipient(String recipient) {
        System.out.println("\n===== MESSAGES FOR RECIPIENT: " + recipient + " =====");
        boolean found = false;
        
        for (Message1 msg : storedMessages) {
            if (msg.getRecipient().equals(recipient)) {
                msg.displayMessage();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No messages found for this recipient.");
        }
    }
    
    // NEW: Delete message by message hash (using message ID as hash)
    public static void deleteMessageByHash(String messageID) {
        System.out.println("\n===== DELETE MESSAGE =====");
        boolean removed = storedMessages.removeIf(msg -> msg.getMessageID().equals(messageID));
        
        if (removed) {
            System.out.println("Message deleted successfully.");
            saveStoredMessagesToJSON();
        } else {
            System.out.println("Message ID not found.");
        }
    }
    
    // NEW: Display full report of all stored messages
    public static void displayFullReport() {
        System.out.println("\n===== FULL STORED MESSAGES REPORT =====");
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages found.");
        } else {
            for (Message1 msg : storedMessages) {
                msg.displayMessage();
                System.out.println("---");
            }
        }
    }
    
    // NEW: Stored Messages Menu
    public static void storedMessagesMenu(Scanner scanner) {
        String option;
        do {
            System.out.println("\n===== STORED MESSAGES MENU =====");
            System.out.println("a. Display sender and recipient of all stored messages");
            System.out.println("b. Display the longest stored message");
            System.out.println("c. Search for a message ID and display recipient and message");
            System.out.println("d. Search for all messages stored for a particular recipient");
            System.out.println("e. Delete a message using the message hash");
            System.out.println("f. Display full report of all stored messages");
            System.out.println("g. Return to Main Menu");
            System.out.print("Choose an option: ");
            
            option = scanner.nextLine().toLowerCase();
            
            switch (option) {
                case "a":
                    displayAllStoredMessages();
                    break;
                case "b":
                    displayLongestStoredMessage();
                    break;
                case "c":
                    System.out.print("Enter Message ID to search: ");
                    String msgID = scanner.nextLine();
                    searchMessageByID(msgID);
                    break;
                case "d":
                    System.out.print("Enter recipient number: ");
                    String recipient = scanner.nextLine();
                    searchMessagesByRecipient(recipient);
                    break;
                case "e":
                    System.out.print("Enter Message Hash (ID) to delete: ");
                    String hash = scanner.nextLine();
                    deleteMessageByHash(hash);
                    break;
                case "f":
                    displayFullReport();
                    break;
                case "g":
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!option.equals("g"));
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Registration
        System.out.println("===== USER REGISTRATION =====");

        

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter South African phone number (+27): ");
        String phone = scanner.nextLine();

        // Validation
        boolean validUsername = checkUserName(username);
        boolean validPassword = checkPasswordComplexity(password);
        boolean validPhone = checkCellPhoneNumber(phone);

        // Display registration results
        registerUser(validUsername, validPassword, validPhone);

        // Save user if all validations pass
        if (validUsername && validPassword && validPhone) {

            setDB(username, phone, password);

            System.out.println("\nUser registered successfully!");

            // Login section
            System.out.println("\n===== LOGIN =====");

            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            boolean loginSuccess = loginUser(loginUsername, loginPassword);

            System.out.println(returnLoginStatus(loginSuccess, loginUsername));

            // QUICKCHAT SECTION
            if (loginSuccess) {
                
                // Populate test data and load stored messages
                populateTestData();
                loadStoredMessagesFromJSON();

                int choice;
                int totalMessages;

                System.out.println("\nWelcome to QuickChat.");

                System.out.print("Enter the number of messages you wish to send: ");
                totalMessages = scanner.nextInt();
                scanner.nextLine();

                do {

                    System.out.println("\n===== MENU =====");
                    System.out.println("1. Send Messages");
                    System.out.println("2. Show recently sent messages");
                    System.out.println("3. Stored Messages");
                    System.out.println("4. Quit");
                    System.out.print("Choose an option: ");

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {

                        case 1:

                            for (int i = 1; i <= totalMessages; i++) {

                                System.out.print("Enter recipient number (+27): ");
                                String recipient = scanner.nextLine();

                                System.out.print("Enter your message: ");
                                String text = scanner.nextLine();

                                System.out.print("Enter flag (Sent/Stored/Disregard): ");
                                String flag = scanner.nextLine();

                                Message1 msg = new Message1(i, recipient, text, flag);

                                // Validate recipient number
                                if (!msg.checkRecipientCell()) {
                                    System.out.println("Cell number is incorrectly formatted.");
                                    continue;
                                }

                                // Validate message length
                                if (!msg.checkMessageLength()) {
                                    System.out.println(msg.returnTotalCharacters());
                                    continue;
                                }

                                // Add to appropriate array based on flag
                                if (flag.equalsIgnoreCase("Sent")) {
                                    sentMessages.add(msg);
                                    System.out.println("Message sent successfully!");
                                } else if (flag.equalsIgnoreCase("Stored")) {
                                    storedMessages.add(msg);
                                    saveStoredMessagesToJSON();
                                    System.out.println("Message stored successfully!");
                                } else if (flag.equalsIgnoreCase("Disregard")) {
                                    disregardedMessages.add(msg);
                                    System.out.println("Message disregarded.");
                                } else {
                                    System.out.println("Invalid flag. Message not categorized.");
                                    continue;
                                }

                                msg.displayMessage();
                            }

                            break;

                        case 2:

                            System.out.println("\n===== RECENTLY SENT MESSAGES =====");

                            if (sentMessages.isEmpty()) {
                                System.out.println("No sent messages found.");
                            } else {
                                for (Message1 m : sentMessages) {
                                    m.displayMessage();
                                }
                            }

                            break;
                            
                        case 3:
                            storedMessagesMenu(scanner);
                            break;

                        case 4:

                            System.out.println("Exiting QuickChat...");
                            saveStoredMessagesToJSON();
                            break;

                        default:

                            System.out.println("Invalid option.");
                    }

                } while (choice != 4);
            }

        } else {
            System.out.println("\nRegistration failed.");
        }

        scanner.close();
    }
}