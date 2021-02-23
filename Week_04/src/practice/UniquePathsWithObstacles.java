package practice;

/**
 * @author DSH
 * @date 2021/2/21
 * @description #63 不同路径2
 * 谷歌 美团 微软
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] dp = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(dp));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null||obstacleGrid.length==0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //初始化第一行和第一列
        for (int i = 0; i < m && obstacleGrid[i][0]==0; i++) {
            dp[i][0]=1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j]==0; j++) {
            dp[0][j]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

}
