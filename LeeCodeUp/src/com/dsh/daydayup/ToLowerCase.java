package com.dsh.daydayup;

/**
 * @author DSH
 * @date 2021/4/1
 * @description 709 转换成小写字母
 * https://leetcode-cn.com/problems/to-lower-case/
 */
public class ToLowerCase {
    public static void main(String[] args) {
        String upCase= "LOVELY";
        System.out.println(toLowerCase(upCase));
    }

    //通过 ASCII 码表操作字符串即可。
    //a-z：97-122
    //A-Z：65-90
    //0-9：48-57
    public static String toLowerCase(String str) {
        if (str==null||str.length()==0){
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='A'&&chars[i]<='Z'){
                chars[i] += 32;
            }
        }
        return String.valueOf(chars);
    }

}
