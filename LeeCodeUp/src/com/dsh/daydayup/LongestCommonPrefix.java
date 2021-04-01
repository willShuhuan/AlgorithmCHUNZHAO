package com.dsh.daydayup;

/**
 * @author DSH
 * @date 2021/4/1
 * @description 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    //列扫描的方式
    //flower
    //flow
    //flight
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
//                i==strs[j].length() 不能越界
                if (i==strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

}
