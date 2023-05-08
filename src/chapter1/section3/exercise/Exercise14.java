package chapter1.section3.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise14 {
    //ResizingArrayQueueOfStrings
    private String[] items;
    private int size;
    private int first;
    private int last;

    public Exercise14(int capacity) {
        items = new String[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int cap) {
        String[] temp = new String[cap];

        for (int i = 0; i < size; i++) {
            temp[i] = items[(first + i) % items.length];
        }
        items = temp;
        first = 0;
        last = size;
    }

    public void enqueue(String item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        if (last == items.length) {
            last = 0;
        }
        items[last++] = item;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        } else {
            String item = items[first];
            items[first] = null;
            first++;
            if (first == items.length) {
                first = 0; // Wrap around
            }
            size--;
            if (size > 0 && size == items.length / 4) {
                resize(items.length / 2);
            }
            return item;
        }
    }

    public static void main(String[] args) {
        Exercise14 resizingArrayQueueOfStrings = new Exercise14(3);

        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("2");
        resizingArrayQueueOfStrings.enqueue("3");
        resizingArrayQueueOfStrings.enqueue("Full");

        StdOut.println("Dequeue 1: " + resizingArrayQueueOfStrings.dequeue());
        StdOut.println("Expected: 1\n");

        resizingArrayQueueOfStrings.enqueue("4");
        StdOut.println("Dequeue 2: " + resizingArrayQueueOfStrings.dequeue());
        resizingArrayQueueOfStrings.dequeue();
        resizingArrayQueueOfStrings.dequeue();
        StdOut.println("Expected: 2");
    }
}
