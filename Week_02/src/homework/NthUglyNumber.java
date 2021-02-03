package homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author DSH
 * @date 2021/2/2
 * @description  #264或剑指offer#49 丑数
 * 字节条动面试题
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1407));
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //默认情况，小根堆 从小到大 -1小于 0等于 1大于，如果是1就需要交换o1和o2
                //o1 前一个元素; o2 下一个元素
                return o1-o2;
//                return o2-o1;//改写compare逻辑，现在是大根堆了 从大到小
            }
        });
    }

    //方法一 预计算1690个丑数出来
    public static int nthUglyNumber(int n){
        return new Ugly().nums[n-1];
    }

    //TODO week2 丑数 动态规划算法解决
}

class Ugly{
    //预计算1690个丑数，用到了数组、堆、和哈希表
    int[] nums = new int[1690];
    public Ugly() {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        heap.offer(1L);
        int[] primes = {2,3,5};
        long ugly,newUgly;
        for (int i = 0; i < 1690; i++) {
            //这里利用优先队列默认小根堆先弹出最小元素的特性
            ugly = heap.poll();
            nums[i] = (int)ugly;
            for (int j = 0; j < primes.length; j++) {
                newUgly = ugly*primes[j];
                if (!set.contains(newUgly)){
                    set.add(newUgly);
                    heap.offer(newUgly);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}