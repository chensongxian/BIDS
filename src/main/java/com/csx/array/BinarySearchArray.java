package com.csx.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2019-03-20
 */
public class BinarySearchArray {
    public static int binarySearch(int key, int[] data, int n) {
        if (n < 0) {
            return -1;
        }

        int low = 0 ;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // 小则去前半部分查找
            if (key < data[mid]) {
                high = mid - 1;
            } else if (data[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        int index = binarySearch(2, data, 5);
        System.out.println(index);
    }
}
