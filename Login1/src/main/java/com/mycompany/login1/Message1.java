/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login1;

/**
 *
 * @author Student
 */


import java.util.Random;

public class Message1 {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String flag; // Sent, Stored, Disregard

    // Constructor
    public Message1(int messageNumber, String recipient,
                    String messageText, String flag) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = flag;
        this.messageID = generateMessageID();
    }

    // Optional constructor
    public Message1(int messageNumber, String recipient,
                    String messageText) {

        this(messageNumber, recipient, messageText, "Sent");
    }

    // Generate 10-digit Message ID
    private String generateMessageID() {

        Random random = new Random();
        long number = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // Validate recipient number
    public boolean checkRecipientCell() {

        return recipient.matches("^\\+27[1-9][0-9]{8}$");
    }

    // Validate message length
    public boolean checkMessageLength() {

        return messageText.length() <= 250;
    }

    // Return character warning
    public String returnTotalCharacters() {

        int extra = messageText.length() - 250;

        return "Message exceeds 250 characters by "
                + extra + " characters.";
    }

    // Display message details
    public void displayMessage() {

        System.out.println("\n===== MESSAGE DETAILS =====");
        System.out.println("Message ID: " + messageID);
        System.out.println("Message Number: " + messageNumber);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + messageText);
        System.out.println("Status: " + flag);
    }

    // Getters
    public String getMessageID() {
        return messageID;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getFlag() {
        return flag;
    }

    // Setters
    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}  