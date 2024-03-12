package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     */
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad = new ArrayDeque<>();

        assertTrue("A newly initialized ArrayDeque should be empty", ad.isEmpty());
        ad.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad.size());
        assertFalse("lld1 should now contain 1 item", ad.isEmpty());

        ad.addLast("middle");
        assertEquals(2, ad.size());

        ad.addLast("back");
        assertEquals(3, ad.size());

        System.out.println("Printing out deque: ");
        ad.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        // System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", ad.isEmpty());

        ad.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", ad.isEmpty());

        ad.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", ad.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(3);

        ad.removeLast();
        ad.removeFirst();
        ad.removeLast();
        ad.removeFirst();

        int size = ad.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            ad.addLast(i);
            assertTrue(ad.checkMemoryUsage());
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) ad.removeFirst(), 0.0);
            assertTrue(ad.checkMemoryUsage());
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) ad.removeLast(), 0.0);
            assertTrue(ad.checkMemoryUsage());
        }

    }

    @Test
    /* Add & remove integers randomly to check get and getRecursive */
    public void getTest() {
        // TODO
    }

    @Test
    public void equalsTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();

        assertTrue(ad1.equals(ad2));
        assertTrue(ad2.equals(ad1));

        for (int i = 0; i <= 1000; i++) {
            ad1.addFirst(i);
            ad2.addFirst(i);
            if (!ad1.equals(ad2)) {
                ad1.equals(ad2);
                ad1.printDeque();
                ad2.printDeque();
            }
            assertTrue(ad1.equals(ad2));
            assertTrue(ad2.equals(ad1));
        }
        for (int i = 0; i <= 1000; i++) {
            ad1.addLast(i);
            ad2.addLast(i);
            assertTrue(ad1.equals(ad2));
            assertTrue(ad2.equals(ad1));
        }

        for (double i = 0; i <= 100; i++) {
            ad1.removeFirst();
            ad2.removeFirst();
            assertTrue(ad1.equals(ad2));
            assertTrue(ad2.equals(ad1));
        }
        for (double i = 0; i <= 1500; i++) {
            ad1.removeLast();
            ad2.removeLast();
            assertTrue(ad1.equals(ad2));
            assertTrue(ad2.equals(ad1));
        }
    }
}