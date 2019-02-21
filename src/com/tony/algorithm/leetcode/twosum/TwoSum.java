package com.tony.algorithm.leetcode.twosum;

import java.util.HashMap;

public class TwoSum {

    public static void main(String... args) {
        int[] nums = {3, 3, 6};//{2, 7, 11, 15};//{3, 2, 4};//{3, 3};//
        int target = 9;//6;//

        long begin = System.currentTimeMillis();
        System.out.println("begin: " + begin);

//        int[] result = theBrute(nums, target);
        int[] result = oneHash(nums, target);

        long end = System.currentTimeMillis();
        System.out.println("end: " + end + ", cost: " + (end - begin));

        System.out.println("result: ");
        if (result == null) {
            System.out.println("null");
        } else {
            for (int i = 0; i<result.length; i++) {
                System.out.print(result[i] + ", ");
            }
        }
    }

    public static int[] theBrute(int[] nums, int target) {
        if (nums.length > 1) {
            int i, j;
            for (i = 0; i < nums.length; i++) {
                for (j = i+1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    public static int[] oneHash(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        int i, len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);

        Integer j = null;
        int vi, vj;
        for (i=0; i < len; i++) {
            vi = nums[i];
            vj = target - vi;
            j = map.get(vj);
            if (j != null) {
                return new int[]{j, i};
            }
            map.put(vi, i);
        }
        return null;
    }
}
