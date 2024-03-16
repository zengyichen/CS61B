/**
 * Deque implemented using DLL.
 * @author zengyichen
 */

package deque;

public class LinkedListDeque<T> implements Deque<T> {
    private int size;
    private LinkedListNode<T> sentinel;

    /**
     * Creates an empty LLDeque.
     */
    public LinkedListDeque() {
        size = 0;
        sentinel = new LinkedListNode<>(null, null, null);
        sentinel.prev = sentinel.next = sentinel;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * The item is never null.
     */
    public void addFirst(T item) {
        sentinel.insertNext(item);
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * The item is never null.
     */
    public void addLast(T item) {
        sentinel.insertPrev(item);
        size++;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque in a line from first to last, separated by a space.
     */
    public void printDeque() {
        LinkedListNode<T> iter = sentinel;
        while (iter.next != sentinel) {
            iter = iter.next;
            System.out.print(iter.value);
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        LinkedListNode<T> deletingNode = sentinel.next;
        T ret = deletingNode.delete().value;
        size--;
        return ret;
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        LinkedListNode<T> deletingNode = sentinel.prev;
        T ret = deletingNode.delete().value;
        size--;
        return ret;
    }

    /**
     * Gets the item at the given index.
     * If no such item exists, returns null.
     */
    public T get(int index) {
        LinkedListNode<T> iter = sentinel;
        T ret = null;

        while (iter.next != sentinel) {
            iter = iter.next;
            if (index == 0) {
                ret = iter.value;
                break;
            }
            index--;
        }

        return ret;
    }

    private T getRecursiveHelper(int index, LinkedListNode<T> node) {
        if (node == sentinel) {
            return null;
        }
        if (index == 0) {
            return node.value;
        }
        return getRecursiveHelper(index - 1, node.next);
    }

    /**
     * Same as get, but uses recursion.
     */
    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    /**
     * Returns whether the parameter o is equal to this.
     */
    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Deque)) {
            return false;
        }
        if (size() != ((Deque) o).size())
            return false;
        LinkedListNode<T> iter = sentinel;
        for (int i = 0; i < size(); i++) {
            iter = iter.next;
            T val1 = iter.value;
            T val2 = (T) ((Deque) o).get(i);
            if (!val1.equals(val2)) {
                return false;
            }
        }
        return true;
    }
}