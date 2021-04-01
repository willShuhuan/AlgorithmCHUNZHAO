package com.dsh.daydayup;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author DSH
 * @date 2021/4/1
 * @description 单词规律
 * https://leetcode-cn.com/problems/word-pattern/solution/dan-ci-gui-lu-by-leetcode-solution-6vqv/
 */
public class WordPartern {

    public static void main(String[] args) {
//        String pattern = "abba";
//        String str = "dog cat cat dog";
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(wordPattern(pattern, str));
    }

    //根据hashmap特性；如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。
    public static boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        if (pattern.length()!=word.length) return false;
        Map<Object,Integer> map = new HashMap<>();
        for (int i = 0; i < word.length; i++) {
            Integer put = map.put(pattern.charAt(i), i);
            Integer put2 = map.put(word[i], i);
            //int 类型转化 Integer 时相当于 new Integer()，在小于 127 时从常量池中取，是同一个对象，大于等于 128 用 == 判断，得到false
            //所以不能用 "==" 判断，所以用用Objects的equals方法增强判断
//            if (put!=put2) return false;
            if (!Objects.equals(put,put2)) return false;

        }
        return true;
    }

}
