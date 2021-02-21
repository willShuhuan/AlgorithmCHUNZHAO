package homework;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #45 跳跃游戏2
 * 亚马逊 华为 字节跳动
 */
public class CanJump2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4,2,1};
        int step = jump(nums);
        System.out.println(step);
    }

    //TODO week3 贪心算法解决跳跃问题 不太理解
    private static int jump(int[] nums) {
        int end = 0;//当前能跳的边界
        int maxPosition = 0;//能跳到最远的位置
        int steps = 0;//步数
        for (int i = 0; i < nums.length-1; i++) {
            //找到能跳的最远的
            maxPosition = Math.max(maxPosition,nums[i]+i);
            if (i==end){//遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


}
