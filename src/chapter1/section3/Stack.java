package chapter1.section3;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private Node first;
    private int size;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }

        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
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
