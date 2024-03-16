/**
 * how 2 disable these fucking autoimports?!!!?!?!
 */

package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;


public class MaxArrayDequeTest {
    public class compareInt<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return Integer.compare((Integer) o1, (Integer) o2);
        }
    }

    @Test
    public void returnNullTest() {
        compareInt<Integer> c = new compareInt<>();
        MaxArrayDeque<Integer> mad = new MaxArrayDeque(c);

        assertTrue(mad.max() == null);
    }

    @Test
    public void defaultMaxTest() {
        compareInt<Integer> c = new compareInt<>();
        MaxArrayDeque<Integer> mad = new MaxArrayDeque(c);

        mad.addFirst(1);
        mad.addFirst(345);
        mad.addFirst(25);
        mad.addFirst(48);
        mad.addFirst(26);
        mad.addFirst(1);

        mad.max();
        assertEquals(mad.max(), (Integer) 345);
    }
}