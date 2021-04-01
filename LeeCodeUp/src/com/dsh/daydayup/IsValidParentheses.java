package com.dsh.daydayup;

import java.util.Stack;

/**
 * @author DSH
 * @date 2021/3/31
 * @description 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class IsValidParentheses {
    public static void main(String[] args) {
        String s = "[](}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if(s.isEmpty()||s==null) return false;
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : charArray){
            if(c=='(') stack.push(')');
            else if(c=='[') stack.push(']');
            else if(c=='{') stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
