/**
 * 
 */
package com.tony.algorithm.sorting;

/**
 * @author Tony.Gao
 *
 */
public class InsertionSort implements ISortInterface {

    @Override
    public void sort(int[] s) {
        if(s == null || s.length == 0) {
            return;
        }

        System.out.println("Insertion sort:");
        int j;
        for(int i = 0; i < s.length - 1; i++) {
            j = i + 1;
            while(j > 0 && s[j] < s[j - 1]) {
                int t = s[j];
                s[j] = s[j - 1];
                s[j - 1] = t;
                j--;
            }

            //print the debug info
            System.out.print("After round " + (i + 1) + ": ");
            for(int k = 0; k < s.length; k++) {
                System.out.print(s[k] + " ");
            }
            System.out.println();
        }
    }

}
