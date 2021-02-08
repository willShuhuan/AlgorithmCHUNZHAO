package practice;

/**
 * @author DSH
 * @date 2021/2/5
 * @description leetcode #50 幂运算问题
 * facebook
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2,-5));
        System.out.println(myPow2(2,-5));
    }



    //时间复杂度O(logN)  在leetcode上超时
    public static double myPow(double x, int n) {
        int N = n;
        if (N<0){
            N = -N;
        }
        if (N==1){
            return x;
        }
        double res = 1.0;
        double half = myPow(x,N/2);
        if (N>0){
            res = half*half;
            if (N%2==1){
                res *= x;
            }
        }
        return n>0?res:1.0/res;
    }


    //方法2 循环遍历
    private static double myPow2(double x, int n) {
        long N = n;
        return N>=0 ? quickMul(x,N) : 1.0/quickMul(x,-N);
    }

    private static double quickMul(double x, long n) {
        double ans = 1.0;
        double x_contibute = x;
        while (n>0){
            System.out.println(n);
            if (n%2==1){
                ans *= x_contibute;
            }
            x_contibute *= x_contibute;
            n /= 2;
        }
        return ans;
    }


}
