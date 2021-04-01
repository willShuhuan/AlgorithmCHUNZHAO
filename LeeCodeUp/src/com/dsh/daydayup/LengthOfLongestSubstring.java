package com.dsh.daydayup;

import java.util.HashMap;

/**
 * @author DSH
 * @date 2021/4/1
 * @description 3 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    //滑动窗口解法
    //https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
    public static int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
