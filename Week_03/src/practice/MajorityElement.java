package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DSH
 * @date 2021/2/5
 * @description leetcode 元素#169 多数
 * 亚马逊 字节跳动 facebook
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
    }



    //方法一 数组排序 由于多数元素是指 "在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素"
    //      所以第 n/2个元素必然是出现概率更高的元素
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //方法二  利用哈希表 事实上使用方法一效率更高
    public static int majorityElement2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n:nums) {
            if (!map.containsKey(n)){
                map.put(n,1);
            }else {
                map.put(n,map.get(n)+1);
            }
        }
        int majorKey = 0;
        for (int key: map.keySet()) {
            int counts = map.get(key);
            if (counts>nums.length/2){
                majorKey = key;
            }
        }
        return majorKey;
    }
}
