/**
 * Node of LinkedListDeque.
 * @param <T> the type of value a Node stores
 * @author zengyichen
 */

package deque;

public class LinkedListNode<T> {
    public T value;
    public LinkedListNode<T> prev;
    public LinkedListNode<T> next;

    /**
     * Create a LinkedListNode with given values.
     */
    public LinkedListNode(T value, LinkedListNode<T> prev, LinkedListNode<T> next) {
        this.value = value;
        if (prev != null) {
            this.prev = prev;
        }
        if (next != null) {
            this.next = next;
        }
    }

    /**
     * Insert a node with a given value after this.
     */
    public LinkedListNode<T> insertNext(T value) {
        LinkedListNode<T> nextNode = this.next;

        LinkedListNode<T> node = new LinkedListNode<>(value, this, nextNode);

        this.next = node;
        nextNode.prev = node;

        return node;
    }

    /**
     * Insert a node with a given value before this.
     */
    public LinkedListNode<T> insertPrev(T value) {
        LinkedListNode<T> prevNode = this.prev;
        LinkedListNode<T> node = new LinkedListNode<>(value, prevNode, this);

        prevNode.next = node;
        this.prev = node;

        return node;
    }

    /**
     * Delete this.
     */
    public LinkedListNode<T> delete() {
        LinkedListNode<T> prevNode = this.prev;
        LinkedListNode<T> nextNode = this.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        return this;
    }
}