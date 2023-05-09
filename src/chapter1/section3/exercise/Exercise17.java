package chapter1.section3.exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class Exercise17 {
    public static void main(String[] args) {
        String transactionFilePath = args[0];
        Transaction[] transactions = readAllTransactions(transactionFilePath);
        for (Transaction transaction : transactions) {
            StdOut.println(transaction);
        }
    }

    private static Transaction[] readAllTransactions(String transactionFilePath) {
        In in = new In(transactionFilePath);
        Queue<Transaction> queue = new Queue<>();

        while (!in.isEmpty()) {
            queue.enqueue(new Transaction(in.readLine()));
        }
        Transaction[] transactions = new Transaction[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            transactions[i] = queue.dequeue();
        }
        return transactions;
    }
}
