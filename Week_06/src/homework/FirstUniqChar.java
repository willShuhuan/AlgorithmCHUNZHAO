package homework;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author DSH
 * @date 2021/3/12
 * @description leetcode 387 字符串中的第一个唯一字符
 * 亚马逊 Facebook 谷歌
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar2(s));
        System.out.println(firstUniqChar3(s));
    }

    //方法一 使用哈希表存储频数
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])==1) return i;
        }
        return -1;
    }

    //方法二 哈希表映射  (推荐写法)
    private static int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int[] alpha = new int[26];
        for (int i = 0; i < chars.length; i++) {
            alpha[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (alpha[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }

    //方法3 使用队列
    private static int firstUniqChar3(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!map.containsKey(ch)){
                map.put(ch,i);
                queue.offer(new Pair(ch,i));
            }else {
                map.put(ch,-1);
                while (!queue.isEmpty()&&map.get(queue.peek().ch)==-1){
                    queue.poll();
                }
            }
        }
        return queue.isEmpty()?-1:queue.poll().pos;
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
