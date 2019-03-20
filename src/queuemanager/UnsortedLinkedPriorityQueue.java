package queuemanager;

/**
 
 * @author 14018151
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> { 
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
    
    public UnsortedLinkedPriorityQueue() {
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
            ListNode<T> head = null;
            int max = 0;
            for (ListNode<T> node = top; node != null; node = node.getNext()) {
                /* do something with node, perhaps with node.data */
                int current = (node.getPriority());
                if(current > max){
                    max=current;
                    head = node;
                }
   
            }
            return head.getItem();
        }
    }
    
    
    //https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
    @Override
    public void remove() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int max = 0;
            ListNode temp = top, prev = null; 
            
            for (ListNode<T> node = top; node != null; node = node.getNext()) {
                int current = (node.getPriority());
                if(current > max){
                    max=current;
                }
            }
            
            if (temp != null && temp.getPriority() == max) {
                top = temp.getNext();  
                return;
            }
            
            
            while (temp != null && temp.getPriority() != max) {
                prev = temp;
                temp = temp.getNext();
            }
            
            prev.next = temp.getNext();
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
