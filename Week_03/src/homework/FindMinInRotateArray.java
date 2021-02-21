package homework;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #153 寻找旋转排序数组中的最小值
 * 亚马逊 微软 字节跳动
 */
public class FindMinInRotateArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,2,3};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        if (nums.length==1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        //数组未发生旋转，返回第一个元素
        if (nums[right]>nums[0]) return nums[0];
        while(left<right){
            int mid = left + (right-left)/2;
            //找到了变化点
            if (nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            //左区间有序，在右区间找
            if (nums[mid]>nums[0]){
                left = mid+1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
