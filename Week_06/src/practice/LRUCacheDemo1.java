package practice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author DSH
 * @date 2021/3/10
 * @description LeetCode 146 LRU缓存机制
 * 字节跳动 亚马逊 facebook 微软
 */
public class LRUCacheDemo1 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println("插入顺序即是LinkedHashMap排序，先插在前，后插在后");
        System.out.println(cache);
        cache.get(1);
        System.out.println("get(1)之后1到了表尾");
        System.out.println(cache);
        cache.put(3,3);
        System.out.println(cache);
        System.out.println(cache.get(4));

    }

    //方法1 使用java提供的LinkedHashMap数据结构
    static class LRUCache extends LinkedHashMap{

        int capacity;


        public LRUCache(int capacity) {
            super(capacity,0.75f,true);
            this.capacity = capacity;

        }

        @Override
        public Object get(Object key) {
            return super.getOrDefault(key,-1);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size()>capacity;
        }
    }

}

