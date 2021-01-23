package homework;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/1/23
 * @description #66 加一
 */
public class PlusOne {

    public static void main(String[] args) {
//        int nums[] = {5,6,2,0,0,4,6,2,4,9};
        int nums[] = {0};
        int[] result = plusOne(nums);
        System.out.println(Arrays.toString(result));
    }


    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len-1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i]!=0){
                return digits;
            }
        }
        digits = new int[len+1];
        digits[0]=1;
        return digits;
    }

}
