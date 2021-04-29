package com.dsh.daydayup;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/4/15
 * @description 905 按奇偶排序数组
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] array = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(array)));
    }

    public static int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2==0){
                ans[j++] = A[i];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2==1){
                ans[j++] = A[i];
            }
        }
        return ans;
    }
}
