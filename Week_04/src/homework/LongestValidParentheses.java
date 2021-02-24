package homework;

/**
 * @author DSH
 * @date 2021/2/23
 * @description #32 最长有效括号
 * 字节跳动 亚马逊 微软
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }

    //todo week4 最长有效括号 整不明白 放弃
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)==')'){
                if (s.charAt(i-1)=='('){
                    dp[i] = i>=2?dp[i-2]+2:2;
                }else if (i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i] = dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                }
                maxans = Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }

}
