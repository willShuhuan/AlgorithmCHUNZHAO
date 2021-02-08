package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/2/5
 * @description leetcode #78 子集问题
 * facebook 字节跳动 亚马逊
 */
public class Subsets {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(subsets(nums));
    }

    static List<Integer> t = new ArrayList<>();
    static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return list;
    }

    //todo week2 回溯算法 需要整明白
    private static void dfs(int cur, int[] nums) {
        if (cur==nums.length){
            list.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur+1,nums);
        t.remove(t.size()-1);
        dfs(cur+1,nums);

    }

}
