
package com.tony.algorithm.searching;

import com.tony.algorithm.sorting.ISortInterface;
import com.tony.algorithm.sorting.SorterFactory;
import com.tony.algorithm.sorting.SorterFactory.SorterTypes;

public class SearchMain {

    public static void main(String[] args) {
//        int a[] = {1, 3, 6, 2, 9, 4, 7, 0};
//        ISortInterface mSortObj = SorterFactory.createSorter(SorterTypes.QUICK);
//        mSortObj.sort(a);
//        System.out.println("Search result: " + BinarySearch.binarySearch(a, 6));

        char[] t = {'a', 'b', 'd', 't', 'g', 'o', 'o', 'd', 'u', 'a'};
        char[] k = {'g', 'o', 'o', 'd'};
        char[] m = {'t', 'g'};

        String s = "Ihaveadream";
        String l = "dream";
        String p = "aveream";
        System.out.println("Match pos: " + KMP.kmpMatch(s.toCharArray(), l.toCharArray()));
        System.out.println("LCS between " + s + " and " + p + " is: " + LCS.getLCS(s, p));
    }
}
