package dsh.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** LeetCode 1 两数之和
 * @author DSH
 * @date 2020/12/9
 * @description
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 15,2, 7 };
        System.out.println(Arrays.toString(twoSum(arr,9)));
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
