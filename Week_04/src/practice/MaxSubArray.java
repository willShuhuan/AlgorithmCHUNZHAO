package practice;

/**
 * @author DSH
 * @date 2021/2/22
 * @description #53 最大子序和
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    //todo week4 最大子序和
    public static int maxSubArray(int[] nums){
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum>0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

}
