package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author DSH
 * @date 2021/3/26
 * @description #56 合并区间
 * facebook 字节跳动  亚马逊
 */
public class MergeRange {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);

        for (int i = 0; i < res.length; i++) {
            System.out.println("["+res[i][0]+","+res[i][1]+"]");
        }
    }

    //解法 排序
    //https://leetcode-cn.com/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
    public static int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (merged.size()==0||merged.get(merged.size()-1)[1]<L){
                merged.add(new int[]{L,R});
                System.out.println("中间结果合并数组-添加->merged=="+"["+L+","+R+"]");
            }else {
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],R);
                System.out.println("中间结果合并数组-调整->merged=="+"["+L+","+R+"]");
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
