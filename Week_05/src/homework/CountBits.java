package homework;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/2/28
 * @description #338 比特位计数
 * 字节跳动 facebook
 */
public class CountBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    //官方题解
    private static int[] countBits(int num) {
        int[] ans = new int[num+1];
        for (int i = 0; i <= num ; i++) {
            ans[i] = popCount(i);
        }
        return ans;
    }

    private static int popCount(int num) {
        int count = 0;
        while (num != 0){
            count++;
            num &= num-1;
        }
        return count;
    }
}
