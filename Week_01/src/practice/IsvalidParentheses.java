package practice;

import java.util.Stack;

/**
 * @author DSH
 * @date 2021/2/4
 * @description 有效的括号 LeetCode #20
 * 亚马逊等
 */
public class IsvalidParentheses {
    public static void main(String[] args) {
        String s = "()";
        String s2 = "[()]{}";
        String s3 = "()]";
//        System.out.println(isValidP(s));
        System.out.println(isValidP(s2));
        System.out.println(isValidP(s3));
    }

    //利用栈 括号具有对称性
    private static boolean isValidP(String s) {
        if (s.isEmpty()||s==null){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='(') stack.push(')');
            else if (c=='[') stack.push(']');
            else if (c=='{') stack.push('}');
            else if (stack.isEmpty()||c!=stack.pop()) return false;
        }
        return stack.empty();
    }
}
