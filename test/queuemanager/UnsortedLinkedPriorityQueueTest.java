/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 14018151
 */
public class UnsortedLinkedPriorityQueueTest {
    UnsortedLinkedPriorityQueue instance;
    
    public UnsortedLinkedPriorityQueueTest() {
    }
    
    @Before
    public void setUp() {
        instance = new UnsortedLinkedPriorityQueue();
    }

    

    /**
     * Test of isEmpty method with an empty array
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Basic test of add method and verified by checking if list is empty after adding something.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Object item = "Test0";
        int priority = 0;
        
        instance.add(item, priority);
        
        Object expResult = false;
        Object result = instance.isEmpty();
        assertEquals(expResult, result);
    }  
    
    /**
     * Test of head method
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        
        instance.add("Test1", 0);
        instance.add("Test2", 2);
        instance.add("Test3", 5);
        Object expResult = "Test3";
        Object result = instance.head();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of remove method by removing when there is nothing in the list to begin with
     */
    @Test(expected = QueueUnderflowException.class)
    public void testHeadEmpty() throws Exception {
        System.out.println("headEmpty");
        
        instance.head();
    }
    
    /**
     * Tests the head function to search and find the head in a normal array
     */
    @Test
    public void testSort1() throws Exception {
        System.out.println("sort1");
        
        instance.add("Test1", 5);
        instance.add("Test2", 2);
        instance.add("Test3", 0);
        Object expResult = "Test1";
        Object result = instance.head();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Tests the searching of the head method
     */
    @Test
    public void testSort2() throws Exception {
        System.out.println("sort2");
        
        instance.add("Test1", 5);
        instance.add("Test2", 0);
        instance.add("Test3", 2);
        Object expResult = "Test1";
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Tests the searching of the head method
     */
    @Test
    public void testSort3() throws Exception {
        System.out.println("sort3");
        
        instance.add("Test1", 2);
        instance.add("Test2", 5);
        instance.add("Test3", 0);
        Object expResult = "Test2";
        Object result = instance.head();
        assertEquals(expResult, result);
    }
    
    /**
     * Tests the searching of the head method
     */
    @Test
    public void testSort4() throws Exception {
        System.out.println("sort4");
        
        instance.add("Test1", 2);
        instance.add("Test2", 0);
        instance.add("Test3", 5);
        Object expResult = "Test3";
        Object result = instance.head();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of remove method by adding an item, removing it, and then checking if the list is now empty
     */
    @Test
    public void testRemove1() throws Exception {
        System.out.println("remove1");
        instance.add("Test1", 5);
        
        instance.remove();
        
        Object expResult = true;
        Object result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of remove method by adding two items, removing the top one, and then checking if the list still has the remaining item.
     */
    @Test
    public void testRemove2() throws Exception {
        System.out.println("remove2");
        instance.add("Test1", 5);
        instance.add("Test2", 3);
        
        instance.remove();
        
        Object expResult = "[(Test2, 3)]";
        Object result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Tests remove method by adding three items, searching and removing the top one, and checking that the next highest in the list is correct
     */
    @Test
    public void testRemove3() throws Exception {
        System.out.println("remove2");
        instance.add("Test1", 2);
        instance.add("Test2", 5);
        instance.add("Test3", 0);
        
        instance.remove();
        
        Object expResult = "Test1";
        Object result = instance.head();
        assertEquals(expResult, result);
    }

     /**
     * Test of remove method by removing when there is nothing in the list to begin with
     */
    @Test(expected = QueueUnderflowException.class)
    public void testRemoveEmpty() throws Exception {
        System.out.println("removeEmpty");
        
        instance.remove();
    }
    
    
    
    /**
     * Test of toString method with 2 items in the list (linked list displays backwards compared to array by default)
     */
    @Test
    public void testToString() throws Exception{
        System.out.println("toString");
        
        instance.add("Test1", 1);
        instance.add("Test2", 2);
        String expResult = "[(Test2, 2), (Test1, 1)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
