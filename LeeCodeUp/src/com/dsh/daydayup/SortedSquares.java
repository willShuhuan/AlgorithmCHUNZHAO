package com.dsh.daydayup;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/4/15
 * @description 977 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    //
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i],2);
        }
        Arrays.sort(nums);
        return nums;
    }
}
