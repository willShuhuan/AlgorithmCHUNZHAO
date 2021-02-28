package practice;

/**
 * @author DSH
 * @date 2021/2/25
 * @description #231 2的幂
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        int n1 = 8;
        int n2 = 9;
        System.out.println(isPowerOfTwo(n1));
        System.out.println(isPowerOfTwo(n2));
        System.out.println(isPowerOfTwo2(n2));
        System.out.println(isPowerOfTwo3(n2));
    }

    //方法1 O(LogN)
    public static boolean isPowerOfTwo(int n){
        if (n==0) return false;
        while(n%2==0) n /= 2;
        return n==1;
    }

    //方法2 （推荐）
    // 位运算 取出二进制中最右边的1
    //首先讨论为什么 x & (x - 1) 可以将最右边的 1 设置为 0。
    //(x - 1) 代表了将 x 最右边的 1 设置为 0，并且将较低位设置为 1。
    //再使用与运算：则 x 最右边的 1 和就会被设置为 0，因为 1 & 0 = 0。
    //注意：
    // 为了解决恶心的边界问题，将int转为long
    public static boolean isPowerOfTwo2(int n){
        if (n==0) return false;
        long x = (long)n;
        return (x&(x-1)) == 0;
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
