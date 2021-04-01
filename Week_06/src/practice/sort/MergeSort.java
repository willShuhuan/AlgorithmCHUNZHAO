package practice.sort;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/3/25
 * @description 归并排序 - 分治 稳定 O(nlogn)
 * https://shimo.im/docs/sDXxjjiKf3gLVVAU/read
 * https://www.bilibili.com/video/BV1E4411H73v?p=69
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2,6,3,7,1,0,9,5};
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left>=right) return;
        int mid = (left+right) >> 1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int i = left;//左边有序序列初始索引
        int j = mid+1;//右边有序序列初始索引
        int k = 0;//临时数组当前索引
        while (i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
            //temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++]; 简化写法
        }
        //左边
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        //右边
        while(j<=right){
            temp[k++] = arr[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            arr[left+p] = temp[p];
        }


    }


}
