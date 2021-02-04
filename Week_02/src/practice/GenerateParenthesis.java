package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/2/2
 * @description  LeetCode #22 括号生成
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }

    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0,0,n,"",result);
        return result;
    }

    //注意：
    //左括号随时可以加，只要别超过n个, 即left<n
    //右括号必须加在左括号的右边, 即left>right
    private static void generate(int left, int right, int n, String s,List<String> list) {
        System.out.println(s);
        //终止条件
        if (left==n&&right==n){
            //凑够6个括号就添加到结果集中
            System.out.println(s);
            list.add(s);
            return;
        }
        //处理当前层逻辑
        //下探到下一层
        if (left<n){
            generate(left+1,right,n,s+"(",list);
        }
        if (left>right){
            generate(left,right+1,n,s+")",list);
        }
        //清理当前层
    }
}
