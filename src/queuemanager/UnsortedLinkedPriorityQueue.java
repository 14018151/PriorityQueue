package queuemanager;

/**
 *
 * @author 14018151
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> { 
    public class ListNode<T> {
        private T item;
        private ListNode<T> next;

        public ListNode(T item, ListNode<T> next) {
            this.item = item;
            this.next = next;
        }

        public T getItem() {
            return item;
        }

        public ListNode<T> getNext() {
            return next;
        }
    }
    
    
    private ListNode<T> top;
    
    public UnsortedLinkedPriorityQueue() {
        top = null;
    }
    
    public void add(T item, int priority) throws QueueOverflowException{
        
    }
    
    public T head() throws QueueUnderflowException{
        
    }
    
    public void remove() throws QueueUnderflowException{
    
    
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
        }
        result += "]";
        return result;
    }

}
