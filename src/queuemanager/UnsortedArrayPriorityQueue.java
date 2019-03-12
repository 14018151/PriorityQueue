
package queuemanager;

/**
 * @author Joseph
 * @param <T>
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T>{
    /**
     * Where the data is actually stored.
     */
    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int max = 0;
            int position = 0;
            
            for (int x = tailIndex; x >= 0; x--){
                int current = ((PriorityItem<T>)storage[x]).getPriority();
                if(current > max){
                    max = current;
                    position = x;
                }
            }

            return ((PriorityItem<T>) storage[position]).getItem();
        }
    }
    
    /**
     *
     * @param item
     * @param priority
     * @throws QueueOverflowException
     */
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            /*Insert at top of stack of stack */
            storage[tailIndex] = new PriorityItem<>(item, priority);
        }
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int max = 0;
            int position = 0;
            
            for (int x = tailIndex; x >= 0; x--){
                int current = ((PriorityItem<T>)storage[x]).getPriority();
                if(current > max){
                    max = current;
                    position = x;
                }
            }
            
            for(int x = 0; x<tailIndex;x++){
                if(((PriorityItem<T>) storage[x]).getPriority() == max){
                    Object temp = storage[x+1];
                    storage[x+1] = storage[x];
                    storage[x] = temp;
                }
                
            }
            tailIndex--;
        }
    }

    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
}
