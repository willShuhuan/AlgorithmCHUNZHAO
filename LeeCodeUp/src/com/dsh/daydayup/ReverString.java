package com.dsh.daydayup;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/4/1
 * @description 344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverString {
    public static void main(String[] args) {
        char[] cs = {'h','e','l','l','o'};
        reverseString(cs);
        System.out.println(Arrays.toString(cs));
    }

    public static void reverseString(char[] s) {
        if (s==null) return;
        for (int i = 0,j=s.length-1; i < j; i++,j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
