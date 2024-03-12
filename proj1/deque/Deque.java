package deque;

import afu.org.checkerframework.checker.oigj.qual.O;

public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    boolean isEmpty();
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}