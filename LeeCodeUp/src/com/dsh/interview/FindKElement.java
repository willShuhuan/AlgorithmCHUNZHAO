package com.dsh.interview;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/4/2
 * @description  leetcode 215 数组中的第K个最大元素
 * 2021字节真题  乱序可重复数组中，找到第K大的数字
 */
public class FindKElement {
    public static void main(String[] args) {
//        int[] arr = {3,2,5,4,9,0,1,7};
        int[] arr = {3,2,1,5,6,4};
//        System.out.println(findKthElement(arr, 5));
        System.out.println(findKthElement2(arr, 2));
    }

    //奇技淫巧 库函数 3ms 超过62.77%
    public static int findKthElement(int[] arr, int k){
        if (k>arr.length) return -1;
        Arrays.sort(arr);
        return arr[arr.length-k];
    }

    //快排返回 140ms  超过6%
    public static int findKthElement2(int[] arr, int k){
//        Sort.quickSort(arr,0,arr.length-1);
        Sort.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        return arr[arr.length-k];
    }


}

//顺便把各种排序复习一下
class Sort{
    public static void main(String[] args) {
        int[] arr = {3,2,5,4,9,0,1,7};
        quickSort(arr,0,arr.length-1);
        slectionSort(arr);
        mergeSort(arr,0,arr.length-1);
        insertionSort(arr);
    }

    //选择排序
    //每次找到最小的元素放在排序序列的起始位置
    public static void slectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

    //todo 插入排序咋还整不明白了呢
    //插入排序
    //构建有序序列 对于未排序数据，在已排序序列中从后向前臊面，找到响应位置并插入
    public static void insertionSort(int[] arr) {
        int len = arr.length;
        int insertVal,insertIndex;
        for (int i = 1; i < len; i++) {
            insertVal = arr[i];
            insertIndex = i-1;
            while (insertIndex>=0&&arr[insertIndex]>insertVal){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
        }
    }

    //归并排序
    //该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；
    // 即先使每个子序列有序，再使子序列段间有序。
    public static void mergeSort(int[] arr,int left,int right) {
        if (left>=right) return;
        int mid = (left+right)>>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right-left+1];
        int k = 0;
        int i = left,j=mid+1;
        while (i<=mid&&j<=right){
            if (arr[i]<arr[j]){
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }
        while (i<=mid){
            tmp[k++] = arr[i++];
        }
        while (j<=right){
            tmp[k++] = arr[j++];
        }
        for (int p = 0; p < tmp.length; p++) {
            arr[left+p] = tmp[p];
        }
        System.out.println(Arrays.toString(arr));

    }

    //快速排序
    //通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
    // 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
    public static void quickSort(int[] arr,int left,int right) {
        if (left>=right) return;
        int pivot = partion(arr,left,right);
        quickSort(arr,left,pivot-1);
        quickSort(arr,pivot+1,right);
    }

    private static int partion(int[] arr, int left, int right) {
        int pivot = arr[right];
        int counter = left;
        for (int i = left; i < right; i++) {
            if (arr[i]<pivot){
                swap(i,counter,arr);
                counter++;
            }
        }
        swap(counter,right,arr);
        return counter;
    }

    private static void swap(int i, int counter, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[counter];
        arr[counter] = tmp;
    }
}