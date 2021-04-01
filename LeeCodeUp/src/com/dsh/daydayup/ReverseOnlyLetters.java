package com.dsh.daydayup;

/**
 * @author DSH
 * @date 2021/4/1
 * @description
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));
    }

    public static String reverseOnlyLetters(String s) {
        int right = s.length()-1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                while(!Character.isLetter(s.charAt(right))){
                    right --;
                }
                sb.append(s.charAt(right));
                right--;

            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
