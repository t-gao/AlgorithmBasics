/**
 * 
 */

package com.tony.algorithm.searching;

/**
 * @author Tony.Gao
 */
public class BinarySearch {

    public static final int NOT_FOUND = -1;

    public static int binarySearch(int[] a, int t) {
        if (a != null && a.length != 0) {
            int low = 0, high = a.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (t == a[mid]) {
                    return mid;
                } else if (t < a[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return NOT_FOUND;
    }
}
