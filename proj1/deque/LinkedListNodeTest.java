package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListNodeTest {
    @Test
    public void implementationTest() {
        LinkedListNode<Integer> currentNode = new LinkedListNode<Integer>(3, null, null);
        assertTrue(currentNode.value == 3);
    }

    @Test
    public void insertNextTest() {
        LinkedListNode<Integer> headNode = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> tailNode = new LinkedListNode<Integer>(5, null, null);

        headNode.next = tailNode;
        tailNode.prev = headNode;

        headNode.insertNext(7);

        assertTrue((Integer) headNode.next.value == 7);
        assertEquals(headNode.next, tailNode.prev);
    }


    @Test
    public void insertPrevTest() {
        LinkedListNode<Integer> headNode = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> tailNode = new LinkedListNode<Integer>(5, null, null);

        headNode.next = tailNode;
        tailNode.prev = headNode;

        tailNode.insertPrev(7);

        assertTrue((Integer) headNode.next.value == 7);
        assertEquals(headNode.next, tailNode.prev);
    }


    @Test
    public void deleteTest() {
        LinkedListNode<Integer> headNode = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> tailNode = new LinkedListNode<Integer>(5, null, null);

        headNode.next = tailNode;
        tailNode.prev = headNode;

        LinkedListNode<Integer> node2 = headNode.insertNext(9);
        LinkedListNode<Integer> node3 = tailNode.insertPrev(7);

        node3.delete();

        assertEquals(node2.next, tailNode);
        assertEquals(tailNode.prev, node2);
    }
}