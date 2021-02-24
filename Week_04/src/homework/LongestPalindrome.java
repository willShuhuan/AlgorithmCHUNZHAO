package homework;

/**
 * @author DSH
 * @date 2021/2/24
 * @description #5 最长回文子串
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s==null||s.length()==0) return "";
        if (s.length()<2) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int begin=0,maxLen=1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = len-1; i >=0 ; i--) {
            for (int j = i+1; j < len; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i==1) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j-i+1>=maxLen){
                    begin = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

}
