package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author DSH
 * @date 2021/3/31
 * @description 字符串中的第一个唯一字符串
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s1 =  "leetcode";
        String s2 =  "loveleetcode";
        System.out.println(firstUniqChar(s1));
        System.out.println(firstUniqChar2(s1));
        System.out.println(firstUniqChar(s2));
    }

    //利用先进先出特性，弹出的一定是先出现的不重复字符位置
    public static int firstUniqChar(String s) {
        if (s==null|s.isEmpty()) return -1;
        Map<Character,Integer> map = new HashMap<>();//存储每个字符位置，如有重复
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.toCharArray()[i];
            if (map.containsKey(ch)){//重复字符，从队列中删掉
                map.put(ch,-1);
                while (!queue.isEmpty()&&map.get(queue.peek().ch)==-1){
                    queue.poll();
                }
            }else {
                map.put(ch,i);
                queue.offer(new Pair(ch,i));
            }
        }

        return queue.isEmpty()?-1:queue.poll().pos;

    }

    //方法2  利用哈希表
    public static int firstUniqChar2(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    static class Pair{
        char ch;
        int pos;

        public Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }

}
