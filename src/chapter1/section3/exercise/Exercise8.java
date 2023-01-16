package chapter1.section3.exercise;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Exercise8 implements Iterable<String> {
    private String[] items = new String[1];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private void resize(int max) {
        String[] temp = new String[max];
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public void push(String item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size++] = item;
    }

    public String pop() {
        String item = null;
        if (!isEmpty()) {
            item = items[--size];
            items[size] = null;
        }
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }

        return item;
    }

    @Override
    public Iterator<String> iterator() {
        return new InnerIterator();
    }

    private class InnerIterator implements Iterator<String> {

        int index = size;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public String next() {
            return items[--index];
        }
    }

    public static void main(String[] args) {
        Exercise8 resizingArrayStackOfStrings = new Exercise8();
        var str = "it was - the best - of times - - - it was - the - -";
        var split = str.split(" ");
        for (String e : split) {
            if (!e.equals("-")) {
                resizingArrayStackOfStrings.push(e);
            } else if (!resizingArrayStackOfStrings.isEmpty()) {
                StdOut.print(resizingArrayStackOfStrings.pop() + " ");
            }
        }
        StdOut.println("(" + resizingArrayStackOfStrings.getSize() + " left on stack)");
    }
}
