package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DSH
 * @date 2021/1/23
 * @description #412 Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 */
public class FizzBuzz {

    public static void main(String[] args) {
//        System.out.println(fizzBuzz(15));
        System.out.println(fizzBuzz2(15));
    }



    //方法1 loop if 虽然笨笨的 但是效率还行
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i%15==0){
                list.add("FizzBuzz");
            }else if (i%5==0){
                list.add("Buzz");
            }else if (i%3==0){
                list.add("Fizz");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    // 方法2 利用HashMap
    private static List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<>();
        Map<Integer,String> map = new HashMap<Integer,String>(){
            {
                put(3,"Fizz");
                put(5,"Buzz");
            }
        };
        for (int i = 1; i <= n; i++) {
            String ans = "";
           for (Integer key : map.keySet()){
               if (i%key==0){
                   ans += map.get(key);
               }
           }
           if (ans.equals("")){
               ans = String.valueOf(i);
           }
           list.add(ans);
        }
        return list;
    }

}
