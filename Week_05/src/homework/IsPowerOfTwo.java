package homework;

/**
 * @author DSH
 * @date 2021/2/28
 * @description #231 2的幂
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        int n1 = 8;
        int n2 = 9;
        System.out.println(isPowerOfTwo(n1));
        System.out.println(isPowerOfTwo(n2));
        System.out.println(isPowerOfTwo3(n2));
    }

    //方法1 O(LogN)
    public static boolean isPowerOfTwo(int n){
        if(n==0) return false;
        while(n%2==0) n /= 2;
        return n==1;
    }


    //方法3 左移计算int中2的所有幂次方 1，2，4...1073741824,如果与n相等，就true 否则fasle
    public static boolean isPowerOfTwo3(int n) {
        int tmp = 1;
        for (int i = 0; i < 31; i++) {
            if (tmp == n) {
                return true;
            }
            tmp <<= 1;
        }
        return false;
    }

}
