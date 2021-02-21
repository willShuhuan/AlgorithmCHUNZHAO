package homework;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #55 跳跃游戏
 * 亚马逊 华为 facebook
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJump(nums2));
    }

    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i>k) return false;
            k = Math.max(k,i+nums[i]);
        }
        return true;
    }

}
