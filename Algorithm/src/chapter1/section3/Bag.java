package chapter1.section3;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

    private class Node {

        T item;
        Node next;
    }

    private Node first;
    private int size;

    public int getSize() {
        return size;
    }

    public void add(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;

        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    private class InnerIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

    }
}
