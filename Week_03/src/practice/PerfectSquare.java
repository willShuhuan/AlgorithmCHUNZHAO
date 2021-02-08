package practice;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #367 有效的完全平方数
 * 亚马逊
 */
public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2));
        System.out.println(isPerfectSquare(14));
    }

    //牛顿法
    public static boolean isPerfectSquare(int num) {
        if (num<2) return true;
        long a = num/2;
        while (a*a>num){
            a = (a+num/a)/2;
        }
        return a*a == num;
    }

}
