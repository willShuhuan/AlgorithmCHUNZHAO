package practice.sort;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/3/25
 * @description 冒泡排序 稳定 O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {2,5,3,7,1,0,9};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //每次循环最大的数都会放到最后
    private static void bubbleSort(int[] nums) {
        int len = nums.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (nums[j]>nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
