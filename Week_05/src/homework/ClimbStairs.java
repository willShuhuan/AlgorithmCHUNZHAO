package homework;

/**
 * @author DSH
 * @date 2021/2/28
 * @description leetcode70 爬楼梯问题
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStaris(3));
        System.out.println(climbStaris2(3));
    }



    //动态规划求解
    private static int climbStaris(int n) {
        if (n<3) return n;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //循环迭代的方式
    private static int climbStaris2(int n) {
        if (n<3) return n;
        int p = 1;
        int q = 2;
        int r = p+q;
        for (int i = 3; i < n; i++) {
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

}
