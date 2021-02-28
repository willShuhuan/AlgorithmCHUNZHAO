package homework;

/**
 * @author DSH
 * @date 2021/2/28
 * @description #191 位1的个数
 * facebook 苹果
 */
public class HammingWeight {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight2(n));
    }

    //方法2 位操作的小技巧
    //将n和n−1 做与运算，会把最后一个 1的位变成0
    private static int hammingWeight2(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n &= (n-1);
        }
        return count;
    }

}
