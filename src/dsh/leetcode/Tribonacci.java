package dsh.leetcode;

/** LeetCode 1137 泰波那契数
 * @author DSH
 * @date 2020/12/9
 * @description
 */
public class Tribonacci {

    public static void main(String[] args) {
        System.out.println(tribonacci(6));
    }

    public static int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        //循环迭代的方式，令a=T(n-3) b=T(n-2) c=T(n-1)
        //每次迭代将abc交换
        int a=0,b=1,c=1;
        for(int i = 3;i<n;i++){
            int temp = a;
            a = b;
            b = c;
            c = a+b+temp;
        }
        return a+b+c;
    }
}
