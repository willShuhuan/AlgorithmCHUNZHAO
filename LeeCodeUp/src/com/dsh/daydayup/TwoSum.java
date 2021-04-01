package com.dsh.daydayup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DSH
 * @date 2021/3/31
 * @description 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,3,9,6};
        System.out.println(Arrays.toString(twoSum(arr, 5)));
    }

    public static int[] twoSum(int[] nums, int target) {
        //利用map解决这个问题
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
