package homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DSH
 * @date 2021/1/21
 * @description leetCode #1 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] result = twoSum(nums, 9);
        System.out.println(Arrays.toString(result));
    }

    //用map解决
    private static int[] twoSum(int[] nums, int target) {
        if (nums==null){
            return null;
        }
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = target-nums[i];
            if (map.containsKey(key)){
                return new int[]{map.get(key),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
