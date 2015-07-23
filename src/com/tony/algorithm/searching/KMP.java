/**
 * 
 */
package com.tony.algorithm.searching;

/**
 * @author Tony.Gao
 *
 */
public class KMP {

    public static final int NOT_FOUND = -1;

    public static int kmpMatch(char[] t, char[] k) {
        if(t == null || k == null || t.length < k.length) {
            return NOT_FOUND;
        }

        int i = 0, j = 0;
        while (i <= t.length - k.length) {
            j = 0;
            while (j < k.length) {
                if (t[i] == k[j]) {
                    i++;
                    j++;
                } else {
                    i = i - j + 1;
                    break;
                }
            }
            if (j >= k.length) {
                return i - j;
            }
        }
        return NOT_FOUND;
    }

    public static int kmpMatch(String t, String k) {
        return kmpMatch(t.toCharArray(), k.toCharArray());
    }
}
