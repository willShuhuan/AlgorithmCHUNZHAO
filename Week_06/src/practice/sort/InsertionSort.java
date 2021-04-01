package practice.sort;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/3/25
 * @description 插入排序 稳定 O(n^2)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {2,5,3,7,1,0,9};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
    private static void insertionSort(int[] nums) {
        int len = nums.length;
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < len; i++) {
            insertIndex = i-1;
            insertVal = nums[i];
            while(insertIndex>=0&&nums[insertIndex]>insertVal){
                nums[insertIndex+1]=nums[insertIndex];
                insertIndex--;
            }
            if (insertIndex+1!=i){
                nums[insertIndex+1] = insertVal;
            }

        }
    }
}
