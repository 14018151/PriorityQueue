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
         top = new ListNode<>(item, priority, top);
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
