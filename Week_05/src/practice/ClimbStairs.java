package practice;

/**
 * @author DSH
 * @date 2021/2/25
 * @description
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs2(5));
    }



    //动态规划求解
    private static int climbStairs(int n) {
        if (n<3) return n;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //
    private static int climbStairs2(int n) {
        if (n<3) return n;
        int p = 1;//n-2步
        int q = 2;//n-1步
        int r = p+q;
        for (int i = 3; i < n; i++) {
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }


}
