package practice;

/**
 * @author DSH
 * @date 2021/2/22
 * @description
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE,imax = 1,imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i],imax*nums[i]);
            imin = Math.min(nums[i],imin*nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }
}
