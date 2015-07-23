/**
 * 
 */
package com.tony.algorithm.searching;

/**
 * @author Tony.Gao
 *
 */
public class LCS {

    //Longest common substring
    public static String getLCS(final String s1, final String s2) {

        int[] temp = new int[s1.length()];
        int[] curr = new int[s1.length()];
        fillIntArray(temp, 0);
        fillIntArray(curr, 0);

        int maxSubLen = 0;
        int pos = 0;

        for(int i = 0; i < s2.length(); i++) {
            for(int j = 0; j < s1.length(); j++) {
                if(s1.charAt(j) == s2.charAt(i)) {
                    if(j == 0) {
                        curr[j] = 1;
                    } else {
                        curr[j] = temp[j - 1] + 1;
                    }

                    if(curr[j] > maxSubLen) {
                        maxSubLen = curr[j];
                        pos = j;
                    }
                }
            }
            fillIntArray(temp, curr);

            //print debug info
            printCurrentDebugInfo(i, curr, maxSubLen, pos);
        }

        return s1.substring(pos - maxSubLen + 1, pos);
    }

    //fill t with value
    private static void fillIntArray(int[] t, int value) {
        for(int i = 0; i < t.length; i++) {
            t[i] = value;
        }
    }

    //fill target with source's values in according positions
    private static void fillIntArray(int[] target, int[] source) {
        if(source.length < target.length) {
            return;
        }

        for(int i = 0; i < target.length; i++) {
            target[i] = source[i];
        }
    }

    private static void printCurrentDebugInfo(int i, int[] curr, int max, int pos) {
        System.out.print("Round " + i + ": ");
        for(int k = 0; k < curr.length; k++) {
            System.out.print(curr[k] + " ");
        }
        System.out.println(" Curr MaxLength: " + max + "; Curr Pos: " + pos);
    }
}
