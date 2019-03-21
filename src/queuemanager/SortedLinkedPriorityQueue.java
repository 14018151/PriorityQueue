/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Joseph
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    public class ListNode<T> {
        private T item;
        private int priority;
        private ListNode<T> next;

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
    
    private ListNode<T> top;
    
    public SortedLinkedPriorityQueue() {
        top = null;
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException{
        int max = 0;
            ListNode temp = top, prev = null; 
            
            if(temp==null){
                top = new ListNode<>(item,priority, top);
            }else{
                for (ListNode<T> node = top; node != null; node = node.getNext()) {
                    int current = (node.getPriority());
                    if(current > max){
                        max=current;
                        temp = node;
                        System.out.println(temp.getItem());
                    }
                    
                    while(temp != null && temp.getPriority() < max){
                        prev = temp;
                        temp = temp.getNext();
                    }
                }
                System.out.println(temp.getNext());
                top = new ListNode<>(item, priority, temp);
            }
    }
    
    @Override
    public T head() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }else{
            return top.getItem();
        }
    }
    
    
    @Override
    public void remove() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else{
            top = top.getNext();
        }
    }

    
    @Override
    public boolean isEmpty() {
        return top == null;
    }   
    
    @Override
    public String toString() {
        String result = "[";
        for (ListNode<T> node = top; node != null; node = node.getNext()) {
            if (node != top) {
                result += ", ";
            }
            result += node.getItem();
            result += ", " + node.getPriority();
        }
        result += "]";
        return result;
    }    
}
