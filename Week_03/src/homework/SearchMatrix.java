package homework;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #74 搜索二维矩阵
 * 亚马逊 微软 facebook
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix2(matrix, 30));
    }

    //二分查找法 最优解
    private static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m==0) return false;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;
        int pivotIdx,pivotElement;
        while (left<=right){
            pivotIdx = (left+right)/2;
            pivotElement = matrix[pivotIdx/n][pivotIdx%n];
            if (pivotElement==target) return true;
            if (pivotElement<target){
                left = pivotIdx+1;
            }else {
                right = pivotIdx-1;
            }
        }
        return false;

    }

    //线性查找 算了吧
    private static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] line = matrix[i];
            if (target>=line[0]&&target<=line[line.length-1]){
                for (int j = 0; j < line.length; j++) {
                    if (target == line[j]) return true;
                }
            }
        }
        return false;
    }
}
