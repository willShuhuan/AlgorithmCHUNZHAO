package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #78 子集问题
 */
public class Subsets {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);
    }


    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums,subset,0,ans);
        return ans;
    }

    private static void dfs(int[] nums, List<Integer> subset,int level,List<List<Integer>> ans) {
        if (level==nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[level]);
        dfs(nums,subset,level+1,ans);
        subset.remove(subset.size()-1);
        dfs(nums,subset,level+1,ans);

    }

}
