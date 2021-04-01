package com.dsh.daydayup;

import java.util.LinkedList;

/**
 * @author DSH
 * @date 2021/3/31
 * @description 字符串解码
 * https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[bc]]";
        System.out.println(decodeString(s));
    }

    //题解 https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
    public static String decodeString(String s) {
        if (s==null||s.isEmpty()) return null;
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<Integer>();//数字栈
        LinkedList<String> stack_res = new LinkedList<>();//字母栈
        for (char c : s.toCharArray()){
            if (c=='['){//进入一个新的逻辑，清空multi和res
                stack_multi.add(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if(c==']'){//拼接括号内部的字母
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();//当前括号外的数数字
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast()+tmp);
            }else if (c >= '0'&&c<='9'){
                multi = multi*10+Integer.parseInt(c+"");//考虑到29[c]这种，上一数字位*10
            }else {
                res.append(c);//字母直接append
            }
        }
        return res.toString();

    }

}
