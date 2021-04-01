package practice;

/**
 * @author DSH
 * @date 2021/4/1
 * @description  8 字符串转换整数 中等
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class MyAtoi {
    public static void main(String[] args) {
//        System.out.println(myAtoi("   -157"));
        System.out.println(myAtoi("   "));
    }

    public static int myAtoi(String s){
        int sign = 1;//符号
        int index = 0;//字符串扫描索引
        int total = 0;//绝对值
        //1. 空处理
        if (s==null||s.length()==0){
            return 0;
        }
        //2. 空格处理 索引后移
        while(index<s.length()&&s.charAt(index)==' '){
            index++;
        }
        //3、如果已经遍历完成（针对极端用例 "      "）
        if (index==s.length()){
            return 0;
        }

        //4. 符号处理
        while(s.charAt(index)=='+'||s.charAt(index)=='-'){
            sign = s.charAt(index)=='+'? 1 : -1;
            index ++;
        }
        //4 .处理数字
        while(index < s.length()){
            int digit = s.charAt(index) - '0';
            if(digit<0||digit>9){
                break;
            }
            //4.1 处理溢出
            if (Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE % 10 < digit){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            //4.2 合法情况下 转换
            total = total*10+digit;
            index++;
        }



        return sign*total;
    }

}
