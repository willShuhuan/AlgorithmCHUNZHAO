package practice;

/**
 * @author DSH
 * @date 2021/2/25
 * @description 颠倒二进制位 #190
 * 苹果
 */
public class ReverseBits {
    public static void main(String[] args) {
        // 二进制表示 00000010100101000001111010011100
        int n = 43261596;
        System.out.println(reverseBits(n));//   964176192 (00111001011110000010100101000000)
    }

    private static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += 1&n;
            n >>= 1;
        }
        return result;
    }


}
