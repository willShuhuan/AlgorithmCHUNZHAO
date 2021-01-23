package homework;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/1/21
 * @description leetCode #283 移动零
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] arr = new int[] {2,0,1,-4,-1,0,-1};
//        moveZeros(arr);
        moveZeros2(arr);
    }

    //双指针方式，一次遍历
    private static void moveZeros(int[] arr) {
        if (arr==null){
            return;
        }
        int len = arr.length;
        int j = 0;//j指向0元素的索引
        for (int i = 0; i < len; i++) {
            if (arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //方法2
    private static void moveZeros2(int[] arr) {
        if (arr==null){
            return;
        }
        int len = arr.length;
        int j = 0;//记录非0元素个数
        for (int i = 0; i < len; i++) {
            if(arr[i]!=0){
                arr[j] = arr[i];
                j++;
            }
        }
        //数组最后len-j个元素全部替换为0
        for (int i = j; i < len; i++) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }
}
