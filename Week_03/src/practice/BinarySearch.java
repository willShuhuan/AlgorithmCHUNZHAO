package practice;

/**
 * @author DSH
 * @date 2021/2/7
 * @description 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10,14,19,26,27,31,33,35,42,44};
        System.out.println(binarySearch(arr, 42));
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if (arr[mid]==target){
                return mid;
            }
            if (arr[mid]>target){
                right = mid-1;
            }
            if (arr[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }
}
