package homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #169 多数元素
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,1};
        System.out.println(majorElement(nums));
        System.out.println(majorElement2(nums));
    }

    //方法1 库函数
    private static int majorElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //方法2 哈希表
    private static int majorElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key)>nums.length/2){
                return key;
            }
        }
        return -1;
    }
}
