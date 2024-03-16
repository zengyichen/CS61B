package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> defaultComparator;

    public MaxArrayDeque(Comparator<T> c) {
        defaultComparator = c;
    }

    /**
     * compare item1 and item2 using comparator c.
     * if one item is null, return the other.
     */
    private T compare(T item1, T item2, Comparator<T> c) {
        if (item1 == null) return item2;
        if (item2 == null) return item1;
        if (c.compare(item1, item2) > 0) {
            /**
             * .compare() returns a negative int / 0 / positive int
             * when the result is less / equal / greater
            */
            return item1;
        }
        return item2;
    }

    /**
     * returns the maximum element in the deque using the default comparator.
     * If the MaxArrayDeque is empty, simply return null.
     */
    public T max() {
        if (super.isEmpty()) return null;
        T ret = null;
        for (int i = 0; i < size(); i++) {
            ret = compare(ret, get(i), defaultComparator);
        }
        return ret;
    }

    /**
     * returns the maximum element in the deque using a given comparator c.
     * If the MaxArrayDeque is empty, simply return null.
     */
    public T max(Comparator<T> c) {
        if (super.isEmpty()) return null;
        T ret = null;
        for (int i = 0; i < size(); i++) {
            ret = compare(ret, get(i), c);
        }
        return ret;
    }
}