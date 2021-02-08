package practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #433 最小基因变化
 */
public class MinMutation {

    public static void main(String[] args) {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC","AAACCCCC","AACCCCCC"};
        System.out.println(minMutation(start,end,bank));
    }

    //TODO week3 最小基因变化 不理解
    public static int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) return -1;
        char[] four = {'A','C','G','T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);
        int step = 0;
        while (!queue.isEmpty()){
            step++;
            for (int count = queue.size(); count > 0 ; --count) {
                char[] tempStringChars = queue.poll().toCharArray();
                for (int i = 0,len = tempStringChars.length; i < len; i++) {
                    char oldChar = tempStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        tempStringChars[i] = four[j];
                        String newGeneric = new String(tempStringChars);
                        if (end.equals(newGeneric)){
                            return step;
                        }else if (set.contains(newGeneric)){
                            set.remove(newGeneric);
                            queue.offer(newGeneric);
                        }
                    }
                    tempStringChars[i] = oldChar;
                }
            }
        }
        return -1;
    }

}
