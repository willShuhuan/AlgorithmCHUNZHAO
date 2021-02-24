package homework;

/**
 * @author DSH
 * @date 2021/2/23
 * @description #647 回文子串
 * facebook 苹果 字节跳动
 */
public class CountSubstrings {
    public static void main(String[] args) {
       String s = "abcba";
        System.out.println(countSubStrings(s));
    }

    private static int countSubStrings(String s) {
        if (s==null||s.length()==0) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = n;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        //从右下角开始遍历
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    //i和j相邻的情况 如cbbd bb也是一个回文子串
                    if (j-i==1) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) result++;
            }
        }
        return result;
    }
}
