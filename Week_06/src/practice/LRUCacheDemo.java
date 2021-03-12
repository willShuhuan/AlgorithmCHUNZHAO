package practice;

import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * @author DSH
 * @date 2021/3/10
 * @description
 */
public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache);
        System.out.println(cache.get(2));
        System.out.println(cache);
        cache.put(3,3);
        System.out.println(cache);
        System.out.println(cache.get(4));
    }
}

//方法2 双向链表+哈希表
class LRUCache{
    private HashMap<Integer,Node> map;
    public DoubleList cache;
    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        int val = map.get(key).val;
        put(key,val);
        return val;
    }

    public void put(int key, int val) {
        Node x = new Node(key,val);
        if (map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key,x);
        }else {
            if (capacity==cache.size()){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key,x);
        }
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                ", cache=" + cache +
                ", capacity=" + capacity +
                '}';
    }
}

class Node{
    public int key,val;
    public Node next,prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", val=" + val +
                '}';
    }
}

class DoubleList{
    // 使用伪头部和伪尾部节点
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int size;

    public DoubleList() {
        this.size = 0;
        head.next = tail;
        tail.prev = head;
    }

    //添加头节点
    public void addFirst(Node x){
        Node headNext = head.next;
        head.next = x;
        headNext.prev = x;
        x.prev = head;
        x.next = headNext;
        size++;
    }

    //删除链表中的x节点
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //删除链表中的最后一个节点
    public Node removeLast(){
        Node last = tail.prev;
        remove(last);
        return last;
    }

    //返回链表长度
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "DoubleList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}