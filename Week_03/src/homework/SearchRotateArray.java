package homework;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #33 搜索旋转排列数组
 * facebook 字节跳动 亚马逊
 */
public class SearchRotateArray {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int result = search(arr,1);
        System.out.println(result);
    }

    //二分法 O(LogN) TODO week3 搜索旋转排列数组 不太理解
    private static int search(int[] nums,int target) {
        int len = nums.length;
        if(len==0) return -1;
        int left = 0;
        int right = len - 1;
        while (left<right){
            int mid = left+(right-left+1)/2;
            //右区间有序
            if (nums[mid]<nums[right]){
                //目标在 mid-right 有序区间
                if (nums[mid]<=target&&target<=nums[right]){
                    left = mid;
                }else {//目标在 left ~ mid-1 区间
                    right = mid - 1;
                }
            }else {//左区间有序
                //目标在 left ~ mid-1 有序区间
                if (nums[left]<=target&&target<=nums[mid-1]){
                    right = mid - 1;
                }else {//目标在 mid ~ right 区间
                    left = mid;
                }
            }
        }
        if (nums[left]==target){
            return left;
        }
        return -1;
    }


}
