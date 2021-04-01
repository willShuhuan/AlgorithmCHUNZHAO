package practice.sort;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/3/25
 * @description 快速排序 不稳定排序 O(nLogn)
 * https://shimo.im/docs/TX9bDbSC7C0CR5XO
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2,6,3,7,1,0,9,5};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] arr,int left,int right) {
        if (left>=right) return;
        int pivot = partion(arr,left,right);//找到基准点坐标
        quickSort(arr,left,pivot-1);//左边
        quickSort(arr,pivot+1,right);//右边
    }

    //以数组右侧的数作为基准数
    private static int partion(int[] arr, int left, int right) {
        int pivot = right;//基准值坐标
        int counter = left;//记录小于基准值的元素个数
        for (int i = left; i < right; i++) {
            if(arr[i]<arr[pivot]){
                swap(arr,i,counter);
                counter++;
            }
        }
        System.out.println(counter);
        swap(arr,pivot,counter);
        System.out.println("----"+Arrays.toString(arr));
        return counter;
    }

    private static void swap(int[] arr, int i, int counter) {
        int temp = arr[i];
        arr[i] = arr[counter];
        arr[counter] = temp;
        System.out.println(Arrays.toString(arr));
    }
}
