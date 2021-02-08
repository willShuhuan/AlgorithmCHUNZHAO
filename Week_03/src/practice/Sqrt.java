package practice;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #69 x的平方根
 * 字节跳动 微软 亚马逊
 */
public class Sqrt {
    public static void main(String[] args) {
        int ans = sqrt(9);
        System.out.println("ans=="+ans);
        int ans2 = sqrt2(24);
        System.out.println("ans2=="+ans2);
    }

    //方法一 二分思想
    private static int sqrt(int x) {
        long left = 0;
        long right = x/2+1;// 为了照顾 0 1 2 3 的情况
        while (left<right){
            long mid = left+(right-left+1)/2;
            long square = mid*mid;
            if (square > x){
                right = mid-1;
            }else {
                left = mid;
            }
        }
        return (int)left;
    }

    //方法二 牛顿法 效率更高 推荐
    private static int sqrt2(int a) {
        long x = a;
        while (x*x>a){
            x = (x+a/x)/2;
        }
        return (int)x;
    }


}
