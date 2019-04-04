/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author 14018151
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    //Class used to actually create objects and implement them into the linked list
    public class ListNode<T> {
        private T item;
        private int priority;
        private ListNode<T> next;

        //Constructor to set up the object with the data from an input
        public ListNode(T item, int priority, ListNode<T> next) {
            this.item = item;
            this.priority = priority;
            this.next = next;
        }

        public T getItem() {
            return item;
        }
        
        public int getPriority(){
            return priority;
        }

        public ListNode<T> getNext() {
            return next;
        }
    }
    
    //Initialises an empty node to act as the first item in the list.
    private ListNode<T> top;
    
    public SortedLinkedPriorityQueue() {
        top = null;
    }
    
    //Adds a new item into the list after sorting through to find the correct entry point
    //Code modified from https://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
    @Override
    public void add(T item, int priority) throws QueueOverflowException{
        ListNode current;
        ListNode new_node = new ListNode(null, 0, null); 
        new_node.item = item;
        new_node.priority = priority;
        
        //If statement exception in case the new item is the first in the list.
        if (top == null || top.getPriority() <= priority) { 
            top = new ListNode(item, priority, top);
        } else {
            //Searches front to back in the linked list and inserts the new node where the priority would be greater than the node after it
            current = top;
            
            while (current.next != null && current.getNext().getPriority() > priority)
                current = current.next;
                new_node.next = current.getNext(); 
                current.next = new_node; 
         } 
    }
    
    //Returns the first node as long as the list is not empty
    @Override
    public T head() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }else{
            return top.getItem();
        }
    }
    
    //Removes the first node by replacing it with the one it links to as long as list isn't empty
    @Override
    public void remove() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else{
            top = top.getNext();
        }
    }

    //Makes sure the first item in the list is not null. If it is return true, otherwise return false
    @Override
    public boolean isEmpty() {
        return top == null;
    }   
    
    //Loop through the list appending the data and priority from each item onto string to be returned and displayed
    @Override
    public String toString() {
        String result = "[";
        for (ListNode<T> node = top; node != null; node = node.getNext()) {
            if (node != top) {
                result += ", ";
            }
            result += "(" + node.getItem();
            result += ", " + node.getPriority() +")";
        }
        result += "]";
        return result;
    }    
}
