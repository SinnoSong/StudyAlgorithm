package chapter1.section1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
    public static int rank(int key, int[] nums) {
        // 数组必须是有序的
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            // 被查找的键要么不存在，要么存在于a[lo.hi]之中
            int mid = low + (high - low) / 2;
            if (key < nums[mid]) {
                high = mid - 1;
            } else if (key > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whiteList = new In(args[0]).readAllInts();
        Arrays.sort(whiteList);
        while (!StdIn.isEmpty()) {
            // 读取键值，如果不存在于白名单中则将其打印
            int key = StdIn.readInt();
            if (rank(key, whiteList) < 0) {
                StdOut.println(key);
            }
        }
    }
}
