package homework;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/3/26
 * @description #493  翻转对
 * 字节跳动
 */
public class ReversePairs {

    public static void main(String[] args) {
        int[] arr = {2,4,3,5,1};
//        int[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(arr));
        System.out.println(reversePairs2(arr));
    }

    //傻循环  超出时间限制
    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if ((long)nums[i]>(long)nums[j]*2){
                    count++;
                }
            }
        }
        return count;
    }


    //方式二  归并排序
    //https://leetcode-cn.com/problems/reverse-pairs/solution/cjavapython3-gui-bing-pai-xu-by-yanghk/
    private static int reversePairs2(int[] arr) {
        if (arr.length==0) return 0;
        int[] sortedNums = new int[arr.length];
        return mergeSort(arr,0,arr.length-1,sortedNums);
    }

    private static int mergeSort(int[] arr, int left, int right, int[] sortedNums) {
        if (left==right) return 0;
        int mid = left+(right-left)/2;
        int res = mergeSort(arr,left,mid,sortedNums)+
                mergeSort(arr,mid+1,right,sortedNums)+
                findReversePairs(arr,left,right);
        //原数组排序 -- start --
        int i = left,j=mid+1,k=left;
        while (i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                sortedNums[k++] = arr[i++];
            }else {
                sortedNums[k++] = arr[j++];
            }
        }
        while(i<=mid){
            sortedNums[k++] = arr[i++];
        }
        while (j<=right){
            sortedNums[k++] = arr[j++];
        }
        //原数组重新赋值
        for (int ind = left; ind <=right ; ind++) {
            arr[ind] = sortedNums[ind];
        }
        System.out.println("中间结果数组=="+ Arrays.toString(arr));
        //原数组排序 -- end --
        return res;
    }

    private static int findReversePairs(int[] arr, int left, int right) {
        int res = 0,mid = left+(right-left)/2;
        int i = left,j=mid+1;
        for (;i<=mid;i++){
            while (j<=right&&(long)arr[i]>2*arr[j]){
                res += mid-i+1;
                j++;
            }
        }
        return res;
    }

}
