package practice;

/**
 * @author DSH
 * @date 2021/2/23
 * @description #198 打家劫舍
 * 字节 谷歌 亚马逊
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
        System.out.println(rob2(nums));
    }

    //方法1
    public static int rob(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }


    private static int rob2(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int len = nums.length;
        int[][] a = new int[len][2];
        a[0][0] = 0;//不偷
        a[0][1] = nums[0];//偷
        for (int i = 1; i < len; i++) {
            a[i][0] = Math.max(a[i-1][0],a[i-1][1]);
            a[i][1] = a[i-1][0]+nums[i];
        }
        return Math.max(a[len-1][0],a[len-1][1]);
    }

}
