
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
     * The index of the last item stored. Equal to the total length of the queue -1 to make up for arrays starting at 0
     */
    private int tailIndex;

    /**
     * Create a new empty queue with it's sized based on an input from the QueueManager
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
    
    //Throws an error if list is full and user tries to add to it. Otherwise appends the new data to the top of the array
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            storage[tailIndex] = new PriorityItem<>(item, priority);
        }
    }

    
    //Removes the highest priority item in the array as long as there is actually something there, otherwise throw exception
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int max = 0;
            
            //Loops through array to find the highest priority item and assigns the number of the priority to max
            for (int x = tailIndex; x >= 0; x--){
                int current = ((PriorityItem<T>)storage[x]).getPriority();
                if(current > max){
                    max = current;
                }
            }
            
            //Loops through array to find item with the highest priority, then removes it and replaces it with the value in front
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

    //Returns true if array is empty, otherwise false.
    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    //Appends each item and it's priority to the string to be returned and displayed
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
