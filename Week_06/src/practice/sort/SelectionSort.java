package practice.sort;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/3/25
 * @description 选择排序 不稳定 O(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {2,5,3,7,1,0,9};
        System.out.println(Arrays.toString(selection(nums)));
    }

    //选择排序  将最小元素放在数组最前面 时间复杂度
    private static int[] selection(int[] nums) {
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[minIndex]>nums[j]){//寻找最小值
                    minIndex = j;//将最小数的索引保存
                }
            }
            if(minIndex!=i){
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }

        }
        return nums;
    }
}
