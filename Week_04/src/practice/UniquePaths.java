package practice;

/**
 * @author DSH
 * @date 2021/2/21
 * @description #62 不同路径
 * facebook 亚马逊 微软
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                if (i==0||j==0){
                    dp[i][j]=1;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
