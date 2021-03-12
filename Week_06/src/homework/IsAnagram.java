package homework;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/3/11
 * @description #242 有效的字母异位
 * facebook  谷歌 亚马逊
 */
public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram2(s, t));
    }

    //方式1：排序
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc,tc);
    }

    //方式2：哈希表映射
    private static boolean isAnagram2(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i)-'a']++;
            alpha[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i]!=0) return false;
        }
        return true;
    }

}
