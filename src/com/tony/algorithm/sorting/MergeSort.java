
package com.tony.algorithm.sorting;

/**
 * @author Tony.Gao
 */
public class MergeSort implements ISortInterface {

    @Override
    public void sort(int[] s) {
        mergeSort1(s, 0, s.length - 1);
        
        System.out.print("The Result array: ");
        for (int k = 0; k < s.length; k++) {
            System.out.print(String.valueOf(s[k]) + " ");
        }
        System.out.println();
    }

    private void mergeSort1(int[] s, int f, int l) {
        System.out.println("MergeSortImpl_1, f: " + f + ", l: " + l);
        if (s == null || l <= f) {
            return;
        }

        int start = f, end = l, mid = (start + end) / 2;
        //if (l - f > 1) {
            mergeSort1(s, start, mid);
            mergeSort1(s, mid + 1, end);
        //} else {
            int i = start, j = mid + 1, k = 0;
            int temLen = end - start + 1;
            int[] tem = new int[temLen];

            while (i <= mid && j <= end) {
                if (s[i] <= s[j]) {
                    tem[k++] = s[i++];
                } else {
                    tem[k++] = s[j++];
                }
            }
            while (i <= mid) {
                tem[k++] = s[i++];
            }
            while (j <= end) {
                tem[k++] = s[j++];
            }

            i = start;
            k = 0;
            while (k < temLen) {
                s[i++] = tem[k++];
            }
        //}

        System.out.print("The Result of the round: ");
        for (k = 0; k < s.length; k++) {
            System.out.print(String.valueOf(s[k]) + " ");
        }
        System.out.println();
    }
    
}