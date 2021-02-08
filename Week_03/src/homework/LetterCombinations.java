package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #17 电话号码的字母组合
 * 亚马逊
 */
public class LetterCombinations {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.equals("")) return ans;
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        search(map,digits,ans,0,"");
        return ans;
    }

    //递归回溯解决这一问题
    private static void search(Map<Character, String> map,String digits, List<String> ans,int level,String s) {
        if (level==digits.length()){
            ans.add(s);
            return;
        }
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            search(map,digits,ans,level+1,s+letters.charAt(i));
        }
    }

}
