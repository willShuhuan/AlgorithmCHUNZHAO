package practice;

/**
 * @author DSH
 * @date 2021/3/31
 * @description  找不同
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class FindTheDifference {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";//t基于s重排  且添加一个字母 所以t的长度更长
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        int[] R = new int[26];
        for (int i = 0; i < s.length(); i++) {
            R[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            R[t.charAt(i)-'a']--;
            if (R[t.charAt(i)-'a']<0){
                return t.charAt(i);
            }
        }
        return ' ';
    }

}
