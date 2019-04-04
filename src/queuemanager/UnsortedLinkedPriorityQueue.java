package queuemanager;

/**
 
 * @author 14018151
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> { 
    //Class used to create the objects in the list.
    public class ListNode<T> {
        private T item;
        private int priority;
        private ListNode<T> next;

        //ListNode constructor
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
    
    public UnsortedLinkedPriorityQueue() {
        top = null;
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException{
         top = new ListNode<>(item, priority, top);
    }
    
    //Searches for and returns the node with the highest priority if there are any in the list.
    @Override
    public T head() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }else{
            ListNode<T> head = null;
            int max = 0;
            for (ListNode<T> node = top; node != null; node = node.getNext()) {
                //Checks if node priority is higher than max. If it is make it the new maximum to check against
                int current = (node.getPriority());
                if(current > max){
                    max=current;
                    head = node;
                }
            }
            
            return head.getItem();
        }
    }
    
    //Removes the highest priority node from list if it's not already empty. If it's emptry throw error
    //Code modified from https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
    @Override
    public void remove() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int max = 0;
            ListNode temp = top, prev = null; 
            
            //Finds the value of the highest priority item
            for (ListNode<T> node = top; node != null; node = node.getNext()) {
                int current = (node.getPriority());
                if(current > max){
                    max=current;
                }
            }
            
            //If the first node has the highest priority remove it
            if (temp != null && temp.getPriority() == max) {
                top = temp.getNext();  
                return;
            }
            
            //Otherwise loop through and remove the node that does have highest priority
            while (temp != null && temp.getPriority() != max) {
                prev = temp;
                temp = temp.getNext();
            }
            
            prev.next = temp.getNext();
        }
    }

    //If top item in list is null return true as list is empty, otherwise return false
    @Override
    public boolean isEmpty() {
        return top == null;
    }   
    
    //Appends each item and it's priority to the string to be returned and displayed
    @Override
    public String toString() {
        String result = "[";
        for (ListNode<T> node = top; node != null; node = node.getNext()) {
            if (node != top) {
                result += ", ";
            }
            result += "(" + node.getItem();
            result += ", " + node.getPriority() + ")";
        }
        result += "]";
        return result;
    }
}
