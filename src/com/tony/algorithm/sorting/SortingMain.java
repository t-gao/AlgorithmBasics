
package com.tony.algorithm.sorting;

import java.util.Random;

import com.tony.algorithm.sorting.SorterFactory.SorterTypes;

public class SortingMain {
    public static void main(String[] args) {
        ISortInterface mSortObj;
        // int[] a = new int[] {5, 3, 4, 6, 2, 7, 9, 0, 1, 10};
//        int[] a = new int[] {
//                13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25, 39, 10
//        };
        // int[] a = new int[] {0, 1, 2, 3, 4};
        // int[] a = new int[] {};
        // int i = 0;
        // System.out.println("The unsorted array:");
        // for (String s : args) {
        // System.out.print(s + " ");
        // a[i++] = Integer.valueOf(s).intValue();
        // }
        // System.out.println();


//        int[] a = new int[100];
//        for(int i=0; i < 100; i++) {
//            a[i] = i;
//        }
//        a[2] = 97;
//        a[97] = 2;
//        a[98] = 97;
//        a[97] = 98;
//        a[2] = 100;

//        Random r = new Random();

        int[] a = {2, 7, 49, 6, 4, 28, 3, 34, 5, 8, 1, 12, 0, 9};
        // print the debug info:
        System.out.print("The original array: ");
        for (int k = 0; k < a.length; k++) {
            System.out.print(String.valueOf(a[k]) + " ");
        }
        System.out.println("; length: " + a.length);

        // mSortObj = getSortObj();
        mSortObj = SorterFactory.createSorter(SorterTypes.MERGE);
        mSortObj.sort(a);
    }
}
