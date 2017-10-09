
package com.tony.algorithm.sorting;

/**
 * @author Tony.Gao
 */
public class SorterFactory {

    public static enum SorterTypes {
        BUBBLE,
        SELECTION,
        INSERTION,
        SHELL,
        QUICK,
        MERGE
    }

    public static ISortInterface createSorter(SorterTypes type) {
        switch (type) {
            case BUBBLE:
                return new BubbleSort();
            case SELECTION:
                return new SelectionSort();
            case SHELL:
                return new ShellSort();
            case INSERTION:
                return new InsertionSort();
            case QUICK:
                return new QuickSort();
            case MERGE:
                return new MergeSort();
            default:
                return null;
        }
    }
}
