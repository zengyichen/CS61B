/**
 * Deque implemented using array.
 * @author zengyichen
 */

package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private static int MINLENGTH =  16;
    private int size, length;

    /* Circular. [head, tail) */
    private int head, tail;

    private T[] items;

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;

        public ArrayDequeIterator() {
            pos = 0;
        }

        @Override
        public T next() {
            return items[pos++];
        }

        @Override
        public boolean hasNext() {
            return pos + 1 < size;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    /**
     * Convert circular index x to array index.
     */
    private int toIndex(int x) {
        return (x % length + length) % length;
    }

    private void resize(int newLength) {
        T[] newItems = (T[]) new Object [newLength];
        /**
         * Note:
         * T[] newItems = new T [newLength]; would not compile.
         * you can't new a generic array.
         */

        for (int i = head; i < tail; i++) {
            int newIndex = (i % newLength + newLength) % newLength;
            newItems[newIndex] = items[toIndex(i)];
        }

        length = newLength;
        items = newItems;
    }

    /**
     * Creates an empty array deque.
     */
    public ArrayDeque() {
        size = 0;
        head = tail = 0;

        length = MINLENGTH;
        items = (T[]) new Object [length];
    }

    /**
     * Adds an item of type T to the front of the deque.
     * The item is never null.
     */
    public void addFirst(T item) {
        size++;
        if (size >= length) {
            resize(length * 2);
        }

        head--;
        items[toIndex(head)] = item;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * The item is never null.
     */
    public void addLast(T item) {
        size++;
        if (size >= length) {
            resize(length * 2);
        }

        items[toIndex(tail)] = item;
        tail++;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return java.lang.Math.abs(tail - head);
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        size--;
        if (size * 3 < length && length > MINLENGTH) {
            resize(length / 2);
        }

        T ret = items[toIndex(head)];
        head++;
        return ret;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        size--;
        if (size * 3 < length && length > MINLENGTH) {
            resize(length / 2);
        }

        T ret = items[toIndex(tail - 1)];
        tail--;
        return ret;
    }

    /**
     * Gets the item at the given index
     * If no such item exists
     */
    public T get(int index) {
        if (index < 0) {
            return null;
        }
        index = head + index;
        if (index >= tail) {
            return null;
        }
        return items[toIndex(index)];
    }

    public void printDeque() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[toIndex(i)]);
        }
        System.out.println();
    }

    public boolean checkMemoryUsage() {
        if (length == MINLENGTH) {
            return true;
        }
        return size * 4 > length;
    }

    /**
     * Returns whether the parameter o is equal to this.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        if (size() != ((Deque) o).size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            T val1 = get(i);
            T val2 = (T) ((Deque) o).get(i);
            if (!val1.equals(val2)) {
                /**
                 * why not (val1 != val2)?
                 * == and != might not been defined for generic type T
                 * but .equals does.
                 */
                return false;
            }
        }
        return true;
    }
}
