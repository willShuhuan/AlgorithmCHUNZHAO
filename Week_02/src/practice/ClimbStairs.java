package practice;

/**
 * @author DSH
 * @date 2021/2/2
 * @description LeetCode 70 爬楼梯问题
 *
 */
public class ClimbStairs {
    public static void main(String[] args) {
//        System.out.println(climbStairs(5));
        System.out.println(climbStairs2(5));
        System.out.println(climbStairs3(5));
    }



    //方式1  递归方式 太慢 leetcode运行不通过
    public static int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    //方式二  循环迭代方式
    private static int climbStairs2(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int p = 1;//第n-2步
        int q = 2;//第n-1步
        int r = p+q;//总步数
        for (int i = 3; i < n; i++) {
            p = q;
            q = r;
            r=p+q;
        }
        return r;
    }

    //方式二 优化 优化为以下代码
    private static int climbStairs3(int n) {
        int p = 0;//第n-2步
        int q = 1;//第n-1步
        int r = 0;//总步数
        for (int i = 0; i <= n; i++) {
            p = q;
            q = r;
            r=p+q;
        }
        return r;
    }
}
