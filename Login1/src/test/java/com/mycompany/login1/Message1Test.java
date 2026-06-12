/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login1;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class Message1Test {
    
    public Message1Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkRecipientCell method, of class Message1.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        Message1 instance = null;
        boolean expResult = false;
        boolean result = instance.checkRecipientCell();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageLength method, of class Message1.
     */
    @Test
    public void testCheckMessageLength() {
        System.out.println("checkMessageLength");
        Message1 instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sentMessage method, of class Message1.
     */
    @Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        Message1 instance = null;
        String expResult = "";
        String result = instance.sentMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessage method, of class Message1.
     */
    @Test
    public void testPrintMessage() {
        System.out.println("printMessage");
        Message1 instance = null;
        String expResult = "";
        String result = instance.printMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class Message1.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int expResult = 0;
        int result = Message1.returnTotalMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadMessages method, of class Message1.
     */
    @Test
    public void testLoadMessages() {
        System.out.println("loadMessages");
        List<Message1> expResult = null;
        List<Message1> result = Message1.loadMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllMessages method, of class Message1.
     */
    @Test
    public void testDisplayAllMessages() {
        System.out.println("displayAllMessages");
        Message1.displayAllMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalCharacters method, of class Message1.
     */
    @Test
    public void testReturnTotalCharacters() {
        System.out.println("returnTotalCharacters");
        Message1 instance = null;
        String expResult = "";
        String result = instance.returnTotalCharacters();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMessage method, of class Message1.
     */
    @Test
    public void testDisplayMessage() {
        System.out.println("displayMessage");
        Message1 instance = null;
        instance.displayMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageID method, of class Message1.
     */
    @Test
    public void testGetMessageID() {
        System.out.println("getMessageID");
        Message1 instance = null;
        String expResult = "";
        String result = instance.getMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageNumber method, of class Message1.
     */
    @Test
    public void testGetMessageNumber() {
        System.out.println("getMessageNumber");
        Message1 instance = null;
        int expResult = 0;
        int result = instance.getMessageNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecipient method, of class Message1.
     */
    @Test
    public void testGetRecipient() {
        System.out.println("getRecipient");
        Message1 instance = null;
        String expResult = "";
        String result = instance.getRecipient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageText method, of class Message1.
     */
    @Test
    public void testGetMessageText() {
        System.out.println("getMessageText");
        Message1 instance = null;
        String expResult = "";
        String result = instance.getMessageText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlag method, of class Message1.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Message1 instance = null;
        String expResult = "";
        String result = instance.getFlag();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessageID method, of class Message1.
     */
    @Test
    public void testSetMessageID() {
        System.out.println("setMessageID");
        String messageID = "";
        Message1 instance = null;
        instance.setMessageID(messageID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFlag method, of class Message1.
     */
    @Test
    public void testSetFlag() {
        System.out.println("setFlag");
        String flag = "";
        Message1 instance = null;
        instance.setFlag(flag);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
