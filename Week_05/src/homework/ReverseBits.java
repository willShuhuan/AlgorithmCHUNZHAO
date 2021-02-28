package homework;

/**
 * @author DSH
 * @date 2021/2/28
 * @description 颠倒二进制位 #190
 * 苹果
 */
public class ReverseBits {
    public static void main(String[] args) {
        // 二进制表示 00000010100101000001111010011100
        int n = 43261596;
        System.out.println(reverseBits(n));//   964176192 (00111001011110000010100101000000)
    }

    //题解 https://leetcode-cn.com/problems/reverse-bits/solution/si-lu-fen-xi-190-ti-dian-dao-er-jin-zhi-r3wy6/
    private static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;//左移
            result += 1&n;//与运算获取 n的二进制末位值 result更新首位的值
            n >>= 1; //n右移获取下一位
        }
        return result;
    }


}
