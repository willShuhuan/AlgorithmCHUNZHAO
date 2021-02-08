package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DSH
 * @date 2021/2/5
 * @description leetcode #17 电话号码的字母组合
 * 亚马逊
 */
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.equals("")) return list;
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        search(map,digits,0,"",list);
        return list;
    }

    private static void search(Map<Character,String> map,String digits, int level, String s, List<String> list) {
//        char key1 = digits.charAt(0);
//        char key2 = digits.charAt(1);
//        char[] leftArr = map.get(key1).toCharArray();
//        char[] rightArr = map.get(key2).toCharArray();
//        for (int i = 0; i < leftArr.length; i++) {
//            String r = String.valueOf(leftArr[i]);
//            for (int j = 0; j < rightArr.length; j++) {
//                list.add(r+rightArr[j]);
//            }
//        }
        if (level==digits.length()){
            list.add(s);
            return;
        }
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            search(map,digits,level+1,s+letters.charAt(i),list);
        }
    }

}
