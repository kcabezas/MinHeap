/**
 * Your implementation of a min heap.
 * @author Katherine Cabezas
 * @version 1.0
 */
public class MinHeap<T extends Comparable<? super T>>
    implements HeapInterface<T> {

    private T[] backingArray;
    private int size;
    // Do not add any more instance variables

    /**
     * Creates a Heap.
     */
    public MinHeap() {
        backingArray = (T[]) new Comparable[STARTING_SIZE];
        backingArray[0] = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null.");
        }

        if (size + 1 >= backingArray.length) {
            T[] original = backingArray;
            backingArray = (T[]) new Comparable[(size + 1) * 2];
            for (int i = 1; i <= size; i++) {
                backingArray[i] = original[i];
            }
        }

        backingArray[size + 1] = item;
        size++;
        if (size > 1) {
            addSort(size);
        }
    }

    /**
     * Helper method to sort heap after adding an element.
     * @param index Index number of the element to start sorting from
     */
    private void addSort(int index) {
        int i = index;
        T current = backingArray[i];
        if (i > 1 && current.compareTo(backingArray[i / 2]) < 0) {
            T parent = backingArray[i / 2];
            backingArray[i / 2] = current;
            backingArray[i] = parent;
            i = i / 2;
        }
        if (i > 1 && current.compareTo(backingArray[i / 2]) < 0) {
            addSort(i);
        }
    }

    @Override
    public T remove() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("Heap is empty.");
        }
        T removed = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;
        if (size > 1) {
            removeSort(1);
        }

        return removed;
    }

    /**
     * Helper method to sort heap after removing an element.
     * @param index Index number of element to start sorting from
     */
    private void removeSort(int index) {
        int left = 2 * index;
        int right = 2 * index + 1;
        int min = index;

        if (left <= size
            && backingArray[left].compareTo(backingArray[min]) < 0) {
            min = left;
        }
        if (right <= size
            && backingArray[right].compareTo(backingArray[min]) < 0) {
            min = right;
        }

        if (min != index) {
            T parent = backingArray[index];
            T child = backingArray[min];
            backingArray[index] = child;
            backingArray[min] = parent;
            removeSort(min);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        backingArray = (T[]) new Comparable[STARTING_SIZE];
        size = 0;
    }

    /**
     * Used for grading purposes only. Do not use or edit.
     * @return the backing array
     */
    public Comparable[] getBackingArray() {
        return backingArray;
    }

}
