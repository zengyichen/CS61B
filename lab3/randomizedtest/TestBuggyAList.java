package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> plainArray = new AListNoResizing<>();
        BuggyAList<Integer> buggyArray = new BuggyAList<>();

        plainArray.addLast(4);
        plainArray.addLast(5);
        plainArray.addLast(6);

        buggyArray.addLast(4);
        buggyArray.addLast(5);
        buggyArray.addLast(6);

        assertEquals(plainArray.removeLast(), buggyArray.removeLast());
        assertEquals(plainArray.removeLast(), buggyArray.removeLast());
        assertEquals(plainArray.removeLast(), buggyArray.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> plainArray = new AListNoResizing<>();
        BuggyAList<Integer> buggyArray = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            assertEquals(plainArray.size(), buggyArray.size());
            if (plainArray.size() > 0 ) {
                int operationNumber = StdRandom.uniform(0, 2);
                if (operationNumber == 0) {
                    // addLast
                    int randVal = StdRandom.uniform(0, 100);
                    plainArray.addLast(randVal);
                    buggyArray.addLast(randVal);
                    // System.out.println("addLast(" + randVal + ")");
                } else if (operationNumber == 1) {
                    // removeLast
                    int removedValFromPlainArray = plainArray.removeLast();
                    int removedValFromBuggyArray = buggyArray.removeLast();
                    assertEquals(removedValFromPlainArray, removedValFromBuggyArray);
                    // System.out.println("removedLast() = " + removedValFromBuggyArray);
                }
            } else {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                plainArray.addLast(randVal);
                buggyArray.addLast(randVal);
                // System.out.println("addLast(" + randVal + ")");
            }

        }

    }
}
