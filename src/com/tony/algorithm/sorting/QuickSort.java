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

        quickSort_2(s, 0, s.length - 1);

        System.out.print("The Result array: ");
        for (int k = 0; k < s.length; k++) {
            System.out.print(String.valueOf(s[k]) + " ");
        }
        System.out.println();
    }

    /******************************************（非递归） added in 2018-11-14 *******************************************/
    private void quickSort_3(int[] s, int low, int high) {
        int l = low, h = high;
        while (l < h) {

        }
        int pivotIdx = partition(s, low, high);


    }

    /******************************************************************************************************************/

    /*********************************************** added in 2018-11-14 **********************************************/
    //数组长度超过371会栈溢出
    private void quickSort_2(int[] s, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = s[high];
        System.out.println("partition, pivot: " + pivot);
        int i, j, t;
        for (i=j=low; j < high; j++) {
            if (s[j] < pivot) {
                if (i != j) {
                    t = s[i];
                    s[i] = s[j];
                    s[j] = t;
                }
                i++;
            }
        }
        if (i != high) {
            t = s[i];
            s[i] = s[high];
            s[high] = t;
        }

        quickSort_2(s, low, i - 1);
        quickSort_2(s, i, high);
    }
    /******************************************************************************************************************/

    /*********************************************** added in 2018-11-14 **********************************************/
    //数组长度超过266会栈溢出
    private void quickSort_1(int[] s, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIdx = partition(s, low, high);
        System.out.println("after partition, pivotIdx: " + pivotIdx);

        // 注意这里，因为partition函数里选择的是 s[high] 作为 pivot，所以，递归分区时，应该是 [low, pivotIdx - 1] 和 [pivotIdx, high]
        // 而不是 [low, pivotIdx] 和 [pivotIdx + 1, high]，否则后续的partition调用会一直return第一次partition的值
        quickSort_1(s, low, pivotIdx - 1);
        quickSort_1(s, pivotIdx, high);
    }

    private int partition(int[] s, int low, int high) {
        int pivot = s[high];
        System.out.println("partition, pivot: " + pivot);
        int i, j;
        for (i=j=low; j < high; j++) {
            if (s[j] < pivot) {
                swap(s, i, j);
                i++;
            }
        }
        swap(s, i, high);
        return i;
    }

    private void swap(int[] s, int i, int j) {
        if (i == j) {
            return;
        }

        int t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
    /*******************************************************************************************************************/

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
