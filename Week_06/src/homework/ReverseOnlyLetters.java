package homework;

import java.util.Stack;

/**
 * @author DSH
 * @date 2021/3/12
 * @description #917 仅仅反转字母
 * 字节跳动
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        String s2 = "Test1ng-Leet=code-Q!";
        String ans = reverseOnlyLetters(s);
        String ans2 = reverseOnlyLetters2(s2);
        System.out.println(ans);
        System.out.println(ans2);
    }

    //方式1 栈 2ms
    private static String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)){
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)){
                sb.append(stack.pop());
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


    //方式2  双指针 1ms  (推荐写法)
    private static String reverseOnlyLetters2(String s) {
        int right = s.length()-1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)){
                while (!Character.isLetter(s.charAt(right))){
                    right--;
                }
                sb.append(s.charAt(right));
                right--;
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
