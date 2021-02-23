package homework;

/**
 * @author DSH
 * @date 2021/2/23
 * @description #64 最小路径和
 * 亚马逊 高盛 谷歌
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        if(grid.length==0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i==0&&j==0) continue;
                else if (i==0) grid[i][j] = grid[i][j-1]+grid[i][j];
                else if (j==0) grid[i][j] = grid[i-1][j]+grid[i][j];
                else grid[i][j] = Math.min(grid[i][j-1],grid[i-1][j])+grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
