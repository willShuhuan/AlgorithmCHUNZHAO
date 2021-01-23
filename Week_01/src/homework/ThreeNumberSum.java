package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DSH
 * @date 2021/1/21
 * @description 三数之和 leetCode #15
 */
public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] arr = new int[] {2,1,-4,-1,-1,0};
        List<List<Integer>> result = threeSum(arr);
        System.out.println(result);
    }

    //双指针方式
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len<3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i>0&&nums[i]==nums[i-1]) continue;//去重，相同元素，上一次遍历已经处理，跳过当前循环
            int L = i+1;//左指针
            int R = len-1;//右指针
            while(L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if (sum==0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R&&nums[L]==nums[L+1]) L++;
                    while (L<R&&nums[R]==nums[R-1]) R--;
                    L++;
                    R--;
                }else if(sum<0){
                    L++;
                }else {
                    R--;
                }

            }

        }

        return result;
    }
}
