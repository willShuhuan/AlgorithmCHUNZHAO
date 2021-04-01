package com.dsh.daydayup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author DSH
 * @date 2021/4/1
 * @description
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = " the sky is blue  ";
        System.out.println(reverseWords(s));
    }

    //利用库函数解决战斗
    public static String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ",wordList);
    }

}
