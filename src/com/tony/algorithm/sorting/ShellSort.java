
package com.tony.algorithm.sorting;

/**
 * @author Tony.Gao
 */
public class ShellSort implements ISortInterface {

    public static int[] SHELL_SORT_GAPS = {
            1, 5, 13, 43, 113, 297, 815, 1989, 4711, 11969, 27901, 84801, 213331, 543749, 1355339,
            3501671, 8810089, 21521774, 58548857, 157840433, 410151271, 1131376761, 2147483647
    };

    @Override
    public void sort(int[] s) {
        shellSortImpl_1(s);
    }

    private void shellSortImpl_1(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        System.out.println();
        System.out.println("Shell sort implementation 1:");

        int i, j, k, temp, gap;

        // find an appropriate starting gap(that would be the (k-1)th one)
        for (k = 0; SHELL_SORT_GAPS[k] < a.length && k < SHELL_SORT_GAPS.length; k++)
            ;

        int gapsCount = k - 1;// for printing debug info

        while (--k >= 0) {
            gap = SHELL_SORT_GAPS[k];

            // print the debug info:
            System.out.println();
            System.out.println("Before " + String.valueOf(gapsCount - k + 1)
                    + " Round, shown in columns:");
            for (int n = 0; n < a.length; n++) {
                System.out.print(String.valueOf(a[n]) + " ");
                if ((n + 1) % gap == 0 || n == a.length - 1) {
                    System.out.println();
                }
            }

            for (i = gap; i < a.length; i++) {
                temp = a[i];
                j = i;
                while (j >= gap && a[j - gap] > temp) {
                    a[j] = a[j - gap];
                    j = j - gap;
                }
                a[j] = temp;
            }

            // print the debug info:
            System.out.println("After " + String.valueOf(gapsCount - k + 1)
                    + " Round, shown in columns:");
            for (int n = 0; n < a.length; n++) {
                System.out.print(String.valueOf(a[n]) + " ");
                if ((n + 1) % gap == 0 || n == a.length - 1) {
                    System.out.println();
                }
            }
            System.out.print("The array: ");
            for (int n = 0; n < a.length; n++) {
                System.out.print(String.valueOf(a[n]) + " ");
            }
            System.out.println();
        }
    }
}
