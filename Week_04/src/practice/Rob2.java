package practice;

/**
 * @author DSH
 * @date 2021/2/23
 * @description #213 打家劫舍2
 * 字节跳动
 */
public class Rob2 {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        int[] nums2 = {1,2,3,1};
        System.out.println(rob(nums));
        System.out.println(rob(nums2));
    }

    public static int rob(int[] nums){
        if (nums==null||nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int result = myRob(nums,0,nums.length-2);//不包含最后一个房子
        int result2 = myRob(nums,1,nums.length-1);//不包含第一个房子
        return Math.max(result,result2);
    }

    private static int myRob(int[] nums, int start, int end) {
        if (start==end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }

}
