
package com.tony.algorithm.sorting;

/**
 * @author Tony.Gao
 */
public class MergeSort implements ISortInterface {

    @Override
    public void sort(int[] s) {
        mergeSort2(s, 0, s.length - 1);
        
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
            merge(s, start, mid, end);
        //}

        System.out.print("The Result of the round: ");
        for (int k = 0; k < s.length; k++) {
            System.out.print(String.valueOf(s[k]) + " ");
        }
        System.out.println();
    }

    // Non-recursive
    private void mergeSort2(int[] s, int f, int l) {
        int len = l - f + 1;
        // boolean isEven = len % 2 == 0;
        int temLen = 1, temEnd = 0;
        do {
            System.out.println("loop, temLen: " + temLen);
            for (int i = f; i <= l; i += 2 * temLen) {
                temEnd = i + 2 * temLen - 1;
                if (temEnd > l) {
                    temEnd = l;
                }
                merge(s, i, (i + temEnd) / 2, temEnd);
            }
            temLen *= 2;
        } while (temLen <= len / 2);

        if (temLen < len) {
            System.out.println("out of loop, temLen: " + temLen);
            merge(s, f, temLen - 1, l);
        }
    }

    private void merge(int[] s, int start, int mid, int end) {
        System.out.println("merge， start: " + start + ", mid: " + mid + ", end: " + end);
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
    }
}