
package com.tony.algorithm.sorting;

/**
 * @author Tony.Gao
 */
public class BubbleSort implements ISortInterface {

    @Override
    public void sort(int[] s) {
        int[] a = s.clone();
        sortImpl_1(s);
        sortImpl_2(a);
    }

    private void sortImpl_1(int[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        System.out.println();
        System.out.println("Bubble sort implementation 1:");

        int compCount = 0;
        for (int i = s.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                compCount++;
                if (s[j] > s[j + 1]) {
                    int t = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = t;
                }
            }

            // print the debug info:
            System.out.print("After " + String.valueOf(s.length - i) + " Round: ");
            for (int k = 0; k < s.length; k++) {
                System.out.print(String.valueOf(s[k]) + " ");
            }
            System.out.println();
        }
        System.out.print("compare count: " + compCount);// len * (len - 1) / 2
    }

    private void sortImpl_2(int[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        System.out.println();
        System.out.println("Bubble sort implementation 2:");

        for (int i = s.length - 1; i > 0; i--) {
            boolean bubble = false;
            for (int j = 0; j < i; j++) {
                if (s[j] > s[j + 1]) {
                    int t = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = t;

                    bubble = true;
                }
            }

            // print the debug info:
            System.out.print("After " + String.valueOf(s.length - i) + " Round: ");
            for (int k = 0; k < s.length; k++) {
                System.out.print(String.valueOf(s[k]) + " ");
            }
            System.out.println();

            if (bubble == false) {
                // if no swap(no bubble) in a round, that means the sort is done
                break;
            }
        }
    }
}
