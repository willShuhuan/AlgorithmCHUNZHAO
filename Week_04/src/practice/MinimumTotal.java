package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DSH
 * @date 2021/2/22
 * @description #120 三角形最小路径和
 * 亚马逊 苹果 字节跳动
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> line1 = new ArrayList<>();
        List<Integer> line2 = new ArrayList<>();
        List<Integer> line3 = new ArrayList<>();
        List<Integer> line4 = new ArrayList<>();
        line1.add(2);
        triangle.add(line1);
        line2.add(3);
        line2.add(4);
        triangle.add(line2);
        line3.add(6);
        line3.add(5);
        line3.add(7);
        triangle.add(line3);
        line4.add(4);
        line4.add(1);
        line4.add(8);
        line4.add(3);
        triangle.add(line4);
        System.out.println(minimumTotal(triangle));
    }

    //todo week4 三角形最小路径和 不是太理解
    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m+1][m+1];
        for (int i = m-1; i >= 0 ; i--) {
            for (int j = 0; j <= i ; j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

}
