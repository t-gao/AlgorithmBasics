/**
 * 
 */

package com.tony.algorithm.sorting;

/**
 * @author Tony.Gao
 */
public class QuickSort implements ISortInterface {

    @Override
    public void sort(int[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        quickSort(s, 0, s.length - 1);

        System.out.print("The Result array: ");
        for (int k = 0; k < s.length; k++) {
            System.out.print(String.valueOf(s[k]) + " ");
        }
        System.out.println();
    }

    private void quickSort(int[] s, int low, int high) {

        int l = low, h = high;
        if (l >= h) {
            return;
        } else if (h - l == 1) {
            if (s[l] > s[h]) {
                int t = s[l];
                s[l] = s[h];
                s[h] = t;
            }
            return;
        }

        // choose a pivot and move it out of the way
        int pivot = s[(l + h) / 2];
        s[(l + h) / 2] = s[h];
        s[h] = pivot;

        // print the debug info:
        System.out.println("pivot pos: " + (l + h) / 2 + "; pivot: " + pivot);

        System.out.print("current array: ");
        for (int n = 0; n < s.length; n++) {
            System.out.print(String.valueOf(s[n]) + " ");
        }
        System.out.println();
        System.out.println();

        while (l < h) {
            while (l < h && s[l] <= pivot) {
                l++;
            }

            System.out.println("l: " + l);

            while (l < h && s[h] >= pivot) {
                h--;
            }

            System.out.println("h: " + h);

            if (l < h) {
                int t = s[l];
                s[l] = s[h];
                s[h] = t;
            }

            System.out.print("current array: ");
            for (int n = 0; n < s.length; n++) {
                System.out.print(String.valueOf(s[n]) + " ");
            }
            System.out.println();
            System.out.println();
        }

        s[high] = s[h];// now l == h should be true, so l == h == (l+h)/2
        s[h] = pivot;

        quickSort(s, low, l - 1);
        quickSort(s, h + 1, high);

    }
}
