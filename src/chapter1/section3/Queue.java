package chapter1.section3;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private class Node {
        T item;
        Node next;
    }

    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }

        Node newLast = new Node();
        newLast.item = item;
        if (size == 0) {
            last = first = newLast;
        } else {
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return first.item;
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
