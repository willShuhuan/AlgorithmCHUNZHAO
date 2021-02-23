package practice;

/**
 * @author DSH
 * @date 2021/2/21
 * @description
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(6, new int[7]));
    }

    //记忆化搜索  memory数组记录 使得时间复杂度由2的n次方变为了n
    private static int fib(int n, int[] memo) {
        if (n<=1){
            return n;
        }
        if (memo[n]==0){
            memo[n] = fib(n-1,memo)+fib(n-2,memo);
        }
        return memo[n];
    }
}
