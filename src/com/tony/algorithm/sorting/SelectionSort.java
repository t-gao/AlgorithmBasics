
package com.tony.algorithm.sorting;

/**
 * @author Tony.Gao
 */
public class SelectionSort implements ISortInterface {

    @Override
    public void sort(int[] s) {
        sortImpl_1(s);
    }

    private void sortImpl_1(int[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        System.out.println();
        System.out.println("Selection sort implementation 1:");
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[j] < s[i]) {
                    int t = s[j];
                    s[j] = s[i];
                    s[i] = t;
                }
            }

            // print the debug info:
            System.out.print("After " + String.valueOf(i + 1) + " Round: ");
            for (int k = 0; k < s.length; k++) {
                System.out.print(String.valueOf(s[k]) + " ");
            }
            System.out.println();
        }
    }
}
