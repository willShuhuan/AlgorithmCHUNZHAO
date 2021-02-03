package homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author DSH
 * @date 2021/2/2
 * @description LeetCode 347 TopK问题
 * 字节跳动 亚马逊面试题
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,4};
//        System.out.println(Arrays.toString(getLeastNumbers(arr,3)));
        System.out.println(Arrays.toString(getLeastNumbers2(arr,3)));
    }



    //方式一 Arrays.sort排序，然后取前k个数 时间O(nlogn)
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i]=arr[i];
        }
        return result;
    }

    //方式二 堆  时间复杂度：O(nlogk) n数组长度
    private static int[] getLeastNumbers2(int[] arr, int k) {
        int[] vec = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //先向队列中加入数组中的前k个元素
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        //然后队列中的k个元素跟后len-k个元素比较，删掉队列中较大的元素，添加较小的元素
        for (int i = k; i < arr.length; i++) {
            if (queue.peek()>arr[i]){//peek 取第一个元素看一下
                queue.poll();//返回并删除第一个元素
                queue.offer(arr[i]);//删除大的，把小的加进去
            }
        }
        //最后给返回数组赋值即可
        for (int i = 0; i < k; i++) {
            vec[i] = queue.poll();
        }
        return vec;
    }

    //TODO week2 TopK问题 快排方式  学完快排回来做


}
