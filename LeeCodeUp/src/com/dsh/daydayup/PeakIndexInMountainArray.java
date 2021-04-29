package com.dsh.daydayup;

/**
 * @author DSH
 * @date 2021/4/15
 * @description leetcode852 山脉数组的峰顶索引
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] array = {0,10,5,2};
        System.out.println(peakIndexInMountainArray(array));
        System.out.println(peakIndexInMountainArray2(array));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int i = 0;
        while (arr[i]<arr[i+1]) i++;
        return i;
    }

    //笨方法 扫描最大值
    public static int peakIndexInMountainArray2(int[] arr) {
        int maxIndex = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if (num>max){
                maxIndex = i;
                max = num;
            }
        }
        return maxIndex;
    }
}
