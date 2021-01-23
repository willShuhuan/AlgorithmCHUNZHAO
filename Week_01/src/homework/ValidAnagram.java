package homework;

import java.util.Arrays;

/**
 * @author DSH
 * @date 2021/1/23
 * @description #242 有效的字母异位词
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
//        System.out.println(isAnagram(s,t));
        System.out.println(isAnagram2(s,t));
    }



    //方法1 char数组排序
    // 虽然这个方法看起来简单，但是效率更高（时间复杂度方面）
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for (int i = 0; i < sc.length; i++) {
            if (sc[i]!=tc[i]){
                return false;
            }
        }
        return true;
    }

    //方法2 哈希映射
    private static boolean isAnagram2(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i)-'a']++;//把出现的字母映射到alpha数组中，每次出现+1
            alpha[t.charAt(i)-'a']--;//把出现的字母映射到alpha数组中，每次出现-1
        }
        //如果出现的字母一样，那么alpha中所有元素都应该为0，利用这一点判断
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i]!=0){
                return false;
            }
        }
        return true;
    }

}
