package dsh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 22 括号生成
 * @author DSH
 * @date 2020/12/8
 * @description
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    private static List<String> result;
    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate(0,0,n,"");
        return result;
    }

    public static void generate(int left, int right,int n, String s){
        //1.终止条件
        if(left==n && right==n){
            result.add(s);
            return;
        }
        //2 当前层逻辑

        //3 下探到下一层
        if (left<n){
            generate(left+1,right,n,s+"(");
        }
        if (left>right) {
            generate(left, right+1,n, s + ")");
        }

        //4 清理当前层
    }

}
