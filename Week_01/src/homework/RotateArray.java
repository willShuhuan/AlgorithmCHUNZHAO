package homework;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/1/22
 * @description #189 旋转数组
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
//        rotate(arr,8);
//        rotate2(arr,4);
        rotate3(arr,3);
        System.out.println(Arrays.toString(arr));
    }



    //方法1 自己想的笨方法
    public static void rotate(int[] nums, int k) {
        if(nums==null){
            return;
        }
        int i = 1;
        while (i<=k){
            int temp = nums[nums.length-1];
            int tempNext = nums[0];//保存一个临时变量nums[j]，用于nums[j+1]的赋值操作
            for (int j = 1; j < nums.length; j++) {
                int temp2 = nums[j];
                nums[j]=tempNext;
                tempNext = temp2;
            }
            nums[0]=temp;
            i++;
        }
    }

    //------------------------ 以下为leetCode上高赞答案 ------------------------

    //临时数组+模运算
    private static void rotate2(int[] nums, int k) {
        if(nums==null){
            return;
        }
        int len = nums.length;
        int[] tempArr = new int[len];
        for (int j = 0; j < len; j++) {
            tempArr[j] = nums[j];
        }
        for (int j = 0; j < len; j++) {
            nums[(j+k)%len]=tempArr[j];
        }
    }

    //临时数组+模运算 （空间复杂度为O(1) ,最优解）
    private static void rotate3(int[] nums, int k) {
        if(nums==null){
            return;
        }
        int len = nums.length;
        k %= len;//取模 方式k>len 数组越界
        reverse(nums,0,len);
        reverse(nums,0,k);
        reverse(nums,k,len);
    }

    private static void reverse(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            int temp = nums[i];
            nums[i] = nums[end-1];
            nums[end-1]=temp;
            end--;
        }
    }


}
