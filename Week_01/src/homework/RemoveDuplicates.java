package homework;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/1/22
 * @description #26 删除排序数组中的重复项
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int arr[] = {0,1,1,2,2,3,3,4};
//        int arr[] = null;
        int newLen = removeDuplicates(arr);
        System.out.println("去重后的数组长度为=="+newLen);
        System.out.println("去重后的数组为=="+Arrays.toString(arr));
    }

    //双指针思路
    private static int removeDuplicates(int[] arr) {
        if ( arr==null || arr.length==0){
            return 0;
        }
        int len = arr.length;
        int i = 0;
        int j = 1;
        while(j<len){
            if (arr[i]!=arr[j]){
                if(j-i>1){
                    arr[i+1]=arr[j];
                }
                i++;
            }else {
                j++;
            }
        }
        return i+1;
    }

    //方法2 双指针  代码不同而已
    private static int removeDuplicates2(int[] arr) {
        if ( arr==null || arr.length==0){
            return 0;
        }
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[slow]!=arr[fast]){
                slow++;
                arr[slow]=arr[fast];
            }
        }
        return slow+1;
    }

}
