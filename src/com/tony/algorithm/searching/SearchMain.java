
package com.tony.algorithm.searching;

import com.tony.algorithm.sorting.ISortInterface;
import com.tony.algorithm.sorting.SorterFactory;
import com.tony.algorithm.sorting.SorterFactory.SorterTypes;
import java.util.*;

public class SearchMain {

    public static void main(String[] args) {
//        int a[] = {1, 3, 6, 2, 9, 4, 7, 0};
        int a[] = {1, 2, 3, 6, 8, 9, 12, 16, 19};
//        ISortInterface mSortObj = SorterFactory.createSorter(SorterTypes.INSERTION);
//        mSortObj.sort(a);
        
        System.out.println("Search result: " + BinarySearch.binarySearch(a, 26));

        Map<String, String> map = new HashMap<>();
        map.put("a", null);
        System.out.print("map.containsKey(a): " + map.containsKey("a"));
//        char[] t = {'a', 'b', 'd', 't', 'g', 'o', 'o', 'd', 'u', 'a'};
//        char[] k = {'g', 'o', 'o', 'd'};
//        char[] m = {'t', 'g'};
//
//        String s = "Ihaveadream";
//        String l = "dream";
//        String p = "aveream";
//        System.out.println("Match pos: " + KMP.kmpMatch(s.toCharArray(), l.toCharArray()));
//        System.out.println("LCS between " + s + " and " + p + " is: " + LCS.getLCS(s, p));
    }
}
