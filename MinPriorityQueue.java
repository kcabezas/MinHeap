/**
 * Your implementation of a min priority queue.
 * @author Katherine Cabezas
 * @version 1.0
 */
public class MinPriorityQueue<T extends Comparable<? super T>>
    implements PriorityQueueInterface<T> {

    private MinHeap<T> backingHeap;
    // Do not add any more instance variables

    /**
     * Creates a priority queue.
     */
    public MinPriorityQueue() {
        backingHeap = new MinHeap<T>();
    }

    @Override
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null.");
        }
        backingHeap.add(item);
    }

    @Override
    public T dequeue() {
        if (backingHeap.isEmpty()) {
            throw new java.util.NoSuchElementException(
                "Min Priority Queue is empty."
            );
        }
        return backingHeap.remove();
    }

    @Override
    public boolean isEmpty() {
        return backingHeap.isEmpty();
    }

    @Override
    public int size() {
        return backingHeap.size();
    }

    @Override
    public void clear() {
        backingHeap.clear();
    }

    /**
     * Used for grading purposes only. Do not use or edit.
     * @return the backing heap
     */
    public MinHeap<T> getBackingHeap() {
        return backingHeap;
    }

}
